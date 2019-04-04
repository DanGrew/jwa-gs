package uk.dangrew.jwags.effects.logic;

import uk.dangrew.jwags.effects.snapshot.EffectSnapshot;

public interface Effect {

   public void turnComplete();
   
   public boolean hasExpired();
   
   public default int modifySpeed( int currentSpeed ) {
      return currentSpeed;
   }//End Method
   
   public default int modifyDamage( int currentDamage ) {
      return currentDamage;
   }//End Method
   
   public EffectSnapshot snapshot();
   
}//End Interface

