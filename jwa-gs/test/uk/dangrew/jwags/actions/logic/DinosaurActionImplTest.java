package uk.dangrew.jwags.actions.logic;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;

import java.util.function.Supplier;

import org.junit.Before;
import org.junit.Test;
import org.mockito.MockitoAnnotations;

import uk.dangrew.jwags.effects.logic.Distraction;
import uk.dangrew.jwags.effects.logic.Effect;
import uk.dangrew.jwags.model.BattlingDinosaur;
import uk.dangrew.jwags.model.DinosaurActionType;
import uk.dangrew.jwags.model.DinosaurType;
import uk.dangrew.kode.launch.TestApplication;

public class DinosaurActionImplTest {

   private class TestDinosaurAction extends DinosaurActionImpl {

      public TestDinosaurAction() {
         super( 1, 2, distractionSupplier );
      }//End Constructor

      @Override protected DinosaurActionType type() {
         return DinosaurActionType.Strike;
      }//End Method

      @Override protected void performAction( BattlingDinosaur attacking, BattlingDinosaur defending ) {
         performedAction = true;
      }//End Method
      
   }//End Class
    
   private BattlingDinosaur attacking;
   private BattlingDinosaur defending;
   
   private Distraction distraction;
   private Supplier< Effect > distractionSupplier;
   private boolean performedAction;
   
   private TestDinosaurAction systemUnderTest;

   @Before public void initialiseSystemUnderTest() {
      TestApplication.startPlatform();
      MockitoAnnotations.initMocks( this );
      distractionSupplier = () -> distraction = new Distraction( 1, 0.5 );
      attacking = spy( DinosaurType.BasicDinosaur.create() );
      defending = spy( DinosaurType.ArmoredDinosaur.create() );
      systemUnderTest = new TestDinosaurAction();
   }//End Method

   @Test public void shouldNotBeAvailableWhenDelayed() {
      assertThat( systemUnderTest.isAvailable(), is( false ) );
      systemUnderTest.turnComplete();
      assertThat( systemUnderTest.isAvailable(), is( true ) );
   }//End Method
   
   @Test public void shouldNotBeAvailableUntilCooledDown() {
      shouldNotBeAvailableWhenDelayed();
      systemUnderTest.execute( attacking, defending );
      
      assertThat( systemUnderTest.isAvailable(), is( false ) );
      systemUnderTest.turnComplete();
      assertThat( systemUnderTest.isAvailable(), is( false ) );
      systemUnderTest.turnComplete();
      assertThat( systemUnderTest.isAvailable(), is( true ) );
   }//End Method
   
   @Test public void shouldExecuteAction(){
      systemUnderTest.execute( attacking, defending );
      assertThat( performedAction, is( true ) );
      assertThat( defending.effects(), hasSize( 1 ) );
      assertThat( defending.effects().get( 0 ), is( distraction ) );
      verify( attacking ).turnComplete();
      assertThat( systemUnderTest.currentCooldown(), is( 2 ) );
   }//End Method

}//End Class
