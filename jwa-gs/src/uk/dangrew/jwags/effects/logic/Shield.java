package uk.dangrew.jwags.effects.logic;

import uk.dangrew.jwags.effects.snapshot.EffectSnapshot;
import uk.dangrew.jwags.model.EffectType;

public class Shield extends EffectImpl {

   private final double shieldDamageModifier;
   
   public Shield( int activeForTurns, double damageModifier ) {
      super( activeForTurns );
      this.shieldDamageModifier = damageModifier;
   }//End Constructor
   
   @Override public int modifyDamage( int currentDamage ) {
      return ( int )Math.ceil( currentDamage * shieldDamageModifier );
   }//End Method

   @Override public EffectSnapshot snapshot() {
      return new EffectSnapshot( EffectType.Shield, turnsRemaining(), shieldDamageModifier );
   }//End Method
   
}//End Class
