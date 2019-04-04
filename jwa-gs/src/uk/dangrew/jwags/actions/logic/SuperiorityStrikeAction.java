package uk.dangrew.jwags.actions.logic;

import uk.dangrew.jwags.effects.logic.SpeedReduction;
import uk.dangrew.jwags.model.DinosaurActionType;

public class SuperiorityStrikeAction extends StandardAttackAction {

   public SuperiorityStrikeAction() {
      super( 
               0, 0, 1, 
               () -> new SpeedReduction( 1 ) 
      );
   }//End Constructor
   
   @Override protected DinosaurActionType type() {
      return DinosaurActionType.SuperiorityStrike;
   }//End Method
}//End Class
