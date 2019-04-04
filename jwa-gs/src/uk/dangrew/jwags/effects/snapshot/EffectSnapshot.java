package uk.dangrew.jwags.effects.snapshot;

import uk.dangrew.jwags.model.EffectType;

public class EffectSnapshot {

   private final EffectType type;
   private final double modifier;
   private final int remainingTurnsActiveFor;
   
   public EffectSnapshot(
            EffectType type,
            int remainingTurnsActiveFor,
            double damageModifier
   ) {
      this.type = type;
      this.modifier = damageModifier;
      this.remainingTurnsActiveFor = remainingTurnsActiveFor;
   }//End Constructor

   public EffectType type(){
      return type;
   }//End Method
   
   public double getDamageModifier() {
      return modifier;
   }//End Method

   public int getRemainingTurnsActiveFor() {
      return remainingTurnsActiveFor;
   }//End Method
   
   @Override public String toString() {
      return new StringBuilder( type.name() )
               .append( "( Remaining: " ).append( remainingTurnsActiveFor )
               .append( ", Modifier: " ).append( modifier )
               .append( " )" ).toString();
   }//End Method
   
}//End Class
