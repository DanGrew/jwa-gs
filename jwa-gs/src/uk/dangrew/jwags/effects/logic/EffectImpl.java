package uk.dangrew.jwags.effects.logic;

import uk.dangrew.jwags.model.EffectType;

public abstract class EffectImpl implements Effect {

   private final EffectType type;
   private int activeForTurns;
   
   public EffectImpl( EffectType type, int activeForTurns ) {
      this.type = type;
      this.activeForTurns = activeForTurns;
   }//End Constructor

   @Override public EffectType type() {
      return type;
   }//End Method
   
   @Override public int turnsRemaining(){
      return activeForTurns;
   }//End Method
   
   @Override public void turnComplete() {
      activeForTurns--;
   }//End Method
   
   @Override public boolean hasExpired() {
      return activeForTurns <= 0;
   }//End Method
   
}//End Class
