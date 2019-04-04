package uk.dangrew.jwags.mechanics;

import javafx.util.Pair;
import uk.dangrew.jwags.model.BattlingDinosaur;

public class PlayerOrderCalculator {

   public Pair< BattlingDinosaur, BattlingDinosaur > determinePlayOrder( Pair< BattlingDinosaur, BattlingDinosaur > dinosaurs ) {
      return determinePlayOrder( dinosaurs.getKey(), dinosaurs.getValue() );
   }//End Method
   
   public Pair< BattlingDinosaur, BattlingDinosaur > determinePlayOrder( BattlingDinosaur dinosaur1, BattlingDinosaur dinosaur2 ) {
      if ( dinosaur1.speed() >= dinosaur2.speed() ){
         return new Pair<>( dinosaur1, dinosaur2 );
      } else {
         return new Pair<>( dinosaur2, dinosaur1 );
      }
   }//End Method

}//End Class
