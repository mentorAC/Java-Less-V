import java.util.ArrayList;
import java.util.LinkedList;
//+add(item)
//+addFront(item)
//+print()
//+size() -> size
//+indexOf(item) -> index
//+insert(index, item)
//+remove(item)
//+removeAt(index)
//removeRange(item1, item2, ...)
//+contains(item) -> boolean
//get(index) -> item
//set(index, item)

public class Main {
    public static void main(String[] args) {
//        System.out.println("Hello world!");
//
       Vector vector = new Vector();
       vector.add(3);
        vector.add(5);
        vector.add(8);
        System.out.println(vector.indexOf(8));
        vector.insert(2, 3);
        vector.insert(0, 2);
       // vector.insert(8, 6);
        vector.Print();
        System.out.println();
        vector.removeAt(1);
        vector.Print();
        System.out.println();
        vector.remove(3);
        vector.Print();
        System.out.println();
        System.out.println(vector.contains(5));
        vector.removeRange(3, 5, 8);
        System.out.print(" removeRange: ");
        vector.Print();

        System.out.println("Element with i 0: " + vector.get(0));
        System.out.println("Element with i 2: " + vector.get(2));

        vector.set(0, 10);
        System.out.print(" set: ");
        vector.Print();




        //int[] arr = new int[5];
//        ArrayList<Integer> lst = new ArrayList<>();
//        lst.add(4);
//        lst.add(7);
//        lst.add(1);


    }
}
 class Vector {
     private int data[];
     private int size = 0;

     public void add(int value) {
         if (data == null) {
             data = new int[1];
             data[0] = value;
             size++;
             return;
         }
         int datanew[] = new int[size + 1];
         for (int i = 0; i < size; i++) {
             datanew[i] = data[i];
         }
         datanew[size] = value;
         data = datanew;
         size++;
     }

     public void addFront(int value) {
         if (data == null) {
             data = new int[1];
             data[0] = value;
             size++;
             return;
         }
         int newmas[] = new int[size + 1];
         for (int i = 0; i < size; i++) {
             newmas[i + 1] = data[i];
         }
         newmas[0] = value;
         data = newmas;
         size++;

     }

     public void Print() {
         for (int i = 0; i < size; i++) {
             System.out.print(data[i] + " ");
         }
     }

     public int size() {
         return size;

     }

     public int indexOf(int e) {
         for (int i = 0; i < size; i++) {
             if (e == data[i]) {
                 return i;
             }
         }
         return -1;

     }
     public void insert(int index, int e){
         if(index< 0|| index> size){
             return;
         }
         if(index ==0){
             addFront(e);
         }
        else if(size==index){
             add(e);
         }
         else{
             int [] newmas = new int[size+1];
             if (index < 0 || index > size()) {
                 System.out.println("Error");
                 return;
             }
             for (int i=0; i<size; i++){
                 if(i<index){
                     newmas[i]= data[i];
                 }else if(i>=index){
                     newmas[i+1] = data[i];
                 }
                 if(i==index){
                     newmas[i]=e;
                 }
             }
             data=newmas;
             size++;
         }

     }
     public void removeAt(int index){
         int [] newmas = new int [size-1];
         if(index<0|| index>size()){
             System.out.println("Error");
             return;
         }
         for(int i= 0;i<size;i++){
             if(i<index){
                 newmas[i]=data[i];
             }else if(i>index){
                 newmas[i-1]= data[i];
             }
         }
         data=newmas;
         size--;
     }
     public void remove(int e){
         removeAt(indexOf(e));

     }
     public boolean contains(int e){
         return indexOf(e)!=-1;
     }
     public void removeRange(int... items) {
         for (int i = 0; i < items.length; i++) {
             int item = items[i];
             while (contains(item)) {
                 remove(item);
             }
         }
     }
     public int get(int index) {
         if (index < 0 || index >= size) {
             System.out.println("Error");
             return -1;
         }
         return data[index];
     }
     public void set(int index, int item) {
         if (index < 0 || index >= size) {
             System.out.println("Error");
             return;
         }
         data[index] = item;
     }
 }