package uk.dangrew.jwags.ui.analysis.individual;

import org.junit.Before;
import org.junit.Test;
import org.mockito.MockitoAnnotations;

import uk.dangrew.jwags.simulation.analysis.individual.BattleChallenge;
import uk.dangrew.jwags.simulation.analysis.individual.BattleChallengeStore;
import uk.dangrew.jwags.simulation.model.DinosaurType;
import uk.dangrew.kode.launch.TestApplication;

public class UiOneOnOnTableTest {

   private UiBattleChallengeTable systemUnderTest;

   @Before public void initialiseSystemUnderTest() {
      TestApplication.startPlatform();
      MockitoAnnotations.initMocks( this );
      
      BattleChallengeStore store = new BattleChallengeStore();
      
      for ( DinosaurType type : DinosaurType.values() ) {
         if ( !type.isGameDinosaur() ) {
            continue;
         }
         store.createConcept( type.name() );
      }
      systemUnderTest = new UiBattleChallengeTable( store );
   }//End Method

   @Test public void manual() throws InterruptedException {
      TestApplication.launch( () -> systemUnderTest );
      
      Thread.sleep( 999999999 );
   }//End Method

}//End Class
