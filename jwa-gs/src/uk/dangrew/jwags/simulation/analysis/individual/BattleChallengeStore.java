package uk.dangrew.jwags.simulation.analysis.individual;

import uk.dangrew.kode.concept.ConceptStore;
import uk.dangrew.kode.storage.structure.MappedObservableStoreManagerImpl;
import uk.dangrew.nuts.food.FoodItem;

public class BattleChallengeStore extends MappedObservableStoreManagerImpl< String, BattleChallenge > implements ConceptStore< BattleChallenge > {

   public BattleChallengeStore() {
      super( f -> f.properties().id() );
   }//End Constructor

   /**
    * {@inheritDoc}
    */
   @Override public BattleChallenge createConcept( String name ) {
      BattleChallenge food = new BattleChallenge( name );
      store( food );
      return food;
   }//End Method
   
   /**
    * {@inheritDoc}
    */
   @Override public BattleChallenge createConcept( String id, String name ) {
      BattleChallenge concept = new BattleChallenge( id, name );
      store( concept );
      return concept;
   }//End Method
   
   /**
    * {@inheritDoc}
    */
   @Override public void store( BattleChallenge concept ) {
      super.store( concept );
   }//End Method
   
   /**
    * {@inheritDoc}
    */
   @Override public void removeConcept( BattleChallenge concept ) {
      remove( concept.properties().id() );
   }//End Method

   
}//End Class
