package uk.dangrew.jwags.actions.logic;

import java.util.function.Supplier;

import uk.dangrew.jwags.effects.logic.Effect;
import uk.dangrew.jwags.model.BattlingDinosaur;

public abstract class StandardAttackAction extends DinosaurActionImpl {

   private final double damageMultiplier;
   
   protected StandardAttackAction(
            int delay,
            int cooldown,
            double damageMultiplier, 
            Supplier< Effect >... effectSuppliers 
   ) {
      super( delay, cooldown, effectSuppliers );
      this.damageMultiplier = damageMultiplier;
   }//End Constructor
   
   @Override public void performAction( BattlingDinosaur attacking, BattlingDinosaur defending ) {
      double armorPortion = 1 - defending.armor() / 100.0;
      double damageAccountingForArmor = attacking.damage() * damageMultiplier * armorPortion;
      double resutingHealth = defending.health() - damageAccountingForArmor;
      defending.setHealth( ( int )resutingHealth );
   }//End Method
   
}//End Class
