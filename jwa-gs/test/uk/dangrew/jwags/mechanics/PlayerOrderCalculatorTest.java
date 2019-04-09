package uk.dangrew.jwags.mechanics;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;
import org.mockito.MockitoAnnotations;

import javafx.util.Pair;
import uk.dangrew.jwags.actions.logic.StrikeAction;
import uk.dangrew.jwags.model.BattlingDinosaur;
import uk.dangrew.jwags.model.DinosaurActionPair;
import uk.dangrew.jwags.model.DinosaurType;
import uk.dangrew.kode.launch.TestApplication;

public class PlayerOrderCalculatorTest {

   private DinosaurActionPair dino1;
   private DinosaurActionPair dino2;
   private PlayerOrderCalculator systemUnderTest;

   @Before public void initialiseSystemUnderTest() {
      TestApplication.startPlatform();
      MockitoAnnotations.initMocks( this );
      dino1 = new DinosaurActionPair( 
               DinosaurType.ArmoredDinosaur.create(),
               new StrikeAction()
      );
      dino2 = new DinosaurActionPair( 
               DinosaurType.BasicDinosaur.create(),
               new StrikeAction()
      );
      systemUnderTest = new PlayerOrderCalculator();
   }//End Method

   @Test public void shouldIdentifyFastestDinosaur() {
      assertThat( systemUnderTest.faster( dino1, dino2 ), is( dino2 ) );
      assertThat( systemUnderTest.slower( dino1, dino2 ), is( dino1 ) );
   }//End Method

}//End Class
