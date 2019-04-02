package uk.dangrew.jwags.model;

import java.util.Arrays;
import java.util.List;

import uk.dangrew.jwags.moves.DinosaurAction;
import uk.dangrew.jwags.moves.Pounce;
import uk.dangrew.jwags.moves.Strike;
import uk.dangrew.jwags.moves.SuperiorityStrike;
import uk.dangrew.jwags.moves.Thagomizer;

public enum DinosaurType {
   
   Stegosaurus( 117, 4500, 1200, 5, 20, new SuperiorityStrike(), new Thagomizer() ),
   Velociraptor( 132, 1950, 1320, 5, 0, new Strike(), new Pounce() );

   private final int speed;
   private final int health;
   private final int damage;
   private final int critical;
   private final int armor;
   private final List< DinosaurAction > moves;
   
   private DinosaurType( 
            int speed,
            int health,
            int damage,
            int critical, 
            int armor,
            DinosaurAction... moves
   ) {
      this.speed = speed;
      this.health = health;
      this.damage = damage;
      this.critical = critical;
      this.armor = armor;
      this.moves = Arrays.asList( moves );
   }//End Constructor
   
   public int speed(){
      return speed;
   }//End Method
   
   public int health(){
      return health;
   }//End Method
   
   public int damage(){
      return damage;
   }//End Method
   
   public int critical(){
      return critical;
   }//End Method
   
   public int armor(){
      return armor;
   }//End Method
   
   public List< DinosaurAction > moves(){
      return moves;
   }//End Method
   
   public Dinosaur create(){
      return new Dinosaur( this );
   }//End Method
   
}//End Class
