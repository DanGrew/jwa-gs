package uk.dangrew.jwags.actions.logic;

import uk.dangrew.jwags.effects.logic.Distraction;
import uk.dangrew.jwags.model.DinosaurActionType;

public class PounceAction extends StandardAttackAction {

   public PounceAction() {
      super( 
               0, 
               1,
               2, 
               () -> new Distraction( 1, defenderDamageReductionMultiplier() ) 
      );
   }//End Constructor
   
   @Override protected DinosaurActionType type() {
      return DinosaurActionType.Pounce;
   }//End Method
   
   static double defenderDamageReductionMultiplier(){
      return 0.5;
   }//End Method
   
}//End Class
