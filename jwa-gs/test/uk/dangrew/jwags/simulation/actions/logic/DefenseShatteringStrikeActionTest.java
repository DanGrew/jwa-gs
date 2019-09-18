package uk.dangrew.jwags.simulation.actions.logic;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static uk.dangrew.jwags.simulation.model.DinosaurType.ArmoredDinosaur;
import static uk.dangrew.jwags.simulation.model.DinosaurType.BasicDinosaur;

import org.junit.Before;
import org.junit.Test;
import org.mockito.MockitoAnnotations;

import uk.dangrew.jwags.simulation.actions.logic.DefenseShatteringStrikeAction;
import uk.dangrew.jwags.simulation.effects.logic.Shield;
import uk.dangrew.jwags.simulation.model.BattlingDinosaur;
import uk.dangrew.kode.launch.TestApplication;

public class DefenseShatteringStrikeActionTest {

   private BattlingDinosaur raptor;
   private BattlingDinosaur stego;
   private DefenseShatteringStrikeAction systemUnderTest;

   @Before public void initialiseSystemUnderTest() {
      TestApplication.startPlatform();
      MockitoAnnotations.initMocks( this );
      raptor = BasicDinosaur.create();
      stego = ArmoredDinosaur.create();
      systemUnderTest = new DefenseShatteringStrikeAction();
   }//End Method

   @Test public void shouldApplyDamage() {
      assertThat( raptor.health(), is( BasicDinosaur.health() ) );
      assertThat( stego.health(), is( ArmoredDinosaur.health() ) );
      
      systemUnderTest.execute( raptor, stego );
      
      assertThat( stego.health(), is( ArmoredDinosaur.health() - BasicDinosaur.damage() ) );
   }//End Method
   
   @Test public void shouldDestroyShields() {
      assertThat( raptor.health(), is( BasicDinosaur.health() ) );
      assertThat( stego.health(), is( ArmoredDinosaur.health() ) );
      
      stego.defendingEffects().add( new Shield( 4, 0.5 ) );
      
      systemUnderTest.execute( raptor, stego );
      assertThat( stego.health(), is( ArmoredDinosaur.health() - BasicDinosaur.damage() ) );
   }//End Method
   
}//End Class
