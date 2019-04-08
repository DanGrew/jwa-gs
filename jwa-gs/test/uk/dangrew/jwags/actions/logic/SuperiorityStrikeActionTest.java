package uk.dangrew.jwags.actions.logic;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;
import static uk.dangrew.jwags.model.DinosaurType.BasicDinosaur;

import org.junit.Before;
import org.junit.Test;
import org.mockito.MockitoAnnotations;

import uk.dangrew.jwags.effects.logic.Distraction;
import uk.dangrew.jwags.model.BattlingDinosaur;
import uk.dangrew.jwags.model.DinosaurType;
import uk.dangrew.kode.launch.TestApplication;

public class SuperiorityStrikeActionTest {

   private BattlingDinosaur first;
   private BattlingDinosaur second;
   private SuperiorityStrikeAction systemUnderTest;

   @Before public void initialiseSystemUnderTest() {
      TestApplication.startPlatform();
      MockitoAnnotations.initMocks( this );
      
      first = DinosaurType.BasicDinosaur.create();
      second = BasicDinosaur.create();
      systemUnderTest = new SuperiorityStrikeAction();
   }//End Method

   @Test public void shouldPerformBasicAttack() {
      systemUnderTest.execute( first, second );
      assertThat( second.health(), is( BasicDinosaur.health() - BasicDinosaur.damage() ) );
   }//End Method
   
   @Test public void shouldCleanseDistraction() {
      first.attackingEffects().add( new Distraction( 4, 0.5 ) );
      first.attackingEffects().add( new Distraction( 4, 0.25 ) );
      assertThat( first.damage(), is( BasicDinosaur.damage() / 8 ) );
      systemUnderTest.execute( first, second );
      assertThat( second.health(), is( BasicDinosaur.health() - BasicDinosaur.damage() ) );
   }//End Method

}//End Class
