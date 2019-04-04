package uk.dangrew.jwags.effects.logic;

import uk.dangrew.jwags.effects.snapshot.EffectSnapshot;
import uk.dangrew.jwags.model.EffectType;

public class SpeedReduction extends EffectImpl {

   private final double speedModifier;
   
   public SpeedReduction( int activeForTurns ) {
      super( activeForTurns );
      this.speedModifier = 0.5;
   }//End Constructor

   
   @Override public int modifySpeed( int currentSpeed ) {
      return ( int )Math.ceil( currentSpeed * speedModifier );
   }//End Method
   
   public EffectSnapshot snapshot() {
      return new EffectSnapshot( EffectType.SpeedReduction, turnsRemaining(), speedModifier );
   }//End Method
}//End Class
