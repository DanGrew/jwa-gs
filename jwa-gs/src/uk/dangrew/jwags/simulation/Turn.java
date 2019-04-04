package uk.dangrew.jwags.simulation;

import java.util.function.Function;

import javafx.util.Pair;
import uk.dangrew.jwags.actions.logic.DinosaurAction;
import uk.dangrew.jwags.actions.snapshot.DinosaurActionSnapshot;
import uk.dangrew.jwags.model.BattleSnapshot;
import uk.dangrew.jwags.model.BattlingDinosaur;

public class Turn {

   private BattleSnapshot turnStart;
   
   private DinosaurActionSnapshot fasterAction;
   private BattleSnapshot afterFasterAction;
   private BattleSnapshot fasterActionResult;
   
   private DinosaurActionSnapshot slowerAction;
   private BattleSnapshot afterSlowerAction;
   private BattleSnapshot slowerActionResult;
   
   private BattleSnapshot endTurnEffects;
   private BattleSnapshot endTurnResult;
   
   public void beginTurn( BattlingDinosaur faster, BattlingDinosaur slower ) {
      this.turnStart = new BattleSnapshot( faster.snapshot(), slower.snapshot() );
   }//End Method
   
   public void fasterActionExecuted( DinosaurAction action, BattlingDinosaur faster, BattlingDinosaur slower ){
      this.fasterAction = action.snapshot();
      this.afterFasterAction = new BattleSnapshot( faster.snapshot(), slower.snapshot() );
   }//End Method
   
   public void victoryAfterFasterAction( Pair< BattlingDinosaur, BattlingDinosaur > victoryPair ){
      this.fasterActionResult = new BattleSnapshot( victoryPair.getKey().snapshot(), victoryPair.getValue().snapshot() );
   }//End Method
   
   public void slowerActionExecuted( DinosaurAction action, BattlingDinosaur faster, BattlingDinosaur slower ){
      this.slowerAction = action.snapshot();
      this.slowerAction = action.snapshot();
      this.afterSlowerAction = new BattleSnapshot( faster.snapshot(), slower.snapshot() );
   }//End Method
   
   public void victoryAfterSlowerAction( Pair< BattlingDinosaur, BattlingDinosaur > victoryPair ){
      this.slowerActionResult = new BattleSnapshot( victoryPair.getKey().snapshot(), victoryPair.getValue().snapshot() );
   }//End Method
   
   public void endTurnEffectsExecuted( BattlingDinosaur faster, BattlingDinosaur slower ){
      this.endTurnEffects = new BattleSnapshot( faster.snapshot(), slower.snapshot() );
   }//End Method
   
   public void victoryAfterEndTurnEffects( Pair< BattlingDinosaur, BattlingDinosaur > victoryPair ){
      this.endTurnResult = new BattleSnapshot( victoryPair.getKey().snapshot(), victoryPair.getValue().snapshot() );
   }//End Method
   
   public boolean hasGameConcluded(){
      return fasterActionResult != null || slowerActionResult != null || endTurnResult != null;
   }//End Method
   
   public String displayableDescription(){
      return new StringBuilder()
         .append( "Faster: " ).append( elementToString( turnStart, BattleSnapshot::faster ) ).append( "\n" )
         .append( "Slower: " ).append( elementToString( turnStart, BattleSnapshot::slower ) ).append( "\n" )
         .append( "Faster Action: " ).append( elementToString( fasterAction, Function.identity() ) ).append( "\n" )
         .append( "Faster After Faster Action: " ).append( elementToString( afterFasterAction, BattleSnapshot::faster ) ).append( "\n" )
         .append( "Slower After Faster Action: " ).append( elementToString( afterFasterAction, BattleSnapshot::slower ) ).append( "\n" )
         .append( "Winner: " ).append( elementToString( fasterActionResult, BattleSnapshot::faster ) ).append( "\n" )
         .append( "Loser: " ).append( elementToString( fasterActionResult, BattleSnapshot::slower ) ).append( "\n" )
         .append( "Slower Action: " ).append( elementToString( slowerAction, Function.identity() ) ).append( "\n" )
         .append( "Faster After Slower Action: " ).append( elementToString( afterSlowerAction, BattleSnapshot::faster ) ).append( "\n" )
         .append( "Slower After Slower Action: " ).append( elementToString( afterSlowerAction, BattleSnapshot::slower ) ).append( "\n" )
         .append( "Winner: " ).append( elementToString( slowerActionResult, BattleSnapshot::faster ) ).append( "\n" )
         .append( "Loser: " ).append( elementToString( slowerActionResult, BattleSnapshot::slower ) ).append( "\n" )
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
