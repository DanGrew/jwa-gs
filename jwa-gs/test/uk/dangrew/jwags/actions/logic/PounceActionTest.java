package uk.dangrew.jwags.actions.logic;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static uk.dangrew.jwags.model.DinosaurType.ArmoredDinosaur;
import static uk.dangrew.jwags.model.DinosaurType.BasicDinosaur;

import org.junit.Before;
import org.junit.Test;
import org.mockito.MockitoAnnotations;

import uk.dangrew.jwags.model.BattlingDinosaur;
import uk.dangrew.jwags.model.DinosaurType;
import uk.dangrew.kode.launch.TestApplication;

public class PounceActionTest {

   private BattlingDinosaur raptor;;
   private BattlingDinosaur stego;
   private PounceAction systemUnderTest;

   @Before public void initialiseSystemUnderTest() {
      TestApplication.startPlatform();
      MockitoAnnotations.initMocks( this );
      raptor = BasicDinosaur.create();
      stego = ArmoredDinosaur.create();
      systemUnderTest = new PounceAction();
   }//End Method

   @Test public void shouldApplyDamage() {
      assertThat( raptor.health(), is( BasicDinosaur.health() ) );
      assertThat( stego.health(), is( ArmoredDinosaur.health() ) );
      
      systemUnderTest.execute( stego, raptor );
      
      assertThat( raptor.health(), is( BasicDinosaur.health() - ArmoredDinosaur.damage() * 2 ) );
      assertThat( stego.health(), is( ArmoredDinosaur.health() ) );
   }//End Method
   
   @Test public void shouldAbsorbDamageInArmor() {
      assertThat( raptor.health(), is( BasicDinosaur.health() ) );
      assertThat( stego.health(), is( ArmoredDinosaur.health() ) );
      
      systemUnderTest.execute( raptor, stego );
      
      //ArmoredDinosaur.health() - ( 1.0 - ArmoredDinosaur.armor()/100.0 ) * BasicDinosaur.damage()
      //4500 - ( 1 - 0.2 ) *  (1320 * 2) = 4500 - 2112 = 2388
      assertThat( raptor.health(), is( BasicDinosaur.health() ) );
      assertThat( stego.health(), is( 2388 ) );
   }//End Method
   
   @Test public void shouldReduceDamageOfDefender(){
      systemUnderTest.execute( raptor, stego );
      assertThat( stego.damage(), is( ( int )( ArmoredDinosaur.damage() * PounceAction.defenderDamageReductionMultiplier() ) ) );
   }//End Method

}//End Class
