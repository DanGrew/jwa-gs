package uk.dangrew.jwags.effects.logic;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static uk.dangrew.jwags.model.DinosaurType.BasicDinosaur;

import org.junit.Before;
import org.junit.Test;
import org.mockito.MockitoAnnotations;

import uk.dangrew.jwags.model.BattlingDinosaur;
import uk.dangrew.jwags.model.DinosaurType;
import uk.dangrew.kode.launch.TestApplication;

public class ShieldTest {

   private BattlingDinosaur first;
   private BattlingDinosaur second;
   private Shield systemUnderTest;

   @Before public void initialiseSystemUnderTest() {
      TestApplication.startPlatform();
      MockitoAnnotations.initMocks( this );
      
      first = DinosaurType.BasicDinosaur.create();
      second = DinosaurType.BasicDinosaur.create();
      systemUnderTest = new Shield( 2, 0.5 );
      
      second.defendingEffects().add( systemUnderTest );
   }//End Method

   @Test public void shouldReduceDamageTaken() {
      first.actions().get( 0 ).execute( first, second );
      assertThat( second.health(), is( ( int )( BasicDinosaur.health() - BasicDinosaur.damage() * 0.5 ) ) );
   }//End Method
   
   @Test public void shouldNotReduceDamageDelt() {
      second.actions().get( 0 ).execute( second, first );
      assertThat( first.health(), is( ( int )( BasicDinosaur.health() - BasicDinosaur.damage() ) ) );
   }//End Method

}//End Class
