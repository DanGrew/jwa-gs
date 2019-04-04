package uk.dangrew.jwags.model;

public class BattleSnapshot {

   private final DinosaurSnapshot faster;
   private final DinosaurSnapshot slower;
   
   public BattleSnapshot( DinosaurSnapshot faster, DinosaurSnapshot slower ) {
      this.faster = faster;
      this.slower = slower;
   }//End Constructor
   
   public DinosaurSnapshot faster(){
      return faster;
   }//End Method
   
   public DinosaurSnapshot slower(){
      return slower;
   }//End Method
   
}//End Class