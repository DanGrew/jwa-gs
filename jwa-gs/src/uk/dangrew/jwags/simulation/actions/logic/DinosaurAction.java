package uk.dangrew.jwags.simulation.actions.logic;

import uk.dangrew.jwags.simulation.actions.snapshot.DinosaurActionSnapshot;
import uk.dangrew.jwags.simulation.model.BattlingDinosaur;
import uk.dangrew.jwags.simulation.model.DinosaurActionType;

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

