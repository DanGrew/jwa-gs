package uk.dangrew.jwags.effects.calculations;

import uk.dangrew.jwags.effects.logic.Effect;
import uk.dangrew.jwags.model.BattlingDinosaur;
import uk.dangrew.jwags.principles.Rounding;

public class BattleStatistics {

   private final Rounding rounding;
   
   public BattleStatistics() {
      this.rounding = new Rounding();
   }//End Constructor
   
   public int speedOf( BattlingDinosaur dinosaur ) {
      int currentSpeed = dinosaur.type().speed();
      for ( Effect effect : dinosaur.attackingEffects() ) {
         currentSpeed = effect.modifySpeed( currentSpeed );
      }
      return currentSpeed;
   }//End Method

   public int damageOf( BattlingDinosaur dinosaur ) {
      int currentDamage = dinosaur.type().damage();
      for ( Effect effect : dinosaur.attackingEffects() ) {
         currentDamage = effect.modifyDamage( currentDamage );
      }
      return currentDamage;
   }//End Method
   
   public int damageAgainst( BattlingDinosaur defending, double damage ){
      int modifiedDamage = rounding.round( damage );
      for ( Effect effect : defending.defendingEffects() ) {
         modifiedDamage = effect.modifyDamage( modifiedDamage );
      }
      return modifiedDamage;
   }//End Method
   
}//End Class
