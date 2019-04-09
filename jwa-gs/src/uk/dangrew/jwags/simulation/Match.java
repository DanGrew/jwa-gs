package uk.dangrew.jwags.simulation;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.StringJoiner;

public class Match {

   private final List< MatchRecord > records;
   
   public Match() {
      this.records = new ArrayList<>();
   }//End Constructor
   
   public void addRecord( MatchRecord record ) {
      this.records.add( record );
   }//End Method
   
   public List< MatchRecord > records(){
      return Collections.unmodifiableList( records );
   }//End Method
   
   public boolean hasConcluded(){
      return records.stream()
               .filter( r -> r.getResult() != MatchResult.Incomplete )
               .count() > 0;
   }//End Method
   
   public boolean isInvalidActionSet(){
      return records.stream()
               .filter( this::invalidAction )
               .count() > 0;
   }//End Method
   
   private boolean invalidAction( MatchRecord record ) {
      return record.getResult() == MatchResult.FirstActionUnnavailable ||
               record.getResult() == MatchResult.SecondActionUnnavailable;
   }//End Method
   
   public String displayableDescription(){
      StringJoiner joiner = new StringJoiner( "\n" );
      records.forEach( r -> joiner.add( r.displayableDescription() ) );
      return joiner.toString();
   }//End Method
   
   public Match copy(){
      Match copy = new Match();
      records.forEach( copy::addRecord );
      return copy;
   }//End Method
   
}//End Class
