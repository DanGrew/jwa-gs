package uk.dangrew.jwags.simulation.mechanics;

import uk.dangrew.jwags.simulation.model.BattlingDinosaur;
import uk.dangrew.jwags.simulation.model.DinosaurActionPair;

public class PlayerOrderCalculator {

   private boolean isFaster( BattlingDinosaur dinosaur1, BattlingDinosaur dinosaur2 ) {
      return dinosaur1.speed() >= dinosaur2.speed();
   }//End Method
   
   public DinosaurActionPair faster( 
            DinosaurActionPair first, DinosaurActionPair second 
   ) {
      if ( isFaster( first.dinosaur(), second.dinosaur() ) ) {
         return first;
      } else { 
         return second;
      }
   }//End Method
   
   public DinosaurActionPair slower( 
            DinosaurActionPair first, DinosaurActionPair second
   ) {
      if ( isFaster( first.dinosaur(), second.dinosaur() ) ) {
         return second;
      } else { 
         return first;
      }
   }//End Method

}//End Class
