package uk.dangrew.jwags.simulation.model;

import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.Matchers.empty;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static uk.dangrew.jwags.simulation.model.DinosaurType.BasicDinosaur;

import org.junit.Before;
import org.junit.Test;
import org.mockito.MockitoAnnotations;

import uk.dangrew.jwags.simulation.effects.logic.Distraction;
import uk.dangrew.jwags.simulation.effects.logic.Shield;
import uk.dangrew.jwags.simulation.effects.logic.SpeedReduction;
import uk.dangrew.jwags.simulation.model.BattlingDinosaur;
import uk.dangrew.jwags.simulation.model.DinosaurType;
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
      systemUnderTest.attackingEffects().add( new SpeedReduction( 1 ) );
      assertThat( systemUnderTest.speed(), is( DinosaurType.BasicDinosaur.speed() / 2 ) );
      systemUnderTest.attackingEffects().add( new SpeedReduction( 2 ) );
      assertThat( systemUnderTest.speed(), is( DinosaurType.BasicDinosaur.speed() / 4 ) );
      
      systemUnderTest.attacked();
      assertThat( systemUnderTest.speed(), is( DinosaurType.BasicDinosaur.speed() / 2 ) );
   }//End Method
   
   @Test public void shouldCalculateDamageFromEffects(){
      assertThat( systemUnderTest.damage(), is( DinosaurType.BasicDinosaur.damage() ) );
      systemUnderTest.attackingEffects().add( new Distraction( 1, 0.5 ) );
      assertThat( systemUnderTest.damage(), is( DinosaurType.BasicDinosaur.damage() / 2 ) );
      systemUnderTest.attackingEffects().add( new Distraction( 2, 0.5 ) );
      assertThat( systemUnderTest.damage(), is( DinosaurType.BasicDinosaur.damage() / 4 ) );
      
      systemUnderTest.attacked();
      assertThat( systemUnderTest.damage(), is( DinosaurType.BasicDinosaur.damage() / 2 ) );
   }//End Method
   
   @Test public void shouldCompleteTurnForEachAction(){
      systemUnderTest.actions().get( 1 ).execute( systemUnderTest, BasicDinosaur.create() );
      assertThat( systemUnderTest.actions().get( 1 ).currentCooldown(), is( 1 ) );
      systemUnderTest.attacked();
      assertThat( systemUnderTest.actions().get( 1 ).currentCooldown(), is( 0 ) );
   }//End Method
   
   @Test public void shouldProduceSnapshot(){
      assertThat( systemUnderTest.snapshot().speed(), is( BasicDinosaur.speed() ) );
      assertThat( systemUnderTest.snapshot().damage(), is( BasicDinosaur.damage() ) );
      systemUnderTest.attackingEffects().add( new SpeedReduction( 1 ) );
      assertThat( systemUnderTest.snapshot().speed(), is( BasicDinosaur.speed() / 2 ) );
      systemUnderTest.attackingEffects().add( new Distraction( 1, 0.5 ) );
      assertThat( systemUnderTest.snapshot().damage(), is( BasicDinosaur.damage() / 2 ) );
      
      systemUnderTest.actions().get( 1 ).execute( systemUnderTest, BasicDinosaur.create() );
      assertThat( systemUnderTest.snapshot().actions().get( 1 ).getCooldown(), is( systemUnderTest.actions().get( 1 ).currentCooldown() ) );
   }//End Method
   
   @Test public void shouldRemoveDefenseWhenDefended(){
      assertThat( systemUnderTest.defendingEffects(), is( empty() ) );
      systemUnderTest.defendingEffects().add( new Shield( 1, 0.5 ) );
      assertThat( systemUnderTest.defendingEffects(), is( not( empty() ) ) );
      systemUnderTest.attacked();
      assertThat( systemUnderTest.defendingEffects(), is( not( empty() ) ) );
      systemUnderTest.attacked();
      assertThat( systemUnderTest.defendingEffects(), is( not( empty() ) ) );
      
      systemUnderTest.defended();
      assertThat( systemUnderTest.defendingEffects(), is( empty() ) );
   }//End Method
   
   @Test public void shouldRemoveAttackBuffsWhenAttacked(){
      assertThat( systemUnderTest.attackingEffects(), is( empty() ) );
      systemUnderTest.attackingEffects().add( new Distraction( 1, 0.5 ) );
      assertThat( systemUnderTest.attackingEffects(), is( not( empty() ) ) );
      systemUnderTest.defended();
      assertThat( systemUnderTest.attackingEffects(), is( not( empty() ) ) );
      systemUnderTest.defended();
      assertThat( systemUnderTest.attackingEffects(), is( not( empty() ) ) );
      
      systemUnderTest.attacked();
      assertThat( systemUnderTest.attackingEffects(), is( empty() ) );
   }//End Method

   @Test public void shouldCopy(){
      systemUnderTest.attackingEffects().add( new Distraction( 2, 0.5 ) );
      systemUnderTest.defendingEffects().add( new Shield( 2, 0.5 ) );
      
      systemUnderTest.setHealth( 56 );
      BattlingDinosaur copy = systemUnderTest.copy();
      
      assertThat( copy.health(), is( systemUnderTest.health() ) );
      assertThat( copy.actions().size(), is( systemUnderTest.actions().size() ) );
      for ( int i = 0; i < copy.actions().size(); i++ ) {
         assertThat( copy.actions().get( i ).type(), is( systemUnderTest.actions().get( i ).type() ) );
         assertThat( copy.actions().get( i ).currentCooldown(), is( systemUnderTest.actions().get( i ).currentCooldown() ) );
         assertThat( copy.actions().get( i ).currentDelay(), is( systemUnderTest.actions().get( i ).currentDelay() ) );
      }
      
      assertThat( copy.attackingEffects().size(), is( systemUnderTest.attackingEffects().size() ) );
      for ( int i = 0; i < copy.attackingEffects().size(); i++ ) {
         assertThat( copy.attackingEffects().get( i ).turnsRemaining(), is( systemUnderTest.attackingEffects().get( i ).turnsRemaining() ) );
         assertThat( copy.attackingEffects().get( i ).type(), is( systemUnderTest.attackingEffects().get( i ).type() ) );
      }
      
      assertThat( copy.defendingEffects().size(), is( systemUnderTest.defendingEffects().size() ) );
      for ( int i = 0; i < copy.defendingEffects().size(); i++ ) {
         assertThat( copy.defendingEffects().get( i ).turnsRemaining(), is( systemUnderTest.defendingEffects().get( i ).turnsRemaining() ) );
         assertThat( copy.defendingEffects().get( i ).type(), is( systemUnderTest.defendingEffects().get( i ).type() ) );
      }
   }//End Method
   
}//End Class
