package uk.dangrew.jwags.model;

import static uk.dangrew.jwags.model.DinosaurActions.Stegosaurus_SuperiorityStrike;
import static uk.dangrew.jwags.model.DinosaurActions.Stegosaurus_Thagomizer;
import static uk.dangrew.jwags.model.DinosaurActions.Velociraptor_Pounce;
import static uk.dangrew.jwags.model.DinosaurActions.Velociraptor_Strike;

import java.util.Arrays;
import java.util.List;

public enum DinosaurType {
   
   Stegosaurus( 
            117, 4500, 1200, 5, 20, 
            Stegosaurus_SuperiorityStrike, 
            Stegosaurus_Thagomizer 
   ),
   Velociraptor( 
            132, 1950, 1320, 5, 0, 
            Velociraptor_Strike,
            Velociraptor_Pounce
   ),
   
   
   ArmoredDinosaur( 
            117, 4500, 1200, 5, 20, 
            Stegosaurus_SuperiorityStrike, 
            Stegosaurus_Thagomizer 
   ),
   BasicDinosaur( 
            132, 1950, 1320, 5, 0, 
            Velociraptor_Strike,
            Velociraptor_Pounce
   );

   private final int speed;
   private final int health;
   private final int damage;
   private final int critical;
   private final int armor;
   private final List< DinosaurActions > actions;
   
   private DinosaurType( 
            int speed,
            int health,
            int damage,
            int critical, 
            int armor,
            DinosaurActions... actions
   ) {
      this.speed = speed;
      this.health = health;
      this.damage = damage;
      this.critical = critical;
      this.armor = armor;
      this.actions = Arrays.asList( actions );
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
   
   public List< DinosaurActions > actions(){
      return actions;
   }//End Method
   
   public BattlingDinosaur create(){
      return new BattlingDinosaur( this );
   }//End Method
   
}//End Class
