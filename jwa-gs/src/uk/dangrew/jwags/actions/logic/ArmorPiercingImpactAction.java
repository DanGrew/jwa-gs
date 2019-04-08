package uk.dangrew.jwags.actions.logic;

import java.util.List;
import java.util.function.Supplier;

import uk.dangrew.jwags.effects.logic.Effect;
import uk.dangrew.jwags.model.BattlingDinosaur;
import uk.dangrew.jwags.model.DinosaurActionType;

public class ArmorPiercingImpactAction extends StandardAttackAction {

   public ArmorPiercingImpactAction() {
      super( 0, 2, 1.5, true );
   }//End Constructor
   
   @Override protected void supplyEffects( List< Supplier< Effect > > attackingEffects, List< Supplier< Effect > > defendingEffects ) {
      //none
   }//End Method
   
   @Override protected DinosaurActionType type() {
      return DinosaurActionType.ArmorPiercingImpact;
   }//End Method
   
   @Override public void performAction( BattlingDinosaur attacking, BattlingDinosaur defending ) {
      super.performAction( attacking, defending );
   }//End Method
}//End Class
