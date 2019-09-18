package uk.dangrew.jwags.simulation.model;

import java.util.function.Supplier;

import uk.dangrew.jwags.simulation.actions.logic.ArmorPiercingImpactAction;
import uk.dangrew.jwags.simulation.actions.logic.DefenseShatteringStrikeAction;
import uk.dangrew.jwags.simulation.actions.logic.DinosaurAction;
import uk.dangrew.jwags.simulation.actions.logic.PounceAction;
import uk.dangrew.jwags.simulation.actions.logic.StrikeAction;
import uk.dangrew.jwags.simulation.actions.logic.SuperiorityStrikeAction;
import uk.dangrew.jwags.simulation.actions.logic.ThagomizerAction;

public enum DinosaurActions {
   
   Allosaurus_DefenseShatteringStrike( DefenseShatteringStrikeAction::new ),
   Allosaurus_ArmorPiercingImpact( ArmorPiercingImpactAction::new ),
   Stegosaurus_SuperiorityStrike( SuperiorityStrikeAction::new ),
   Stegosaurus_Thagomizer( ThagomizerAction::new ),
   Tarbosaurus_DefenseShatteringStrike( DefenseShatteringStrikeAction::new ),
   Tarbosaurus_ArmorPiercingImpact( ArmorPiercingImpactAction::new ),
   Velociraptor_Strike( StrikeAction::new ),
   Velociraptor_Pounce( PounceAction::new );
   
   private final Supplier< DinosaurAction > supplier;
   
   private DinosaurActions( Supplier< DinosaurAction > supplier ) {
      this.supplier = supplier;
   }//End Constructor
   
   public DinosaurAction action(){
      return supplier.get();
   }//End Method
}//End Enum
