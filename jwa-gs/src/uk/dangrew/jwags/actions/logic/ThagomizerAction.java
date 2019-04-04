package uk.dangrew.jwags.actions.logic;

import uk.dangrew.jwags.model.DinosaurActionType;

public class ThagomizerAction extends StandardAttackAction {

   public ThagomizerAction() {
      super( 0, 3, 1.5 );
   }//End Constructor
   
   @Override protected DinosaurActionType type() {
      return DinosaurActionType.Thagmoizer;
   }//End Method
   
}//End Class
