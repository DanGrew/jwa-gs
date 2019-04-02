package uk.dangrew.jwags.simulation;

import java.util.ArrayList;
import java.util.List;

import javafx.util.Pair;
import uk.dangrew.jwags.mechanics.PlayerOrderCalculator;
import uk.dangrew.jwags.mechanics.VictoryCalculator;
import uk.dangrew.jwags.model.Dinosaur;
import uk.dangrew.jwags.model.DinosaurType;
import uk.dangrew.jwags.moves.DinosaurAction;

public class GameSimulation {

   private final PlayerOrderCalculator playOrder;
   private final VictoryCalculator victory;
   
   private final List< Simulation > simulations;
   
   public GameSimulation() {
      this.playOrder = new PlayerOrderCalculator();
      this.victory = new VictoryCalculator();
      this.simulations = new ArrayList<>();
   }//End Class
   
   public void simulate( Simulation simulation, Dinosaur dinosaur1, Dinosaur dinosaur2 ) {
      Pair< Dinosaur, Dinosaur > order = playOrder.determinePlayOrder( dinosaur1, dinosaur2 );
      simulateAttack( simulation, order.getKey(), order.getValue() );
      
      this.simulations.forEach( this::printResults );
      
      long raptorWins = this.simulations.stream().filter( s -> s.result().winner().type() == DinosaurType.Velociraptor ).count();
      System.out.println(  );
      System.out.println( "Raptor wins " + raptorWins + "/" + simulations.size() );
   }//End Method
   
   private void printResults( Simulation simulation ){
      for ( SimulationStage stage : simulation.stages() ) {
         System.out.println( "Attacked: " + stage.attacking().type().name() + " (" + stage.attacking().health().get() + ")" );
         System.out.println( "Defended: " + stage.defending().type().name() + " (" + stage.defending().health().get() + ")"  );
         System.out.println( "Event: " + stage.move().name() );
         System.out.println(  );
      }
      
      System.out.println();
      System.out.println( simulation.result().winner().type().name() + " wins!" );
      System.out.println( "---------------------" );
      System.out.println();
   }//End Method
   
   private void simulateAttack( Simulation simulation, Dinosaur dinosaur1, Dinosaur dinosaur2 ) {
      this.simulations.remove( simulation );
      for ( DinosaurAction move : dinosaur1.type().moves() ) {
         Simulation simForMove = simulation.copy();
         simulations.add( simForMove );
         
         SimulationStage stage = executeAndRecord( move, dinosaur1, dinosaur2 );
         simForMove.addStage( stage );
         
         simulateDefense( simForMove, stage.defending(), stage.attacking() );
      }
   }//End Method
   
   private SimulationStage executeAndRecord( DinosaurAction move, Dinosaur attacking, Dinosaur defending ){
      Dinosaur attackingDinosaurAfterMove = attacking.copy();
      Dinosaur defendingDinosaurAfterMove = defending.copy();
      
      move.execute( attackingDinosaurAfterMove, defendingDinosaurAfterMove );
      
      return new SimulationStage( 
               move, 
               attackingDinosaurAfterMove, 
               defendingDinosaurAfterMove 
      );
   }//End Method
   
   private void simulateDefense( Simulation simulation, Dinosaur dinosaur1, Dinosaur dinosaur2 ) {
      this.simulations.remove( simulation );
      for ( DinosaurAction move : dinosaur1.type().moves() ) {
         Simulation simForMove = simulation.copy();
         simulations.add( simForMove );
         
         SimulationStage stage = executeAndRecord( move, dinosaur1, dinosaur2 );
         simForMove.addStage( stage );
         
         Pair< Dinosaur, Dinosaur > victorLoser = victory.determineVictorLoser( stage.attacking(), stage.defending() );
         if ( victorLoser == null ) {
            simulate( simForMove, stage.attacking(), stage.defending() );
         } else {
            simForMove.setResult( new SimulationResult( victorLoser.getKey(), victorLoser.getValue()  ) );
         }
      }
   }//End Method

   public static void main( String[] args ) {
      new GameSimulation().simulate( new Simulation(), DinosaurType.Stegosaurus.create(), DinosaurType.Velociraptor.create() );
   }//End Method
}//End Class
