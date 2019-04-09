package uk.dangrew.jwags.actions.logic;

import java.util.List;
import java.util.function.Supplier;

import uk.dangrew.jwags.effects.logic.Distraction;
import uk.dangrew.jwags.effects.logic.Effect;
import uk.dangrew.jwags.model.DinosaurActionType;

public class PounceAction extends StandardAttackAction {

   public PounceAction() {
      super( 0, 1, 2 );
   }//End Constructor
   
   @Override protected void supplyEffects( List< Supplier< Effect > > attackingEffects, List< Supplier< Effect > > defendingEffects ) {
      attackingEffects.add( () -> new Distraction( 1, defenderDamageReductionMultiplier() ) );
   }//End Method
   
   @Override public DinosaurActionType type() {
      return DinosaurActionType.Pounce;
   }//End Method
   
   static double defenderDamageReductionMultiplier(){
      return 0.5;
   }//End Method
   
   @Override protected DinosaurActionImpl createBlank() {
      return new PounceAction();
   }//End Method
   
}//End Class
