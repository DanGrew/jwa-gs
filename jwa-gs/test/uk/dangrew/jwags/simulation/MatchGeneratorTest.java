package uk.dangrew.jwags.simulation;

import org.junit.Before;
import org.junit.Test;
import org.mockito.MockitoAnnotations;

import uk.dangrew.jwags.model.DinosaurType;
import uk.dangrew.kode.launch.TestApplication;

public class MatchGeneratorTest {

   private MatchGenerator systemUnderTest;

   @Before public void initialiseSystemUnderTest() {
      TestApplication.startPlatform();
      MockitoAnnotations.initMocks( this );
      systemUnderTest = new MatchGenerator();
   }//End Method

   @Test public void test() {
      systemUnderTest.generate( 
               DinosaurType.Stegosaurus.create(), 
               DinosaurType.Tarbosaurus.create() 
      );
      
      for ( Match match : systemUnderTest.matches() ) {
         System.out.println( match.displayableDescription() );
         System.out.println( "-----------------------" );
      }
   }//End Method

}//End Class
