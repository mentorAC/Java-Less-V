import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

       Vector vector = new Vector();
       vector.add(3);
        vector.add(5);
        vector.add(8);
        vector.Print();

    }
}
 class Vector{
     private int data[];
     private int size = 0;
     public void add (int value){
         if(data == null){
             data= new int[1];
             data[0] = value;
             size ++;
             return;
         }
         int datanew[] = new int[size+1];
         for(int i=0; i<size; i++){
             datanew[i]=data[i];
         }
         datanew[size] = value;
         data= datanew;
         size++;
     }
     public void addFront(int value){
         if(data == null){
             data= new int[1];
             data[0] = value;
             size ++;
             return;
         }
        int newmas[] = new int[size+1];
         for(int i=0; i<size; i++) {
             newmas[i + 1] = data[i];
         }
         newmas[0]= value;
         data = newmas;
         size++;

     }
     public void Print(){
         for(int i=0; i<size; i++){
             System.out.print(data[i] + " ");
         }
     }

}