package uk.dangrew.jwags.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import uk.dangrew.jwags.actions.logic.DinosaurAction;
import uk.dangrew.jwags.effects.logic.Effect;

public class BattlingDinosaur implements Dinosaur {
   
   private final DinosaurType type;
   private final ObjectProperty< Integer > health;
   private final List< Effect > effects;
   
   public BattlingDinosaur( 
            DinosaurType type
   ) {
      this.type = type;
      this.health = new SimpleObjectProperty<>( type.health() );
      this.effects = new ArrayList<>();
   }//End Constructor
   
   @Override public String name(){
      return type.name();
   }//End Method
   
   @Override public int health(){
      return health.get();
   }//End Method
   
   public void setHealth( int health ){
      this.health.set( health );
   }//End Method
   
   @Override public int speed(){
      int currentSpeed = type.speed();
      for ( Effect effect : effects ) {
         currentSpeed = effect.modifySpeed( currentSpeed );
      }
      return currentSpeed;
   }//End Method
   
   @Override public int damage(){
      int currentDamage = type.damage();
      for ( Effect effect : effects ) {
         currentDamage = effect.modifyDamage( currentDamage );
      }
      return currentDamage;
   }//End Method
   
   @Override public int armor(){
      return type.armor();
   }//End Method
   
   @Override public int critical(){
      return type.critical();
   }//End Method
   
   public List< DinosaurAction > actions(){
      return type.actions().stream().map( DinosaurActions::action ).collect( Collectors.toList() );
   }//End Method
   
   public void apply( Effect effect ) {
      this.effects.add( effect );
   }//End Method
   
   public List< Effect > effects(){
      return effects;
   }//End Method
   
   public void turnComplete(){
      this.effects.forEach( Effect::turnComplete );
      this.effects.removeIf( Effect::hasExpired );
      this.type.actions().stream().map( DinosaurActions::action ).forEach( DinosaurAction::turnComplete );
   }//End Method
   
   public DinosaurSnapshot snapshot() {
      return new DinosaurSnapshot( this, type );
   }//End Method

   @Override public String displayableDescription() {
      StringBuilder builder = new StringBuilder( name() );
      builder.append( " (" );
      builder.append( "h:" ).append( health() ).append( ", " );
      builder.append( "d:" ).append( damage() ).append( ", " );
      builder.append( "s:" ).append( speed() ).append( ")" );
      return builder.toString();
   }//End Method
   
   @Override public String toString() {
      return displayableDescription();
   }//End Method
   
}//End Class
