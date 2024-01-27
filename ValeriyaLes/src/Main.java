import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//        System.out.println("Hello world!");
//        System.out.println("Hello world!");
//        System.out.println("Hello world!");
//        System.out.println("Hello world!");
//
//        System.out.print("hello");
//        System.out.print("hello");
//        System.out.print("hello");
//        System.out.print("hello");
//        System.out.print("hello");

        Scanner cs = new Scanner(System.in);
        //cs.nextInt();

        //int           4byte
        //float         4byte
        //double (!)    8byte
        //char          2byte
        //boolean       1byte
        //String        2byte
        //(1,2,3,4) u (3 4 5 6) =>
        //String str1 = "abc";
        //String str2 = "abcdagjhsgdjhGASDjhasjhAGS asdjaSHGDJHASGDJHGJDHGASJHDGASDJHGASDHGFJA";

//        int a = cs.nextInt();
//        System.out.println("Your number: " + a);
        //
        int a = cs. nextInt();
        System.out.println(" square of the number: " + a*a);
        System.out.println(" cube of the number: " + a*a*a);
        System.out.println(a*a*a*a);

    }
}