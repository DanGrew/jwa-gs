package uk.dangrew.jwags.simulation;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import uk.dangrew.jwags.actions.snapshot.DinosaurActionSnapshot;
import uk.dangrew.jwags.model.BattleSnapshot;
import uk.dangrew.kode.launch.TestApplication;

public class MatchTest {

   private Match systemUnderTest;

   @Before public void initialiseSystemUnderTest() {
      TestApplication.startPlatform();
      MockitoAnnotations.initMocks( this );
      systemUnderTest = new Match();
   }//End Method

   @Test public void shouldIdentifyFinish() {
      assertThat( systemUnderTest.hasConcluded(), is( false ) );
      systemUnderTest.addRecord( new MatchRecord( 
               MatchRecordType.FirstAction, 
               Mockito.mock( DinosaurActionSnapshot.class ), 
               Mockito.mock( BattleSnapshot.class ), 
               MatchResult.Incomplete 
      ) );
      assertThat( systemUnderTest.hasConcluded(), is( false ) );
      systemUnderTest.addRecord( new MatchRecord( 
               MatchRecordType.FirstAction, 
               Mockito.mock( DinosaurActionSnapshot.class ), 
               Mockito.mock( BattleSnapshot.class ), 
               MatchResult.FirstWon 
      ) );
      assertThat( systemUnderTest.hasConcluded(), is( true ) );
   }//End Method
   
   @Test public void shouldIdentifyInvalidActions(){
      assertThat( systemUnderTest.hasConcluded(), is( false ) );
      systemUnderTest.addRecord( new MatchRecord( 
               MatchRecordType.FirstAction, 
               Mockito.mock( DinosaurActionSnapshot.class ), 
               Mockito.mock( BattleSnapshot.class ), 
               MatchResult.Incomplete 
      ) );
      assertThat( systemUnderTest.isInvalidActionSet(), is( false ) );
      systemUnderTest.addRecord( new MatchRecord( 
               MatchRecordType.FirstAction, 
               Mockito.mock( DinosaurActionSnapshot.class ), 
               Mockito.mock( BattleSnapshot.class ), 
               MatchResult.FirstActionUnnavailable 
      ) );
      assertThat( systemUnderTest.isInvalidActionSet(), is( true ) );
   }//End Method
   
   @Test public void shouldCopy(){
      for ( int i = 0; i < 4; i++ ) {
         systemUnderTest.addRecord( Mockito.mock( MatchRecord.class ) );
      }
      
      Match copy = systemUnderTest.copy();
      assertThat( copy.records().size(), is( systemUnderTest.records().size() ) );
      
      for ( int i = 0; i < copy.records().size(); i++ ) {
         assertThat( copy.records().get( i ), is( systemUnderTest.records().get( i ) ) );
      }
   }//End Method

}//End Class
