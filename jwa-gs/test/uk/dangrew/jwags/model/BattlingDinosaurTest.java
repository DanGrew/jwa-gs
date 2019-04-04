package uk.dangrew.jwags.model;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static uk.dangrew.jwags.model.DinosaurType.BasicDinosaur;

import org.junit.Before;
import org.junit.Test;
import org.mockito.MockitoAnnotations;

import uk.dangrew.jwags.effects.logic.Distraction;
import uk.dangrew.jwags.effects.logic.SpeedReduction;
import uk.dangrew.kode.launch.TestApplication;

public class BattlingDinosaurTest {

   private BattlingDinosaur systemUnderTest;

   @Before public void initialiseSystemUnderTest() {
      TestApplication.startPlatform();
      MockitoAnnotations.initMocks( this );
      systemUnderTest = DinosaurType.BasicDinosaur.create();
   }//End Method

   @Test public void shouldCalculateSpeedFromEffects(){
      assertThat( systemUnderTest.speed(), is( BasicDinosaur.speed() ) );
      systemUnderTest.apply( new SpeedReduction( 1 ) );
      assertThat( systemUnderTest.speed(), is( DinosaurType.BasicDinosaur.speed() / 2 ) );
      systemUnderTest.apply( new SpeedReduction( 2 ) );
      assertThat( systemUnderTest.speed(), is( DinosaurType.BasicDinosaur.speed() / 4 ) );
      
      systemUnderTest.turnComplete();
      assertThat( systemUnderTest.speed(), is( DinosaurType.BasicDinosaur.speed() / 2 ) );
   }//End Method
   
   @Test public void shouldCalculateDamageFromEffects(){
      assertThat( systemUnderTest.damage(), is( DinosaurType.BasicDinosaur.damage() ) );
      systemUnderTest.apply( new Distraction( 1, 0.5 ) );
      assertThat( systemUnderTest.damage(), is( DinosaurType.BasicDinosaur.damage() / 2 ) );
      systemUnderTest.apply( new Distraction( 2, 0.5 ) );
      assertThat( systemUnderTest.damage(), is( DinosaurType.BasicDinosaur.damage() / 4 ) );
      
      systemUnderTest.turnComplete();
      assertThat( systemUnderTest.damage(), is( DinosaurType.BasicDinosaur.damage() / 2 ) );
   }//End Method
   
   @Test public void shouldCompleteTurnForEachAction(){
      systemUnderTest.actions().get( 1 ).execute( systemUnderTest, BasicDinosaur.create() );
      assertThat( systemUnderTest.actions().get( 1 ).currentCooldown(), is( 1 ) );
      systemUnderTest.turnComplete();
      assertThat( systemUnderTest.actions().get( 1 ).currentCooldown(), is( 0 ) );
   }//End Method
   
   @Test public void shouldProduceSnapshot(){
      assertThat( systemUnderTest.snapshot().speed(), is( BasicDinosaur.speed() ) );
      assertThat( systemUnderTest.snapshot().damage(), is( BasicDinosaur.damage() ) );
      systemUnderTest.apply( new SpeedReduction( 1 ) );
      assertThat( systemUnderTest.snapshot().speed(), is( BasicDinosaur.speed() / 2 ) );
      systemUnderTest.apply( new Distraction( 1, 0.5 ) );
      assertThat( systemUnderTest.snapshot().damage(), is( BasicDinosaur.damage() / 2 ) );
      
      systemUnderTest.actions().get( 1 ).execute( systemUnderTest, BasicDinosaur.create() );
      assertThat( systemUnderTest.snapshot().actions().get( 1 ).getCooldown(), is( systemUnderTest.actions().get( 1 ).currentCooldown() ) );
   }//End Method

}//End Class
