import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner cs = new Scanner(System.in);


        /*for(int i = 3;i < 5;i++){
           System.out.println(i+") Hello");*/
       /* System.out.println(" Enter number:");
       int value = cs.nextInt();
        for( int a=0; a<= value; a++  ){
            System.out.println(" a:" +a);

        }*/
       /* int value = cs.nextInt();
        for( int a=0; a<= value; a++  ){
            System.out.print(" " +a);}
        System.out.println();
        for( int a=value; a>=0; a--  ){
            System.out.print(" " +a);}
        System.out.println();

        for( int a=0; a<= value/2; a++  ){
            System.out.print(" " +a);}
        System.out.println();
        for( int a= value/2; a<= value; a++  ){
            System.out.print(" " +a);}
        System.out.println();
        for( int a= value; a>= value/2; a--  ){
            System.out.print(" " +a);}*/

       /* for( int a=0; a<=100 ; a+=2  ){
            System.out.print(" " +a);}*/
//        System.out.println( " Enter first number :");
//        int a = cs.nextInt();
//        System.out.println( " Enter second number :");
//        int b = cs.nextInt();
//        if(a<b) {
//            for (int i = a; i <= b; i++) {
//                System.out.println(" " + i);
//            }
//        }
//        else {
//            for (int i = a; i >= b; i--) {
//                System.out.println(" " + i);
//
//            }
//        }


        //while ()
//        int i = 0;
//        while(i <= 10){
//            System.out.println(i);
//            i++;
//        }
        int a  = 3;

        System.out.println("Start While");
        while(a >= 4 && a <= 8){
            System.out.print(a+" ");
            a++;
        }
        System.out.println("End While");
        System.out.println("Start DO While");

        do {
            System.out.print(a+" ");
            a++;
        }while(a >= 4 && a <= 8);
        System.out.println("\nEnd DO While");

    }
}