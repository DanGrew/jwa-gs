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

public class PlayerOrderCalculatorTest {

   private BattlingDinosaur dino1;
   private BattlingDinosaur dino2;
   private PlayerOrderCalculator systemUnderTest;

   @Before public void initialiseSystemUnderTest() {
      TestApplication.startPlatform();
      MockitoAnnotations.initMocks( this );
      dino1 = DinosaurType.ArmoredDinosaur.create();
      dino2 = DinosaurType.BasicDinosaur.create();
      systemUnderTest = new PlayerOrderCalculator();
   }//End Method

   @Test public void shouldIdentifyFastestDinosaur() {
      assertThat( systemUnderTest.determinePlayOrder( 
               dino1, dino2
      ), is( new Pair<>( dino2, dino1 ) ) );
   }//End Method

}//End Class
