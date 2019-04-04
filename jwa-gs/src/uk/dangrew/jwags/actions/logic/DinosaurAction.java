package uk.dangrew.jwags.actions.logic;

import uk.dangrew.jwags.actions.snapshot.DinosaurActionSnapshot;
import uk.dangrew.jwags.model.BattlingDinosaur;

public interface DinosaurAction {

   public void turnComplete();
   
   public boolean isAvailable();
   
   public int currentCooldown();
   
   public int currentDelay();
   
   public String name();
   
   public DinosaurActionSnapshot snapshot();
   
   public void execute( BattlingDinosaur attacking, BattlingDinosaur defending );
   
}//End Interface

