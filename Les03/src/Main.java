import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //&& ||

        //&&
        //true && true => true
        //true && false => false
        //false && true => false
        //false && false => false

        // ||
        //true || true => true
        //true || false => true
        //false || true => true
        //false || false => false

//        Scanner cs= new Scanner(System.in);
//        System.out.print("enter number: ");
//        int a = cs.nextInt();
//        if(a<10 && a>0){
//            System.out.println(" Yes");
//        }
//        else{
//            System.out.println(" no");
//
//        }

//        Scanner cs= new Scanner(System.in);
//        System.out.print("enter three number: ");
//
//        int a = cs.nextInt();
//        int b = cs.nextInt();
//        int c = cs.nextInt();
//        if( a>b && a>c){
//            System.out.println(" result" + a);
//        }
//        else if(b>c&& b>a){
//            System.out.println(" result" + b);
//        }
//        else if(c>b && c>a){
//            System.out.println(" result" + c);
//        }
//        System.out.println("result : " + Math.max(Math.max(a,b),c));

//        Scanner cs= new Scanner(System.in);
//        System.out.print("enter three number: ");
//
//        int a = cs.nextInt();
//        int b = cs.nextInt();
//        int c = cs.nextInt();
//        if( a+b> c && a+c>b && c+b>a) {
//            System.out.println(" Yes");
//        }
//        else {
//            System.out.println(" no" );
//        }

//        Scanner cs = new Scanner(System.in);
//        System.out.print("enter three number: ");
//
//        int a = cs.nextInt();
//        int b = cs.nextInt();
//        int c = cs.nextInt();
//        if (a == b && a == c) {
//            System.out.println(" 3 ");
//        } else if (a == b || b == c || a == c) {
//            System.out.println(" 2 ");
//        } else {
//            System.out.println(" 0 ");
//        }


        int a = 4;
        int b  = 7;


        if(a < -10){
            System.out.println("First");
        }
        else if(b< -10){
            System.out.println("second");
        }
        else{
            System.out.println("very very bad(((");
        }




    }
}