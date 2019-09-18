package uk.dangrew.jwags.simulation.analysis.individual;

import java.util.EnumMap;

import uk.dangrew.jwags.simulation.model.DinosaurType;
import uk.dangrew.jwags.simulation.simulator.MatchGenerator;
import uk.dangrew.jwags.simulation.simulator.SimulatedMatches;
import uk.dangrew.kode.concept.Concept;
import uk.dangrew.kode.concept.Properties;

public class BattleChallenge implements Concept {

   private final MatchGenerator generator;
   
   private final Properties properties;
   private final DinosaurType challenger;
   private final EnumMap< DinosaurType, SimulatedMatches > challenges;
   
   public BattleChallenge( DinosaurType challenger ) {
      this( new Properties( challenger.name() ) );
   }//End Constructor
   
   public BattleChallenge( String name ) {
      this( new Properties( name ) );
   }//End Constructor
   
   public BattleChallenge( String id, String name ) {
      this( new Properties( id, name ) );
   }//End Constructor
   
   public BattleChallenge( Properties properties ) {
      this.properties = properties;
      this.challenger = DinosaurType.valueOf( properties.nameProperty().get() );
      this.generator = new MatchGenerator();
      this.challenges = new EnumMap<>( DinosaurType.class );
      
         for ( DinosaurType respondingType : DinosaurType.values() ) {
            if ( challenger == respondingType ) {
               continue;
            }
            if ( !respondingType.isGameDinosaur() ) {
               continue;
            }
            
            challenges.put( 
                     respondingType, generator.generate( 
                              challenger.create(), 
                              respondingType.create()
                     )
            );
      }
   }//End Constructor
   
   @Override public Properties properties() {
      return properties;
   }//End Method
   
   @Override public Concept duplicate() {
      return null;
   }//End Method
   
   public DinosaurType challenger(){
      return challenger;
   }//End Method
   
   public SimulatedMatches matchesFor( DinosaurType responder ) {
      return challenges.get( responder );
   }//End Method
   
   public long winsAgainst( DinosaurType responder ) {
      if ( challenges.get( responder ) == null ) {
         return 0;
      }
      return challenges.get( responder ).matches().stream()
               .filter( m -> m.winner() == challenger )
               .count();
   }//End Method
   
   public String stringResult( DinosaurType responder ){
      if ( challenges.get( responder ) == null ) {
         return "";
      }
      return winsAgainst( responder ) + "/" + matchesFor( responder ).matches().size();
   }//End Method
   
}//End Class
