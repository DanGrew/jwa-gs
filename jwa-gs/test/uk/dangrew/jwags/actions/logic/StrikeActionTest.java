package uk.dangrew.jwags.actions.logic;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static uk.dangrew.jwags.model.DinosaurType.ArmoredDinosaur;
import static uk.dangrew.jwags.model.DinosaurType.BasicDinosaur;

import org.junit.Before;
import org.junit.Test;
import org.mockito.MockitoAnnotations;

import uk.dangrew.jwags.model.BattlingDinosaur;
import uk.dangrew.kode.launch.TestApplication;

public class StrikeActionTest {

   private StrikeAction systemUnderTest;

   @Before public void initialiseSystemUnderTest() {
      TestApplication.startPlatform();
      MockitoAnnotations.initMocks( this );
      systemUnderTest = new StrikeAction();
   }//End Method

   @Test public void shouldApplyDamage() {
      BattlingDinosaur raptor = BasicDinosaur.create();
      BattlingDinosaur stego = ArmoredDinosaur.create();
      
      assertThat( raptor.health(), is( BasicDinosaur.health() ) );
      assertThat( stego.health(), is( ArmoredDinosaur.health() ) );
      
      systemUnderTest.execute( stego, raptor );
      
      assertThat( raptor.health(), is( BasicDinosaur.health() - ArmoredDinosaur.damage() ) );
      assertThat( stego.health(), is( ArmoredDinosaur.health() ) );
   }//End Method
   
   @Test public void shouldAbsorbDamageInArmor() {
      BattlingDinosaur raptor = BasicDinosaur.create();
      BattlingDinosaur stego = ArmoredDinosaur.create();
      
      assertThat( raptor.health(), is( BasicDinosaur.health() ) );
      assertThat( stego.health(), is( ArmoredDinosaur.health() ) );
      
      systemUnderTest.execute( raptor, stego );
      
      //ArmoredDinosaur.health() - ( 1.0 - ArmoredDinosaur.armor()/100.0 ) * BasicDinosaur.damage()
      //4500 - ( 1 - 0.2 ) * 1320 = 4500 - 1056 = 3444
      assertThat( raptor.health(), is( BasicDinosaur.health() ) );
      assertThat( stego.health(), is( 3444 ) );
   }//End Method

}//End Class
