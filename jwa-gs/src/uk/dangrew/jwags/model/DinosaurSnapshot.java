package uk.dangrew.jwags.model;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

import uk.dangrew.jwags.actions.logic.DinosaurAction;
import uk.dangrew.jwags.actions.snapshot.DinosaurActionSnapshot;
import uk.dangrew.jwags.effects.logic.Effect;
import uk.dangrew.jwags.effects.snapshot.EffectSnapshot;

public class DinosaurSnapshot implements Dinosaur {
   
   private final DinosaurType type;
   private final int speed;
   private final int health;
   private final int damage;
   private final int critical;
   private final int armor;
   private final List< DinosaurActionSnapshot > actions;
   private final List< EffectSnapshot > effectsApplied;
   
   public DinosaurSnapshot( 
            BattlingDinosaur dinosaur, DinosaurType type
   ) {
      this.type = type;
      this.speed = dinosaur.speed();
      this.health = dinosaur.health();
      this.damage = dinosaur.damage();
      this.critical = dinosaur.critical();
      this.armor = dinosaur.armor();
      
      this.actions = new ArrayList<>();
      dinosaur.actions().stream().map( DinosaurAction::snapshot ).forEach( actions::add );
      
      this.effectsApplied = new ArrayList<>();
      dinosaur.effects().stream().map( Effect::snapshot ).forEach( effectsApplied::add );
   }//End Constructor
   
   @Override public String name(){
      return type.name();
   }//End Method
   
   @Override public int health(){
      return health;
   }//End Method
   
   @Override public int speed(){
      return speed;
   }//End Method
   
   @Override public int damage(){
      return damage;
   }//End Method
   
   @Override public int armor(){
      return armor;
   }//End Method
   
   @Override public int critical(){
      return critical;
   }//End Method
   
   public List< DinosaurActionSnapshot > actions(){
      return actions;
   }//End Method
   
   public List< EffectSnapshot > effects() {
      return effectsApplied;
   }//End Method

   @Override public String displayableDescription() {
      StringJoiner actions = new StringJoiner( ", " );
      this.actions.forEach( action -> actions.add( action.toString() ) );
      
      StringJoiner effects = new StringJoiner( ", " );
      this.effectsApplied.forEach( effect -> effects.add( effect.toString() ) );
      
      return new StringBuilder( name() )
         .append( " (" )
         .append( "h:" ).append( health() ).append( ", " )
         .append( "d:" ).append( damage() ).append( ", " )
         .append( "s:" ).append( speed() )
         .append( ")" )
         .append( " ( " ).append( actions.toString() ).append( " )" )
         .append( " ( " ).append( effects.toString() ).append( " )" )
         .toString();
   }//End Method
   
   @Override public String toString() {
      return displayableDescription();
   }//End Method
   
}//End Class
