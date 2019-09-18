package uk.dangrew.jwags.ui.analysis.individual;

import uk.dangrew.jwags.simulation.analysis.individual.BattleChallenge;
import uk.dangrew.jwags.simulation.analysis.individual.BattleChallengeStore;
import uk.dangrew.nuts.graphics.table.ConceptTable;

public class UiBattleChallengeTable extends ConceptTable< BattleChallenge >{

   public UiBattleChallengeTable( BattleChallengeStore store ) {
      super( new BattleChallengeColumnPopulator(), new BattleChallengeController( store ) );
   }//End Constructor

}//End Class
