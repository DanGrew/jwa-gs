package uk.dangrew.jwags.effects;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;
import org.mockito.MockitoAnnotations;

import uk.dangrew.jwags.effects.logic.SpeedReduction;
import uk.dangrew.kode.launch.TestApplication;

public class SuperiorityStrikeEffectTest {

   private SpeedReduction systemUnderTest;

   @Before public void initialiseSystemUnderTest() {
      TestApplication.startPlatform();
      MockitoAnnotations.initMocks( this );
      systemUnderTest = new SpeedReduction( 1 );
   }//End Method

   @Test public void shouldExpireAfterOneTurn() {
      assertThat( systemUnderTest.hasExpired(), is( false ) );
      systemUnderTest.turnComplete();
      assertThat( systemUnderTest.hasExpired(), is( true ) );
      systemUnderTest.turnComplete();
      assertThat( systemUnderTest.hasExpired(), is( true ) );
   }//End Method
   
   @Test public void shouldModifySpeed(){
      assertThat( systemUnderTest.modifySpeed( 6 ), is( 3 ) );
      assertThat( systemUnderTest.modifySpeed( 7 ), is( 4 ) );
   }//End Method

}//End Class
