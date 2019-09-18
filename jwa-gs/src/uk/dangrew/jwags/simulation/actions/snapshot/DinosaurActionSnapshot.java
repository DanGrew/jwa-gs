package uk.dangrew.jwags.simulation.actions.snapshot;

import uk.dangrew.jwags.simulation.model.DinosaurActionType;

public class DinosaurActionSnapshot {

   private final DinosaurActionType actionType;
   private final int cooldown;
   private final int delay;

   public DinosaurActionSnapshot( 
            DinosaurActionType type,
            int cooldown,
            int delay
   ) {
      this.actionType = type;
      this.cooldown = cooldown;
      this.delay = delay;
   }//End Constructor

   public DinosaurActionType getActionType() {
      return actionType;
   }//End Method

   public int getCooldown() {
      return cooldown;
   }//End Method

   public int getDelay() {
      return delay;
   }//End Method
   
   @Override public String toString() {
      return new StringBuilder( actionType.name() )
               .append( "( Cooldown: " ).append( cooldown )
               .append( ", Delay: " ).append( delay )
               .append( " )" ).toString();
   }//End Method
   
}//End Class
