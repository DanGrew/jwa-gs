package uk.dangrew.jwags.simulation;

import java.util.ArrayList;
import java.util.List;

public class Simulation {

   private final List< SimulationStage > stages;
   private SimulationResult result;
   
   public Simulation() {
      this.stages = new ArrayList<>();
   }//End Constructor
   
   public void addStage( SimulationStage stage ) {
      this.stages.add( stage );
   }//End Method
   
   public List< SimulationStage > stages(){
      return stages;
   }//End Method
   
   public Simulation copy(){
      Simulation copy = new Simulation();
      stages.forEach( copy::addStage );
      return copy;
   }//End Method
   
   public void setResult( SimulationResult result ) {
      this.result = result;
   }//End Method
   
   public SimulationResult result(){
      return result;
   }//End Method
   
}//End Class
