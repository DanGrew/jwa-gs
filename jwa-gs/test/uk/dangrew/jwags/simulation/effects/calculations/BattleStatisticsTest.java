package uk.dangrew.jwags.simulation.effects.calculations;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;
import static uk.dangrew.jwags.simulation.model.DinosaurType.BasicDinosaur;

import org.junit.Before;
import org.junit.Test;
import org.mockito.MockitoAnnotations;

import uk.dangrew.jwags.simulation.effects.calculations.BattleStatistics;
import uk.dangrew.jwags.simulation.effects.logic.Distraction;
import uk.dangrew.jwags.simulation.effects.logic.Shield;
import uk.dangrew.jwags.simulation.effects.logic.SpeedReduction;
import uk.dangrew.jwags.simulation.model.BattlingDinosaur;
import uk.dangrew.jwags.simulation.model.DinosaurType;
import uk.dangrew.kode.launch.TestApplication;

public class BattleStatisticsTest {

   private BattlingDinosaur dinosaur;
   private BattleStatistics systemUnderTest;

   @Before public void initialiseSystemUnderTest() {
      TestApplication.startPlatform();
      MockitoAnnotations.initMocks( this );
      dinosaur = DinosaurType.BasicDinosaur.create();
      systemUnderTest = new BattleStatistics();
   }//End Method

   @Test public void shouldCalculateSpeedFromEffects(){
      assertThat( systemUnderTest.speedOf( dinosaur ), is( BasicDinosaur.speed() ) );
      dinosaur.attackingEffects().add( new SpeedReduction( 1 ) );
      assertThat( systemUnderTest.speedOf( dinosaur ), is( DinosaurType.BasicDinosaur.speed() / 2 ) );
      dinosaur.attackingEffects().add( new SpeedReduction( 2 ) );
      assertThat( systemUnderTest.speedOf( dinosaur ), is( DinosaurType.BasicDinosaur.speed() / 4 ) );
      
      dinosaur.attacked();
      assertThat( systemUnderTest.speedOf( dinosaur ), is( DinosaurType.BasicDinosaur.speed() / 2 ) );
   }//End Method
   
   @Test public void shouldCalculateDamageFromEffects(){
      assertThat( systemUnderTest.damageOf( dinosaur ), is( DinosaurType.BasicDinosaur.damage() ) );
      dinosaur.attackingEffects().add( new Distraction( 1, 0.5 ) );
      assertThat( systemUnderTest.damageOf( dinosaur ), is( DinosaurType.BasicDinosaur.damage() / 2 ) );
      dinosaur.attackingEffects().add( new Distraction( 2, 0.5 ) );
      assertThat( systemUnderTest.damageOf( dinosaur ), is( DinosaurType.BasicDinosaur.damage() / 4 ) );
      
      dinosaur.attacked();
      assertThat( systemUnderTest.damageOf( dinosaur ), is( DinosaurType.BasicDinosaur.damage() / 2 ) );
   }//End Method
   
   @Test public void shouldReduceDamageForShield(){
      assertThat( systemUnderTest.damageAgainst( dinosaur, 100 ), is( 100 ) );
      dinosaur.defendingEffects().add( new Shield( 1, 0.5 ) );
      assertThat( systemUnderTest.damageAgainst( dinosaur, 100 ), is( 100 / 2 ) );
      dinosaur.defendingEffects().add( new Shield( 2, 0.5 ) );
      assertThat( systemUnderTest.damageAgainst( dinosaur, 100 ), is( 100 / 4 ) );
      
      dinosaur.defended();
      assertThat( systemUnderTest.damageAgainst( dinosaur, 100 ), is( 100 / 2 ) );
   }//End Method

}//End Class
