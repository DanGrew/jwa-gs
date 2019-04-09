package uk.dangrew.jwags.mechanics;

import uk.dangrew.jwags.model.BattlingDinosaur;
import uk.dangrew.jwags.simulation.MatchResult;

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
