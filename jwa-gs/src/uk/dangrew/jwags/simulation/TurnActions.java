package uk.dangrew.jwags.simulation;

import java.util.HashMap;
import java.util.Map;

import javafx.util.Pair;
import uk.dangrew.jwags.actions.logic.DinosaurAction;
import uk.dangrew.jwags.model.BattlingDinosaur;
import uk.dangrew.jwags.model.DinosaurActions;

public class TurnActions {

   private final Pair< BattlingDinosaur, BattlingDinosaur > dinosaurs;
   private final Map< BattlingDinosaur, DinosaurActions > actions;
   
   public TurnActions( 
            BattlingDinosaur dinosaur1, DinosaurActions action1, 
            BattlingDinosaur dinosaur2, DinosaurActions action2 
   ) {
      this.dinosaurs = new Pair<>( dinosaur1, dinosaur2 );
      this.actions = new HashMap<>();
      this.actions.put( dinosaur1, action1 );
      this.actions.put( dinosaur2, action2 );
   }//End Constructor
   
   public Pair< BattlingDinosaur, BattlingDinosaur > dinosaurs(){
      return dinosaurs;
   }//End Method
   
   public DinosaurAction actionForDinosaur( BattlingDinosaur dinosaur ) {
      return actions.get( dinosaur ).action();
   }//End Method
   
}//End Class
