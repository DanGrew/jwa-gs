package uk.dangrew.jwags.moves;

import uk.dangrew.jwags.model.Dinosaur;

public interface DinosaurAction {

   public String name();
   
   public void execute( Dinosaur attacking, Dinosaur defending );
   
}//End Interface

