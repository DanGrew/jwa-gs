package uk.dangrew.jwags.mechanics;

import javafx.util.Pair;
import uk.dangrew.jwags.model.Dinosaur;

public class VictoryCalculator {

   public Pair< Dinosaur, Dinosaur > determineVictorLoser( Dinosaur dinosaur1, Dinosaur dinosaur2 ) {
      if ( dinosaur1.health().get() <= 0 ) {
         return new Pair<>( dinosaur2, dinosaur1 );
      } else if ( dinosaur2.health().get() <= 0 ) {
         return new Pair<>( dinosaur1, dinosaur2 );
      } else {
         return null;
      }
   }//End Method
   
}//End Class
