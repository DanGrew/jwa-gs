package uk.dangrew.jwags.simulation.effects.logic;

import uk.dangrew.jwags.simulation.effects.snapshot.EffectSnapshot;
import uk.dangrew.jwags.simulation.model.EffectType;

public class SpeedReduction extends EffectImpl {

   private final double speedModifier;
   
   public SpeedReduction( int activeForTurns ) {
      super( EffectType.SpeedReduction, activeForTurns );
      this.speedModifier = 0.5;
   }//End Constructor
   
   @Override public int modifySpeed( int currentSpeed ) {
      return ( int )Math.ceil( currentSpeed * speedModifier );
   }//End Method
   
   public EffectSnapshot snapshot() {
      return new EffectSnapshot( EffectType.SpeedReduction, turnsRemaining(), speedModifier );
   }//End Method
   
   @Override public Effect copy() {
      return new SpeedReduction( turnsRemaining() );
   }//End Method
}//End Class
