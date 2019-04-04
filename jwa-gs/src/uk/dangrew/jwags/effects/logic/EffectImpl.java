package uk.dangrew.jwags.effects.logic;

public abstract class EffectImpl implements Effect {

   private int activeForTurns;
   
   public EffectImpl( int activeForTurns ) {
      this.activeForTurns = activeForTurns;
   }//End Constructor

   protected int turnsRemaining(){
      return activeForTurns;
   }//End Method
   
   @Override public void turnComplete() {
      activeForTurns--;
   }//End Method
   
   @Override public boolean hasExpired() {
      return activeForTurns <= 0;
   }//End Method
   
}//End Class
