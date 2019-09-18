package uk.dangrew.jwags.simulation.simulator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SimulatedMatches {

   private final List< Match > matches;
   
   public SimulatedMatches() {
      this.matches = new ArrayList<>();
   }//End Constructor
   
   public void add( Match match ) {
      this.matches.add( match );
   }//End Method
   
   public void remove( Match match ) {
      this.matches.remove( match );
   }//End Method
   
   public void clean(){
      this.matches.removeIf( Match::isInvalidActionSet );
   }//End Method
   
   public List< Match > matches(){
      return Collections.unmodifiableList( matches );
   }//End Method
   
}//End Class
