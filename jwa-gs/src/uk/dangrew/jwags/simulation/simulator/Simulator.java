package uk.dangrew.jwags.simulation.simulator;

import java.util.Optional;

import uk.dangrew.jwags.simulation.actions.logic.DinosaurAction;
import uk.dangrew.jwags.simulation.mechanics.PlayerOrderCalculator;
import uk.dangrew.jwags.simulation.mechanics.VictoryCalculator;
import uk.dangrew.jwags.simulation.model.BattleSnapshot;
import uk.dangrew.jwags.simulation.model.DinosaurActionPair;

public class Simulator {

   private final PlayerOrderCalculator playOrder;
   private final VictoryCalculator victory;
   
   public Simulator() {
      this.playOrder = new PlayerOrderCalculator();
      this.victory = new VictoryCalculator();
   }//End Class
   
   public void simulate( 
            DinosaurActionPair pair1, 
            DinosaurActionPair pair2,
            Match match 
   ) {
      DinosaurActionPair first = playOrder.faster( pair1, pair2 );
      DinosaurActionPair second = playOrder.slower( pair1, pair2 );
      
      if ( !actionAvailable( first ) ){
         match.addRecord( new MatchRecord(
                  MatchRecordType.TurnStart, 
                  null, 
                  new BattleSnapshot( first.dinosaur().snapshot(), second.dinosaur().snapshot() ), 
                  MatchResult.FirstActionUnnavailable 
         ) );
         return;
      }
      
      if ( !actionAvailable( second ) ){
         match.addRecord( new MatchRecord(
                  MatchRecordType.TurnStart, 
                  null, 
                  new BattleSnapshot( first.dinosaur().snapshot(), second.dinosaur().snapshot() ), 
                  MatchResult.SecondActionUnnavailable 
         ) );
         return;
      }
      
      match.addRecord( new MatchRecord(
               MatchRecordType.TurnStart, 
               null, 
               new BattleSnapshot( first.dinosaur().snapshot(), second.dinosaur().snapshot() ), 
               MatchResult.Incomplete 
      ) );
      
      first.action().execute( first.dinosaur(), second.dinosaur() );
      match.addRecord( new MatchRecord(
               MatchRecordType.FirstAction, 
               first.action().snapshot(), 
               new BattleSnapshot( first.dinosaur().snapshot(), second.dinosaur().snapshot() ), 
               victory.determineVictorLoser( first.dinosaur(), second.dinosaur() )
      ) );
      
      if ( match.hasConcluded() ) {
         return;
      }
      
      second.action().execute( second.dinosaur(), first.dinosaur() );
      match.addRecord( new MatchRecord(
               MatchRecordType.SecondAction, 
               second.action().snapshot(), 
               new BattleSnapshot( first.dinosaur().snapshot(), second.dinosaur().snapshot() ), 
               victory.determineVictorLoser( first.dinosaur(), second.dinosaur() )
      ) );
   }//End Method
   
   private boolean actionAvailable( DinosaurActionPair pair ) {
      Optional< DinosaurAction > foundAction = pair.dinosaur().actions().stream()
               .filter( a -> pair.action() == a )
               .findFirst();
      if ( foundAction.isPresent() ) {
         return foundAction.get().isAvailable();
      } else {
         return false;
      }
   }//End Method
   
}//End Class
