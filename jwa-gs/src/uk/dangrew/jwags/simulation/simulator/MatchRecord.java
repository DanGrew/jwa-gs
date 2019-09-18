package uk.dangrew.jwags.simulation.simulator;

import java.util.function.Function;

import uk.dangrew.jwags.simulation.actions.snapshot.DinosaurActionSnapshot;
import uk.dangrew.jwags.simulation.model.BattleSnapshot;

public class MatchRecord {

   private final MatchRecordType type;
   private final DinosaurActionSnapshot action;
   private final BattleSnapshot resultingSnapshot;
   private final MatchResult result;
   
   public MatchRecord(
            MatchRecordType type, 
            DinosaurActionSnapshot action,
            BattleSnapshot resultingSnapshot,
            MatchResult result
   ) {
      this.type = type;
      this.action = action;
      this.resultingSnapshot = resultingSnapshot;
      this.result = result;
   }//End Constructor

   public MatchRecordType getType() {
      return type;
   }//End Method

   public DinosaurActionSnapshot getAction() {
      return action;
   }//End Method

   public BattleSnapshot getResultingSnapshot() {
      return resultingSnapshot;
   }//End Method

   public MatchResult getResult() {
      return result;
   }//End Method

   public String displayableDescription(){
      return new StringBuilder()
         .append( "Record: " ).append( type.name() ).append( "\n" )
         .append( "Action: " ).append( elementToString( action, Function.identity() ) ).append( "\n" )
         .append( "First Dinosaur: " ).append( resultingSnapshot.first() ).append( "\n" )
         .append( "Second Dinosaur: " ).append( resultingSnapshot.second() ).append( "\n" )
         .append( "Result: " ).append( result.name() ).append( "\n" )
         .toString();
   }//End Method
   
   private < X, Y > String elementToString( X object, Function< X, Y > extractor ) {
      if ( object == null ) {
         return null;
      } else {
         return extractor.apply( object ).toString();
      }
   }//End Method
}//End Class
