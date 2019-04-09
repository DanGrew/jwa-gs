package uk.dangrew.jwags.effects.logic;

import uk.dangrew.jwags.effects.snapshot.EffectSnapshot;
import uk.dangrew.jwags.model.EffectType;

public interface Effect {

   public EffectType type();
   
   public int turnsRemaining();
   
   public boolean hasExpired();
   
   public default int modifySpeed( int currentSpeed ) {
      return currentSpeed;
   }//End Method
   
   public default int modifyDamage( int currentDamage ) {
      return currentDamage;
   }//End Method
   
   public void turnComplete();
   
   public EffectSnapshot snapshot();
   
   public Effect copy();
   
}//End Interface

