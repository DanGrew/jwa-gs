package uk.dangrew.jwags.mechanics;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;
import org.mockito.MockitoAnnotations;

import javafx.util.Pair;
import uk.dangrew.jwags.model.BattlingDinosaur;
import uk.dangrew.jwags.model.DinosaurType;
import uk.dangrew.kode.launch.TestApplication;

public class VictoryCalculatorTest {

   private BattlingDinosaur dino1;
   private BattlingDinosaur dino2;
   private VictoryCalculator systemUnderTest;

   @Before public void initialiseSystemUnderTest() {
      TestApplication.startPlatform();
      MockitoAnnotations.initMocks( this );
      dino1 = DinosaurType.ArmoredDinosaur.create();
      dino2 = DinosaurType.BasicDinosaur.create();
      systemUnderTest = new VictoryCalculator();
   }//End Method

   @Test public void shouldDetermineVictorBasedOnHealth() {
      dino1.setHealth( -1 );
      assertThat( systemUnderTest.determineVictorLoser( dino1, dino2 ), is(
               new Pair<>( dino2, dino1 ) 
      ) );
      
      dino1.setHealth( DinosaurType.ArmoredDinosaur.health() );
      dino2.setHealth( -1 );
      assertThat( systemUnderTest.determineVictorLoser( dino1, dino2 ), is(
               new Pair<>( dino1, dino2 ) 
      ) );
   }//End Method

}//End Class
