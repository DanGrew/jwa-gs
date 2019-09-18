package uk.dangrew.jwags.simulation.simulator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import uk.dangrew.jwags.simulation.actions.logic.DinosaurAction;
import uk.dangrew.jwags.simulation.model.BattlingDinosaur;
import uk.dangrew.jwags.simulation.model.DinosaurActionPair;
import uk.dangrew.jwags.simulation.model.DinosaurActions;

public class MatchGenerator {

   private final Simulator simulator;
   private SimulatedMatches matches;
   
   public MatchGenerator() {
      this.simulator = new Simulator();
   }//End Constructor
   
   public SimulatedMatches generate( BattlingDinosaur first, BattlingDinosaur second  ){
      matches = new SimulatedMatches();
      computeMatchCombinations( new Match(), first, second );
      matches.clean();
      return matches;
   }//End Method
   
   private void computeMatchCombinations( Match match, BattlingDinosaur first, BattlingDinosaur second ){
      matches.remove( match );
      
      for ( TurnActions actions : moveCombinations( first, second ) ){
         
         Match branch = match.copy();
         BattlingDinosaur branchFirst = first.copy();
         BattlingDinosaur branchSecond = second.copy();
         
         matches.add( branch );
         
         simulator.simulate( 
                  new DinosaurActionPair( branchFirst, actions.actionForDinosaur( branchFirst ) ),
                  new DinosaurActionPair( branchSecond, actions.actionForDinosaur( branchSecond ) ),
                  branch 
         );
         
         if ( branch.hasConcluded() ) {
            continue;
         } else {
            computeMatchCombinations( branch, branchFirst, branchSecond );
         }
      }
   }//End Method
   
   private List< TurnActions > moveCombinations( BattlingDinosaur first, BattlingDinosaur second ){
      List< TurnActions > combinations = new ArrayList<>();
      for ( DinosaurAction firstAction : first.actions() ) {
         for ( DinosaurAction secondAction : second.actions() ) {
            TurnActions turnActions = new TurnActions( 
                     first.type(), firstAction.type(), second.type(), secondAction.type() 
            );
            combinations.add( turnActions );
         }
      }
      return combinations;
   }//End Method
   
}//End Class
