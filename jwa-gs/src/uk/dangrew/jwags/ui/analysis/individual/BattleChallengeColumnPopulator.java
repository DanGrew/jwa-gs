package uk.dangrew.jwags.ui.analysis.individual;

import uk.dangrew.jwags.simulation.analysis.individual.BattleChallenge;
import uk.dangrew.jwags.simulation.model.DinosaurType;
import uk.dangrew.nuts.graphics.table.ConceptTable;
import uk.dangrew.nuts.graphics.table.ConceptTableColumnsPopulator;
import uk.dangrew.nuts.graphics.table.TableConfiguration;
import uk.dangrew.nuts.graphics.table.configuration.TableViewColumnConfigurer;

public class BattleChallengeColumnPopulator implements ConceptTableColumnsPopulator< BattleChallenge >{

   private final TableConfiguration configuration;
   
   public BattleChallengeColumnPopulator() {
      this.configuration = new TableConfiguration();
   }//End Constructor
   
   @Override public void populateColumns( ConceptTable< BattleChallenge > table ) {
      this.configuration.initialiseStringColumn(
               new TableViewColumnConfigurer<>( table ), 
               "Challenger", 
               0.4, 
               c -> c.properties().nameProperty().get() 
      );
      
      for ( DinosaurType type : DinosaurType.values() ) {
         this.configuration.initialiseStringColumn(
                  new TableViewColumnConfigurer<>( table ), 
                  type.name(), 
                  0.15, 
                  c -> c.stringResult( type ) 
         );  
      }
   }//End Method

}//End Class
