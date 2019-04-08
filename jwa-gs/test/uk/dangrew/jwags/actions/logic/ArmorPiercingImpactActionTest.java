package uk.dangrew.jwags.actions.logic;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static uk.dangrew.jwags.model.DinosaurType.ArmoredDinosaur;
import static uk.dangrew.jwags.model.DinosaurType.BasicDinosaur;

import org.junit.Before;
import org.junit.Test;
import org.mockito.MockitoAnnotations;

import uk.dangrew.jwags.effects.logic.Shield;
import uk.dangrew.jwags.model.BattlingDinosaur;
import uk.dangrew.kode.launch.TestApplication;

public class ArmorPiercingImpactActionTest {

   private BattlingDinosaur raptor;
   private BattlingDinosaur stego;
   private ArmorPiercingImpactAction systemUnderTest;

   @Before public void initialiseSystemUnderTest() {
      TestApplication.startPlatform();
      MockitoAnnotations.initMocks( this );
      raptor = BasicDinosaur.create();
      stego = ArmoredDinosaur.create();
      systemUnderTest = new ArmorPiercingImpactAction();
   }//End Method

   @Test public void shouldApplyDamage() {
      assertThat( raptor.health(), is( BasicDinosaur.health() ) );
      assertThat( stego.health(), is( ArmoredDinosaur.health() ) );
      
      systemUnderTest.execute( raptor, stego );
      
      assertThat( stego.health(), is( ( int )( ArmoredDinosaur.health() - BasicDinosaur.damage() * 1.5 ) ) );
   }//End Method
   
   @Test public void shouldNotDestroyShields() {
      assertThat( raptor.health(), is( BasicDinosaur.health() ) );
      assertThat( stego.health(), is( ArmoredDinosaur.health() ) );
      
      stego.defendingEffects().add( new Shield( 4, 0.5 ) );
      
      systemUnderTest.execute( raptor, stego );
      assertThat( stego.health(), is( ( int )( ArmoredDinosaur.health() - BasicDinosaur.damage() * 1.5 * 0.5 ) ) );
   }//End Method
   
}//End Class
