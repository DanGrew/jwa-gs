package uk.dangrew.jwags.actions.logic;

import uk.dangrew.jwags.actions.snapshot.DinosaurActionSnapshot;
import uk.dangrew.jwags.model.BattlingDinosaur;
import uk.dangrew.jwags.model.DinosaurActionType;

public interface DinosaurAction {

   public void turnComplete();
   
   public boolean isAvailable();
   
   public int currentCooldown();
   
   public int currentDelay();
   
   public String name();
   
   public DinosaurActionType type();
   
   public DinosaurActionSnapshot snapshot();
   
   public DinosaurAction copy();
   
   public void execute( BattlingDinosaur attacking, BattlingDinosaur defending );
   
}//End Interface

