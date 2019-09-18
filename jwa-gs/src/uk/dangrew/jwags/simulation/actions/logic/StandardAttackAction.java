package uk.dangrew.jwags.simulation.actions.logic;

import uk.dangrew.jwags.simulation.effects.calculations.BattleStatistics;
import uk.dangrew.jwags.simulation.model.BattlingDinosaur;

public abstract class StandardAttackAction extends DinosaurActionImpl {

   private final BattleStatistics battlingStatistics;
   private final boolean bypassesArmor;
   private final double damageMultiplier;
   
   protected StandardAttackAction(
            int delay,
            int cooldown,
            double damageMultiplier
   ) {
      this( delay, cooldown, damageMultiplier, false );
   }//End Constructor
   
   protected StandardAttackAction(
            int delay,
            int cooldown,
            double damageMultiplier ,
            boolean bypassesArmor
   ) {
      super( delay, cooldown );
      this.battlingStatistics = new BattleStatistics();
      this.bypassesArmor = bypassesArmor;
      this.damageMultiplier = damageMultiplier;
   }//End Constructor
   
   @Override public void performAction( BattlingDinosaur attacking, BattlingDinosaur defending ) {
      double armorPortion = 1;
      if ( !bypassesArmor ) {
         armorPortion = 1 - defending.armor() / 100.0;
      }
      double damageAccountingForArmor = attacking.damage() * damageMultiplier * armorPortion;
      double damageAccoutningForDefense = battlingStatistics.damageAgainst( defending, damageAccountingForArmor );
      double resutingHealth = defending.health() - damageAccoutningForDefense;
      defending.setHealth( ( int )resutingHealth );
   }//End Method
   
}//End Class
