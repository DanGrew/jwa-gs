package uk.dangrew.jwags.effects.logic;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;
import org.mockito.MockitoAnnotations;

import uk.dangrew.kode.launch.TestApplication;

public class DistractionTest {

   private Distraction systemUnderTest;

   @Before public void initialiseSystemUnderTest() {
      TestApplication.startPlatform();
      MockitoAnnotations.initMocks( this );
      systemUnderTest = new Distraction( 2, 0.5 );
   }//End Method

   @Test public void shouldModifyDamage() {
      assertThat( systemUnderTest.modifyDamage( 20 ), is( 10 ) );
      assertThat( systemUnderTest.modifyDamage( 21 ), is( 11 ) );
   }//End Method
   
   @Test public void shouldProvieSnapshot(){
      assertThat( systemUnderTest.snapshot().getRemainingTurnsActiveFor(), is( 2 ) );
      systemUnderTest.turnComplete();
      assertThat( systemUnderTest.snapshot().getRemainingTurnsActiveFor(), is( 1 ) );
   }//End Method

}//End Class
