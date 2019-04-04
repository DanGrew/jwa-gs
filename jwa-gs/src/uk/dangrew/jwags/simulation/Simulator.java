package uk.dangrew.jwags.simulation;

import java.util.Optional;

import javafx.util.Pair;
import uk.dangrew.jwags.actions.logic.DinosaurAction;
import uk.dangrew.jwags.mechanics.PlayerOrderCalculator;
import uk.dangrew.jwags.mechanics.VictoryCalculator;
import uk.dangrew.jwags.model.BattlingDinosaur;

public class Simulator {

   private final PlayerOrderCalculator playOrder;
   private final VictoryCalculator victory;
   
   public Simulator() {
      this.playOrder = new PlayerOrderCalculator();
      this.victory = new VictoryCalculator();
   }//End Class
   
   public Optional< Turn > simulate( TurnActions actions ) {
      if ( !actionAvailable( actions.dinosaurs().getKey(), actions.actionForDinosaur( actions.dinosaurs().getKey() ) ) ){
         return Optional.empty();
      }
      
      if ( !actionAvailable( actions.dinosaurs().getValue(), actions.actionForDinosaur( actions.dinosaurs().getValue() ) ) ){
         return Optional.empty();
      }
      
      Turn turn = new Turn();
      
      Pair< BattlingDinosaur, BattlingDinosaur > order = playOrder.determinePlayOrder( actions.dinosaurs() );
      BattlingDinosaur faster = order.getKey();
      BattlingDinosaur slower = order.getValue();
      
      turn.beginTurn( faster, slower );
      
      DinosaurAction fasterAction = actions.actionForDinosaur( faster );
      fasterAction.execute( faster, slower );
      
      turn.fasterActionExecuted( fasterAction, faster, slower );
      
      Pair< BattlingDinosaur, BattlingDinosaur > victorLoser = victory.determineVictorLoser( faster, slower );
      if ( victorLoser != null ) {
         turn.victoryAfterFasterAction( victorLoser );
         return Optional.of( turn );
      }
      
      DinosaurAction slowerAction = actions.actionForDinosaur( slower );
      slowerAction.execute( slower, faster );
      
      turn.slowerActionExecuted( slowerAction, faster, slower );
      
      victorLoser = victory.determineVictorLoser( faster, slower );
      if ( victorLoser != null ) {
         turn.victoryAfterSlowerAction( victorLoser );
         return Optional.of( turn );
      }
      
      //affect effects
      //victory check
      
      return Optional.of( turn );
   }//End Method
   
   private boolean actionAvailable( BattlingDinosaur dinosaur, DinosaurAction action ) {
      Optional< DinosaurAction > foundAction = dinosaur.actions().stream().filter( a -> action == a ).findFirst();
      if ( foundAction.isPresent() ) {
         return foundAction.get().isAvailable();
      } else {
         return false;
      }
   }//End Method
   
}//End Class
