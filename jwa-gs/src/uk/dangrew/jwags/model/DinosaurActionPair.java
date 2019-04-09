package uk.dangrew.jwags.model;

import uk.dangrew.jwags.actions.logic.DinosaurAction;

public class DinosaurActionPair {

   private final BattlingDinosaur dinosaur;
   private final DinosaurAction action;
   
   public DinosaurActionPair( BattlingDinosaur dinosaur, DinosaurAction action ) {
      this.dinosaur = dinosaur;
      this.action = action;
   }//End Constructor
   
   public BattlingDinosaur dinosaur() {
      return dinosaur;
   }//End Method
   
   public DinosaurAction action() {
      return action;
   }//End Method
   
}//End Class
