package uk.dangrew.jwags.actions.logic;

import java.util.List;
import java.util.function.Supplier;

import uk.dangrew.jwags.effects.logic.Effect;
import uk.dangrew.jwags.model.DinosaurActionType;

public class StrikeAction extends StandardAttackAction {

   public StrikeAction() {
      super( 0, 0, 1 );
   }//End Constructor
   
   @Override protected void supplyEffects( List< Supplier< Effect > > attackingEffects, List< Supplier< Effect > > defendingEffects ) {
      //none
   }//End Method
   
   @Override protected DinosaurActionType type() {
      return DinosaurActionType.Strike;
   }//End Method
   
}//End Class
