package uk.dangrew.jwags.model;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;

public class Dinosaur {
   
   private final DinosaurType type;
   private final ObjectProperty< Integer > health;
   private final ObjectProperty< Integer > damage;
   
   public Dinosaur( 
            DinosaurType type
   ) {
      this.type = type;
      this.health = new SimpleObjectProperty<>( type.health() );
      this.damage = new SimpleObjectProperty<>( type.damage() );
   }//End Constructor
   
   public DinosaurType type(){
      return type;
   }//End Method
   
   public ObjectProperty< Integer > health(){
      return health;
   }//End Method
   
   public ObjectProperty< Integer > damage(){
      return damage;
   }//End Method
   
   public Dinosaur copy(){
      Dinosaur copy = type.create();
      copy.health.set( health.get() );
      copy.damage.set( damage.get() );
      return copy;
   }//End Method
   
}//End Class
