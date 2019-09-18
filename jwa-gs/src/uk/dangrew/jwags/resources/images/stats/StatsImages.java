package uk.dangrew.jwags.resources.images.stats;

import javafx.scene.image.Image;

public class StatsImages {

   private static final Image SPEED = new Image( StatsImages.class.getResourceAsStream( "speed.png" ) );
   private static final Image DAMAGE = new Image( StatsImages.class.getResourceAsStream( "damage.png" ) );
   private static final Image HEALTH = new Image( StatsImages.class.getResourceAsStream( "health.png" ) );
   private static final Image CRITICAL = new Image( StatsImages.class.getResourceAsStream( "critical.png" ) );
   private static final Image ARMOR = new Image( StatsImages.class.getResourceAsStream( "armor.png" ) );
   
   public Image speed(){
      return SPEED;
   }//End Method
   
   public Image damage(){
      return DAMAGE;
   }//End Method
   
   public Image health(){
      return HEALTH;
   }//End Method
   
   public Image critical(){
      return CRITICAL;
   }//End Method
   
   public Image armor(){
      return ARMOR;
   }//End Method
   
}//End Class
