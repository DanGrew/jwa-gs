package uk.dangrew.jwags.simulation.actions.logic;

import java.util.List;
import java.util.function.Supplier;

import uk.dangrew.jwags.simulation.effects.logic.Effect;
import uk.dangrew.jwags.simulation.effects.logic.Shield;
import uk.dangrew.jwags.simulation.model.BattlingDinosaur;
import uk.dangrew.jwags.simulation.model.DinosaurActionType;

public class DefenseShatteringStrikeAction extends StandardAttackAction {

   public DefenseShatteringStrikeAction() {
      super( 0, 0, 1, true );
   }//End Constructor
   
   @Override protected void supplyEffects( List< Supplier< Effect > > attackingEffects, List< Supplier< Effect > > defendingEffects ) {
      //none
   }//End Method
   
   @Override public DinosaurActionType type() {
      return DinosaurActionType.DefenseShatteringStrike;
   }//End Method
   
   @Override public void performAction( BattlingDinosaur attacking, BattlingDinosaur defending ) {
      defending.defendingEffects().removeIf( e -> e instanceof Shield );
      super.performAction( attacking, defending );
   }//End Method
   
   @Override protected DinosaurActionImpl createBlank() {
      return new DefenseShatteringStrikeAction();
   }//End Method
}//End Class
