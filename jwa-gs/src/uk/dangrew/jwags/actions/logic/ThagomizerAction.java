package uk.dangrew.jwags.actions.logic;

import java.util.List;
import java.util.function.Supplier;

import uk.dangrew.jwags.effects.logic.Effect;
import uk.dangrew.jwags.effects.logic.SpeedReduction;
import uk.dangrew.jwags.model.DinosaurActionType;

public class ThagomizerAction extends StandardAttackAction {

   public ThagomizerAction() {
      super( 0, 3, 1.5 );
   }//End Constructor
   
   @Override protected void supplyEffects( List< Supplier< Effect > > attackingEffects, List< Supplier< Effect > > defendingEffects ) {
      attackingEffects.add( () -> new SpeedReduction( 3 ) );
   }//End Method
   
   @Override protected DinosaurActionType type() {
      return DinosaurActionType.Thagmoizer;
   }//End Method
   
}//End Class
