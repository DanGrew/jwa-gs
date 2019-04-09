package uk.dangrew.jwags.simulation;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;
import org.mockito.MockitoAnnotations;

import uk.dangrew.jwags.model.BattlingDinosaur;
import uk.dangrew.jwags.model.DinosaurActionType;
import uk.dangrew.jwags.model.DinosaurType;
import uk.dangrew.kode.launch.TestApplication;

public class TurnActionsTest {

   private BattlingDinosaur first;
   private BattlingDinosaur second;
   private TurnActions systemUnderTest;

   @Before public void initialiseSystemUnderTest() {
      TestApplication.startPlatform();
      MockitoAnnotations.initMocks( this );
      first = DinosaurType.Allosaurus.create();
      second = DinosaurType.Stegosaurus.create();
      systemUnderTest = new TurnActions( 
               DinosaurType.Allosaurus, DinosaurActionType.ArmorPiercingImpact, 
               DinosaurType.Stegosaurus, DinosaurActionType.SuperiorityStrike
      );
   }//End Method

   @Test public void shouldProvideActions() {
      assertThat( systemUnderTest.actionForDinosaur( first ), is( first.actions().get( 1 ) ) );
      assertThat( systemUnderTest.actionForDinosaur( second ), is( second.actions().get( 0 ) ) );
   }//End Method

}//End Class
