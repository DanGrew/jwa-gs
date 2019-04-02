package uk.dangrew.jwags.simulation;

import uk.dangrew.jwags.model.Dinosaur;

public class SimulationResult {

   private final Dinosaur winner;
   private final Dinosaur loser;
   
   public SimulationResult( Dinosaur winner, Dinosaur loser ) {
      this.winner = winner;
      this.loser = loser;
   }//End Constructor
   
   public Dinosaur winner(){
      return winner;
   }//End Method
   
   public Dinosaur loser(){
      return loser;
   }//End Method
}//End Class
