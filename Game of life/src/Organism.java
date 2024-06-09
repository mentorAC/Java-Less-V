public class Organism {
   private boolean isLife = true;
   public void kill(){
      isLife = false;
   }
   public void resurrect(){
      isLife = true;

   }
   public void draw(){
      if (isLife==true){
         System.out.print("0");
      }else{
         System.out.print(" ");
      }
   }
}
