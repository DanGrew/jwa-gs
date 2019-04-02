package uk.dangrew.jwags.model;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static uk.dangrew.jwags.model.DinosaurType.Stegosaurus;

import org.junit.Before;
import org.junit.Test;
import org.mockito.MockitoAnnotations;

import uk.dangrew.kode.launch.TestApplication;
import uk.dangrew.kode.model.ModelVerifier;

public class DinosaurTest {

   private Dinosaur systemUnderTest;

   @Before public void initialiseSystemUnderTest() {
      TestApplication.startPlatform();
      MockitoAnnotations.initMocks( this );
      systemUnderTest = new Dinosaur(
               DinosaurType.Stegosaurus
      );
   }//End Method

   @Test public void shouldProvideProperties() {
      new ModelVerifier<>( systemUnderTest )
         .shouldProvideObject( Dinosaur::type )
         .shouldProvideProperty( Dinosaur::health, Stegosaurus.health(), 1221 )
         .shouldProvideProperty( Dinosaur::damage, Stegosaurus.damage(), 2093 );
   }//End Method
   
   @Test public void shouldCopyDinosaur(){
      systemUnderTest.health().set( 25 );
      systemUnderTest.damage().set( 26 );
      Dinosaur copy = systemUnderTest.copy();
      
      assertThat( copy.health().get(), is( 25 ) );
      assertThat( copy.damage().get(), is( 26 ) );
   }//End Method

}//End Class
