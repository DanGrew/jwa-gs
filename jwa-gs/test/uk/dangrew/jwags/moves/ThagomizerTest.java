package uk.dangrew.jwags.moves;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static uk.dangrew.jwags.model.DinosaurType.Stegosaurus;
import static uk.dangrew.jwags.model.DinosaurType.Velociraptor;

import org.junit.Before;
import org.junit.Test;
import org.mockito.MockitoAnnotations;

import uk.dangrew.jwags.model.Dinosaur;
import uk.dangrew.jwags.model.DinosaurType;
import uk.dangrew.kode.launch.TestApplication;

public class ThagomizerTest {

   private Thagomizer systemUnderTest;

   @Before public void initialiseSystemUnderTest() {
      TestApplication.startPlatform();
      MockitoAnnotations.initMocks( this );
      systemUnderTest = new Thagomizer();
   }//End Method

   @Test public void shouldApplyDamage() {
      Dinosaur raptor = Velociraptor.create();
      Dinosaur stego = Stegosaurus.create();
      
      assertThat( raptor.health().get(), is( Velociraptor.health() ) );
      assertThat( stego.health().get(), is( Stegosaurus.health() ) );
      
      systemUnderTest.execute( stego, raptor );
      
      assertThat( raptor.health().get().doubleValue(), is( Velociraptor.health() - Stegosaurus.damage() * 1.5 ) );
      assertThat( stego.health().get(), is( Stegosaurus.health() ) );
   }//End Method
   
   @Test public void shouldAbsorbDamageInArmor() {
      Dinosaur raptor = DinosaurType.Velociraptor.create();
      Dinosaur stego = DinosaurType.Stegosaurus.create();
      
      assertThat( raptor.health().get(), is( DinosaurType.Velociraptor.health() ) );
      assertThat( stego.health().get(), is( DinosaurType.Stegosaurus.health() ) );
      
      systemUnderTest.execute( raptor, stego );
      
      //Stegosaurus.health() - ( 1.0 - Stegosaurus.armor()/100.0 ) * Velociraptor.damage()
      //4500 - ( 1 - 0.2 ) *  (1320 * 1.5) = 4500 - 1584 = 2916
      assertThat( raptor.health().get(), is( Velociraptor.health() ) );
      assertThat( stego.health().get(), is( 2916 ) );
   }//End Method

}//End Class
