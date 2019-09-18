package uk.dangrew.jwags.simulation.actions.logic;

import java.util.List;
import java.util.function.Supplier;

import uk.dangrew.jwags.simulation.effects.logic.Effect;
import uk.dangrew.jwags.simulation.model.DinosaurActionType;

public class ArmorPiercingImpactAction extends StandardAttackAction {

   public ArmorPiercingImpactAction() {
      super( 0, 2, 1.5, true );
   }//End Constructor
   
   @Override protected void supplyEffects( List< Supplier< Effect > > attackingEffects, List< Supplier< Effect > > defendingEffects ) {
      //none
   }//End Method
   
   @Override public DinosaurActionType type() {
      return DinosaurActionType.ArmorPiercingImpact;
   }//End Method
   
   @Override protected DinosaurActionImpl createBlank() {
      return new ArmorPiercingImpactAction();
   }//End Method
}//End Class
