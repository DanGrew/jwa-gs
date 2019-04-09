package uk.dangrew.jwags.simulation;

import java.util.EnumMap;

import uk.dangrew.jwags.actions.logic.DinosaurAction;
import uk.dangrew.jwags.model.BattlingDinosaur;
import uk.dangrew.jwags.model.DinosaurActionType;
import uk.dangrew.jwags.model.DinosaurType;

public class TurnActions {

   private final EnumMap< DinosaurType, DinosaurActionType > actions;
   
   public TurnActions( 
            DinosaurType type1, DinosaurActionType actionType1, 
            DinosaurType type2, DinosaurActionType action2Type 
   ) {
      if ( type1 == type2 ) {
         throw new IllegalArgumentException();
      }
      this.actions = new EnumMap<>( DinosaurType.class );
      this.actions.put( type1, actionType1 );
      this.actions.put( type2, action2Type );
   }//End Constructor
   
   public DinosaurAction actionForDinosaur( BattlingDinosaur dinosaur ) {
      for ( DinosaurAction action : dinosaur.actions() ) {
         if ( action.type() == actions.get( dinosaur.type() ) ) {
            return action;
         }
      }
      return null;
   }//End Method
   
}//End Class
