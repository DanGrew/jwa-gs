package uk.dangrew.jwags.simulation.effects.logic;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;
import org.mockito.MockitoAnnotations;

import uk.dangrew.jwags.simulation.effects.logic.SpeedReduction;
import uk.dangrew.kode.launch.TestApplication;

public class SpeedReductionTest {

   private SpeedReduction systemUnderTest;

   @Before public void initialiseSystemUnderTest() {
      TestApplication.startPlatform();
      MockitoAnnotations.initMocks( this );
      systemUnderTest = new SpeedReduction( 2 );
   }//End Method

   @Test public void shouldModifyDamage() {
      assertThat( systemUnderTest.modifySpeed( 20 ), is( 10 ) );
      assertThat( systemUnderTest.modifySpeed( 21 ), is( 11 ) );
   }//End Method
   
   @Test public void shouldProvieSnapshot(){
      assertThat( systemUnderTest.snapshot().getRemainingTurnsActiveFor(), is( 2 ) );
      systemUnderTest.turnComplete();
      assertThat( systemUnderTest.snapshot().getRemainingTurnsActiveFor(), is( 1 ) );
   }//End Method

}//End Class
