package uk.dangrew.jwags.simulation;

import org.junit.Test;

import uk.dangrew.jwags.model.BattlingDinosaur;
import uk.dangrew.jwags.model.DinosaurActions;
import uk.dangrew.jwags.model.DinosaurType;

public class SimulatorTest {

   @Test public void shouldSimulate(){
      Simulator simulator = new Simulator();
      
      BattlingDinosaur raptor = DinosaurType.Velociraptor.create();
      BattlingDinosaur stegosaurus = DinosaurType.Stegosaurus.create();
      
      Turn turn = simulator.simulate( new TurnActions( 
               stegosaurus, DinosaurActions.Stegosaurus_Thagomizer, 
               raptor, DinosaurActions.Velociraptor_Pounce
      ) ).get();
      
      System.out.println( turn.displayableDescription() );
      System.out.println(  );
      
      turn = simulator.simulate( new TurnActions( 
               stegosaurus, DinosaurActions.Stegosaurus_SuperiorityStrike, 
               raptor, DinosaurActions.Velociraptor_Strike
      ) ).get();
      
      System.out.println( turn.displayableDescription() );
      System.out.println(  );
   }//End Method
}
