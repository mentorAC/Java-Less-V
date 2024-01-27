import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //int       ->4
        //char      ->2
        //boolean   ->1
        //flout     ->4
        //double    ->8

        //+-*/
        //%
        Scanner in = new Scanner(System.in);
        //int a = in.nextInt();
        //234
        //2 3 4
        //234 / 100 = 2

        //234 % 10 = 4
        //int a1 = a / 100;
        //int a2 = a / 10 % 10;
        //int a3 = a % 10;

        //System.out.println(a1+" "+a2+" "+a3);

//        System.out.println(Math.sqrt(5)); -> корень
//        System.out.println(Math.abs(-5)); -> модуль
//        System.out.println(Math.abs(5));  -> модуль
//        System.out.println(Math.pow(3,2));-> степень
//        System.out.println(Math.max(2,5));
//        System.out.println(Math.min(2,5));
        //ctan -> 1/tan() -> cos(90)/sin(90)


        //pi*r^2

        //int a = in.nextInt();
        //System.out.println(Math.PI * Math.pow (a,2));

//        int a = in.nextInt();
//        int b = in.nextInt();
//        System.out.println(Math.sqrt(Math.pow(a,2) + Math.pow(b,2)));

//        boolean q = true;//false
        //< > <= >= != == !
//        q = 4 > 9;
//        System.out.println(q);

//        if(4 < 9){
//            System.out.println("Yes!");
//        }
//        else{
//            System.out.println("No(((");
//        }


//        int a = in.nextInt();
//        if( a%2==0) {
//            System.out.println("Yes!");
//        }
//        else{
//
//            System.out.println("No(((");
//        }

        int a = in.nextInt();
        int b = in.nextInt();
        int c = in.nextInt();

        System.out.println(Math.max(Math.max(a,b),c));

//        if(a>b){
//            System.out.println( a );
//        }else {
//            System.out.println(b);
//        }



    }
}