package uk.dangrew.jwags.simulation;

import uk.dangrew.jwags.model.Dinosaur;
import uk.dangrew.jwags.moves.DinosaurAction;

public class SimulationStage {
   
   private final Dinosaur attackingDinosaurAfterMove;
   private final Dinosaur defendingDinosaurAfterMove;
   private final DinosaurAction move;
   
   public SimulationStage( 
            DinosaurAction move, Dinosaur attacking, Dinosaur defending
   ) {
      this.move = move;
      this.attackingDinosaurAfterMove = attacking;
      this.defendingDinosaurAfterMove = defending;
   }//End Constructor
   
   public DinosaurAction move(){
      return move;
   }//End Method
   
   public Dinosaur attacking(){
      return attackingDinosaurAfterMove;
   }//End Method
   
   public Dinosaur defending(){
      return defendingDinosaurAfterMove;
   }//End Method

}//End Class
