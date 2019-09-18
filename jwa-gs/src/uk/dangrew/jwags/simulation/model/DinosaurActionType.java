package uk.dangrew.jwags.simulation.model;

import java.util.function.Supplier;

import uk.dangrew.jwags.simulation.actions.logic.ArmorPiercingImpactAction;
import uk.dangrew.jwags.simulation.actions.logic.DefenseShatteringStrikeAction;
import uk.dangrew.jwags.simulation.actions.logic.DinosaurAction;
import uk.dangrew.jwags.simulation.actions.logic.PounceAction;
import uk.dangrew.jwags.simulation.actions.logic.StrikeAction;
import uk.dangrew.jwags.simulation.actions.logic.SuperiorityStrikeAction;
import uk.dangrew.jwags.simulation.actions.logic.ThagomizerAction;

public enum DinosaurActionType {

   ArmorPiercingImpact( ArmorPiercingImpactAction::new ),
   DefenseShatteringStrike( DefenseShatteringStrikeAction::new ),
   Pounce( PounceAction::new ),
   Strike( StrikeAction::new ),
   SuperiorityStrike( SuperiorityStrikeAction::new ),
   Thagmoizer( ThagomizerAction::new );
   
   private final Supplier< DinosaurAction > actionSupplier;
   
   private DinosaurActionType( Supplier< DinosaurAction > actionSupplier ) {
      this.actionSupplier = actionSupplier;
   }//End Constructor
   
   public DinosaurAction create(){
      return actionSupplier.get();
   }//End Method
   
}//End Class
