package uk.dangrew.jwags.simulation.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import uk.dangrew.jwags.simulation.actions.logic.DinosaurAction;
import uk.dangrew.jwags.simulation.effects.calculations.BattleStatistics;
import uk.dangrew.jwags.simulation.effects.logic.Effect;

public class BattlingDinosaur implements Dinosaur {
   
   private final BattleStatistics statistics;
   private final DinosaurType type;
   private final ObjectProperty< Integer > health;
   private final List< DinosaurAction > actions;
   private final List< Effect > attackingEffects;
   private final List< Effect > defendingEffects;
   
   public BattlingDinosaur( 
            DinosaurType type
   ) {
      this.statistics = new BattleStatistics();
      this.type = type;
      this.health = new SimpleObjectProperty<>( type.health() );
      this.attackingEffects = new ArrayList<>();
      this.defendingEffects = new ArrayList<>();
      this.actions = type.actions().stream()
               .map( DinosaurActions::action )
               .collect( Collectors.toList() );
   }//End Constructor
   
   @Override public String name(){
      return type.name();
   }//End Method
   
   public DinosaurType type(){
      return type;
   }//End Method
   
   @Override public int health(){
      return health.get();
   }//End Method
   
   public void setHealth( int health ){
      this.health.set( health );
   }//End Method
   
   @Override public int speed(){
      return statistics.speedOf( this );
   }//End Method
   
   @Override public int damage(){
      return statistics.damageOf( this );
   }//End Method
   
   @Override public int armor(){
      return type.armor();
   }//End Method
   
   @Override public int critical(){
      return type.critical();
   }//End Method
   
   public List< DinosaurAction > actions(){
      return actions;
   }//End Method
   
   public List< Effect > attackingEffects(){
      return attackingEffects;
   }//End Method
   
   public List< Effect > defendingEffects(){
      return defendingEffects;
   }//End Method
   
   public void attacked(){
      this.attackingEffects.forEach( Effect::turnComplete );
      this.attackingEffects.removeIf( Effect::hasExpired );
      this.actions.forEach( DinosaurAction::turnComplete );
   }//End Method
   
   public void defended(){
      this.defendingEffects.forEach( Effect::turnComplete );
      this.defendingEffects.removeIf( Effect::hasExpired );      
   }//End Method
   
   public DinosaurSnapshot snapshot() {
      return new DinosaurSnapshot( this, type );
   }//End Method
   
   public BattlingDinosaur copy() {
      BattlingDinosaur copy = new BattlingDinosaur( type );
      copy.health.set( health() );
      copy.actions.clear();
      actions.forEach( a -> copy.actions.add( a.copy() ) );
      attackingEffects.forEach( e -> copy.attackingEffects.add( e.copy() ) );
      defendingEffects.forEach( e -> copy.defendingEffects.add( e.copy() ) );
      return copy;
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
