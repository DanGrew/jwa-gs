package uk.dangrew.jwags.mechanics;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;
import org.mockito.MockitoAnnotations;

import javafx.util.Pair;
import uk.dangrew.jwags.model.Dinosaur;
import uk.dangrew.jwags.model.DinosaurType;
import uk.dangrew.kode.launch.TestApplication;

public class VictoryCalculatorTest {

   private Dinosaur dino1;
   private Dinosaur dino2;
   private VictoryCalculator systemUnderTest;

   @Before public void initialiseSystemUnderTest() {
      TestApplication.startPlatform();
      MockitoAnnotations.initMocks( this );
      dino1 = DinosaurType.Stegosaurus.create();
      dino2 = DinosaurType.Velociraptor.create();
      systemUnderTest = new VictoryCalculator();
   }//End Method

   @Test public void shouldDetermineVictorBasedOnHealth() {
      dino1.health().set( -1 );
      assertThat( systemUnderTest.determineVictorLoser( dino1, dino2 ), is(
               new Pair<>( dino2, dino1 ) 
      ) );
      
      dino1.health().set( dino1.type().health() );
      dino2.health().set( -1 );
      assertThat( systemUnderTest.determineVictorLoser( dino1, dino2 ), is(
               new Pair<>( dino1, dino2 ) 
      ) );
   }//End Method

}//End Class
