package uk.dangrew.jwags.actions.logic;

import java.util.List;
import java.util.function.Supplier;

import uk.dangrew.jwags.effects.logic.Distraction;
import uk.dangrew.jwags.effects.logic.Effect;
import uk.dangrew.jwags.effects.logic.SpeedReduction;
import uk.dangrew.jwags.model.BattlingDinosaur;
import uk.dangrew.jwags.model.DinosaurActionType;

public class SuperiorityStrikeAction extends StandardAttackAction {

   public SuperiorityStrikeAction() {
      super( 0, 0, 1 );
   }//End Constructor
   
   @Override protected void supplyEffects( List< Supplier< Effect > > attackingEffects, List< Supplier< Effect > > defendingEffects ) {
      attackingEffects.add( () -> new SpeedReduction( 1 ) );
   }//End Method
   
   @Override public DinosaurActionType type() {
      return DinosaurActionType.SuperiorityStrike;
   }//End Method
   
   @Override public void performAction( BattlingDinosaur attacking, BattlingDinosaur defending ) {
      attacking.attackingEffects().removeIf( e -> e instanceof Distraction );
      super.performAction( attacking, defending );
   }//End Method
   
   @Override protected DinosaurActionImpl createBlank() {
      return new SuperiorityStrikeAction();
   }//End Method
}//End Class
