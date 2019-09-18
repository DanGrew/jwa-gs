package uk.dangrew.jwags.simulation.simulator;

import org.junit.Before;
import org.junit.Test;
import org.mockito.MockitoAnnotations;

import uk.dangrew.jwags.simulation.model.DinosaurType;
import uk.dangrew.jwags.simulation.simulator.Match;
import uk.dangrew.jwags.simulation.simulator.MatchGenerator;
import uk.dangrew.kode.launch.TestApplication;

public class MatchGeneratorTest {

   private MatchGenerator systemUnderTest;

   @Before public void initialiseSystemUnderTest() {
      TestApplication.startPlatform();
      MockitoAnnotations.initMocks( this );
      systemUnderTest = new MatchGenerator();
   }//End Method

   @Test public void test() {
      SimulatedMatches matches = systemUnderTest.generate( 
               DinosaurType.Stegosaurus.create(), 
               DinosaurType.Tarbosaurus.create() 
      );
      
      for ( Match match : matches.matches() ) {
         System.out.println( match.displayableDescription() );
         System.out.println( "-----------------------" );
      }
   }//End Method

}//End Class
