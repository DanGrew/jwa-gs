package uk.dangrew.jwags.model;

import uk.dangrew.jwags.actions.logic.DinosaurAction;
import uk.dangrew.jwags.actions.logic.PounceAction;
import uk.dangrew.jwags.actions.logic.StrikeAction;
import uk.dangrew.jwags.actions.logic.SuperiorityStrikeAction;
import uk.dangrew.jwags.actions.logic.ThagomizerAction;

public enum DinosaurActions {

   Stegosaurus_SuperiorityStrike( new SuperiorityStrikeAction() ),
   Stegosaurus_Thagomizer( new ThagomizerAction() ),
   Velociraptor_Strike( new StrikeAction() ),
   Velociraptor_Pounce( new PounceAction() );
   
   private final DinosaurAction action;
   
   private DinosaurActions( DinosaurAction action ) {
      this.action = action;
   }//End Constructor
   
   public DinosaurAction action(){
      return action;
   }//End Method
}//End Enum
