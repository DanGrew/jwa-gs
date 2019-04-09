package uk.dangrew.jwags.effects.logic;

import uk.dangrew.jwags.effects.snapshot.EffectSnapshot;
import uk.dangrew.jwags.model.EffectType;

public class Distraction extends EffectImpl {

   private final double damageModifier;
   
   public Distraction( int activeForTurns, double damageModifier ) {
      super( EffectType.Distraction, activeForTurns );
      this.damageModifier = damageModifier;
   }//End Constructor

   @Override public int modifyDamage( int currentDamage ) {
      return ( int )Math.ceil( currentDamage * damageModifier );
   }//End Method
   
   @Override public EffectSnapshot snapshot() {
      return new EffectSnapshot( EffectType.Distraction, turnsRemaining(), damageModifier );
   }//End Method
   
   @Override public Effect copy() {
      return new Distraction( turnsRemaining(), damageModifier );
   }//End Method
   
}//End Class
