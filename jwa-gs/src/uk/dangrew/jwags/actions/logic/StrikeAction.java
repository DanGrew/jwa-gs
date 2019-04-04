package uk.dangrew.jwags.actions.logic;

import uk.dangrew.jwags.model.DinosaurActionType;

public class StrikeAction extends StandardAttackAction {

   public StrikeAction() {
      super( 0, 0, 1 );
   }//End Constructor
   
   @Override protected DinosaurActionType type() {
      return DinosaurActionType.Strike;
   }//End Method
   
}//End Class
