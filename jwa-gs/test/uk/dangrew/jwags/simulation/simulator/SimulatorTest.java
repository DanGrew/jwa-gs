package uk.dangrew.jwags.simulation.simulator;

import org.junit.Test;

import uk.dangrew.jwags.simulation.model.BattlingDinosaur;
import uk.dangrew.jwags.simulation.model.DinosaurActionType;
import uk.dangrew.jwags.simulation.model.DinosaurActions;
import uk.dangrew.jwags.simulation.model.DinosaurType;
import uk.dangrew.jwags.simulation.simulator.Match;
import uk.dangrew.jwags.simulation.simulator.Simulator;

public class SimulatorTest {

   @Test public void shouldSimulate(){
      Match match = new Match();
      Simulator simulator = new Simulator();
      
      BattlingDinosaur raptor = DinosaurType.Velociraptor.create();
      BattlingDinosaur stegosaurus = DinosaurType.Tarbosaurus.create();
      
//      simulator.simulate( new TurnActions( 
//               stegosaurus, DinosaurActionType.ArmorPiercingImpact, 
//               raptor, DinosaurActionType.Pounce
//      ), match );
//      
//      System.out.println( match.displayableDescription() );
//      
//      simulator.simulate( new TurnActions( 
//               stegosaurus, DinosaurActionType.DefenseShatteringStrike, 
//               raptor, DinosaurActionType.Strike
//      ), match );
      
      System.out.println();
      System.out.println( "--------------" );
      System.out.println( match.displayableDescription() );
   }//End Method
}
