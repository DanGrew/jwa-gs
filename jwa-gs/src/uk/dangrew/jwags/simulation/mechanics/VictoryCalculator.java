package uk.dangrew.jwags.simulation.mechanics;

import uk.dangrew.jwags.simulation.model.BattlingDinosaur;
import uk.dangrew.jwags.simulation.simulator.MatchResult;

public class VictoryCalculator {

   public MatchResult determineVictorLoser( BattlingDinosaur dinosaur1, BattlingDinosaur dinosaur2 ) {
      if ( dinosaur1.health() <= 0 ) {
         return MatchResult.SecondWon;
      } else if ( dinosaur2.health() <= 0 ) {
         return MatchResult.FirstWon;
      } else {
         return MatchResult.Incomplete;
      }
   }//End Method
   
}//End Class
