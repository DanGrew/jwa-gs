package uk.dangrew.jwags.simulation.effects.logic;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;
import org.mockito.MockitoAnnotations;

import uk.dangrew.jwags.simulation.effects.logic.Effect;
import uk.dangrew.jwags.simulation.effects.logic.EffectImpl;
import uk.dangrew.jwags.simulation.effects.snapshot.EffectSnapshot;
import uk.dangrew.kode.launch.TestApplication;

public class EffectImplTest {

   private class TestEffect extends EffectImpl {

      public TestEffect( int activeForTurns ) {
         super( null, activeForTurns );
      }//End Constructor

      @Override public EffectSnapshot snapshot() {
         return null;
      }//End Method
      
      @Override public Effect copy() {
         return new TestEffect( turnsRemaining() );
      }//End Method
      
   }//End Class
   
   private TestEffect systemUnderTest;

   @Before public void initialiseSystemUnderTest() {
      TestApplication.startPlatform();
      MockitoAnnotations.initMocks( this );
      systemUnderTest = new TestEffect( 2 );
   }//End Method

   @Test public void shouldBeActiveForNumberOfTurns() {
      assertThat( systemUnderTest.hasExpired(), is( false ) );
      systemUnderTest.turnComplete();
      assertThat( systemUnderTest.hasExpired(), is( false ) );
      systemUnderTest.turnComplete();
      assertThat( systemUnderTest.hasExpired(), is( true ) );
   }//End Method

}
