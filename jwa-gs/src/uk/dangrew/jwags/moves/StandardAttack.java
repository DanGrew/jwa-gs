package uk.dangrew.jwags.moves;

import uk.dangrew.jwags.model.Dinosaur;

public abstract class StandardAttack implements DinosaurAction {

   private final double damageMultiplier;
   
   protected StandardAttack( double damageMultiplier ) {
      this.damageMultiplier = damageMultiplier;
   }//End Constructor
   
   @Override public void execute( Dinosaur attacking, Dinosaur defending ) {
      double armorPortion = 1 - defending.type().armor() / 100.0;
      double damageAccountingForArmor = attacking.damage().get() * damageMultiplier * armorPortion;
      double resutingHealth = defending.health().get() - damageAccountingForArmor;
      defending.health().set( ( int )resutingHealth );
   }//End Method
   
}//End Class
