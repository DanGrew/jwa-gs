package uk.dangrew.jwags.mechanics;

import javafx.util.Pair;
import uk.dangrew.jwags.model.Dinosaur;

public class PlayerOrderCalculator {

   public Pair< Dinosaur, Dinosaur > determinePlayOrder( Dinosaur dinosaur1, Dinosaur dinosaur2 ) {
      if ( dinosaur1.type().speed() >= dinosaur2.type().speed() ){
         return new Pair<>( dinosaur1, dinosaur2 );
      } else {
         return new Pair<>( dinosaur2, dinosaur1 );
      }
   }//End Method

}//End Class
