package uk.dangrew.jwags.actions.logic;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

import uk.dangrew.jwags.actions.snapshot.DinosaurActionSnapshot;
import uk.dangrew.jwags.effects.logic.Effect;
import uk.dangrew.jwags.model.BattlingDinosaur;
import uk.dangrew.jwags.model.DinosaurActionType;

public abstract class DinosaurActionImpl implements DinosaurAction {

   private final int delay;
   private final int cooldown;
   private final List< Supplier< Effect > > effectSuppliers;
   
   private int currentDelay;
   private int currentCooldown;
   
   public DinosaurActionImpl( int delay, int cooldown, Supplier< Effect >... effects ) {
      this.delay = delay;
      this.cooldown = cooldown;
      
      this.currentDelay = delay;
      this.currentCooldown = 0;
      
      this.effectSuppliers = Arrays.asList( effects );
   }//End Constructor
   
   protected abstract DinosaurActionType type();
   
   @Override public String name() {
      return type().name();
   }//End Method
   
   @Override public int currentCooldown(){
      return currentCooldown;
   }//End Method
   
   @Override public int currentDelay(){
      return currentDelay;
   }//End Method
   
   @Override public void turnComplete() {
      if ( currentDelay > 0 ) {
         currentDelay--;
      }
      
      if ( currentCooldown > 0 ) {
         currentCooldown--;
      }
   }//End Method
   
   @Override public boolean isAvailable() {
      return currentDelay <= 0 && currentCooldown <= 0;
   }//End Method
   
   public final void execute( BattlingDinosaur attacking, BattlingDinosaur defending ) {
      performAction( attacking, defending );
      applyEffects( defending );
      attacking.turnComplete();
      cooldown();
   }//End Method
   
   protected abstract void performAction( BattlingDinosaur attacking, BattlingDinosaur defending );
   
   private void applyEffects( BattlingDinosaur defending ){
      effectSuppliers.forEach( supplier -> defending.apply( supplier.get() ) );
   }//End Method
   
   private void cooldown(){
      currentCooldown = cooldown;
   }//End Method
   
   @Override public DinosaurActionSnapshot snapshot() {
      return new DinosaurActionSnapshot( type(), currentCooldown, currentDelay );
   }//End Method
   
}//End Class
