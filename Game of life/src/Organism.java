public class Organism {
   private boolean isLife = false;
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

   public boolean isLife() {
      return isLife;
   }
}
