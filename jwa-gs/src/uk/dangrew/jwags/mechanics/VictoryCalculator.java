package uk.dangrew.jwags.mechanics;

import javafx.util.Pair;
import uk.dangrew.jwags.model.BattlingDinosaur;

public class VictoryCalculator {

   public Pair< BattlingDinosaur, BattlingDinosaur > determineVictorLoser( BattlingDinosaur dinosaur1, BattlingDinosaur dinosaur2 ) {
      if ( dinosaur1.health() <= 0 ) {
         return new Pair<>( dinosaur2, dinosaur1 );
      } else if ( dinosaur2.health() <= 0 ) {
         return new Pair<>( dinosaur1, dinosaur2 );
      } else {
         return null;
      }
   }//End Method
   
}//End Class
