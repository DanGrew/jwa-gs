package uk.dangrew.jwags.actions.logic;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;
import org.mockito.MockitoAnnotations;

import uk.dangrew.jwags.model.BattlingDinosaur;
import uk.dangrew.jwags.model.DinosaurActionType;
import uk.dangrew.jwags.model.DinosaurType;
import uk.dangrew.kode.launch.TestApplication;

public class StandardAttackActionTest {

   private class TestStandardAttackAction extends StandardAttackAction {

      protected TestStandardAttackAction() {
         super( 1, 2, 1.0 );
      }//End Constructor

      @Override protected DinosaurActionType type() {
         return DinosaurActionType.Strike;
      }//End Method
      
   }//End Class
   
   private TestStandardAttackAction systemUnderTest;

   @Before public void initialiseSystemUnderTest() {
      TestApplication.startPlatform();
      MockitoAnnotations.initMocks( this );
      systemUnderTest = new TestStandardAttackAction();
   }//End Method

   @Test public void shouldCalculateDamageAccountingForArmor() {
      BattlingDinosaur raptor = DinosaurType.BasicDinosaur.create();
      BattlingDinosaur stego = DinosaurType.ArmoredDinosaur.create();
      
      assertThat( raptor.health(), is( DinosaurType.BasicDinosaur.health() ) );
      assertThat( stego.health(), is( DinosaurType.ArmoredDinosaur.health() ) );
      
      systemUnderTest.execute( raptor, stego );
      
      //Stegosaurus.health() - ( 1.0 - Stegosaurus.armor()/100.0 ) * Velociraptor.damage()
      //4500 - ( 1 - 0.2 ) * 1320 = 4500 - 1056 = 3444
      assertThat( raptor.health(), is( DinosaurType.BasicDinosaur.health() ) );
      assertThat( stego.health(), is( 3444 ) );
   }//End Method

}//End Class
