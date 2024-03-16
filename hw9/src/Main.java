import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int[] arr = new int[size];
        int sum = 0;
        Random random = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(15);
        }
        for (int i = 0; i < arr.length; i++) {

            System.out.print(arr[i] + " ");
        }
        //sum = arr[0] + arr[1] + arr[2] + arr[3] +arr[4];

        for (int i = 0; i < arr.length; i++) {
           sum += arr[i] ;

        }
       int average = sum/ arr.length;
        for (int i = 0; i < arr.length; i++) {
            arr[i]-= average;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }




    }

}



//
//import java.util.Scanner;
//
//public class Main {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//
//        int[] arr = new int[12];
//        System.out.println(" Enter numbers :");
//        for (int i = 0; i < arr.length; i++) {
//            System.out.println();
//            arr[i] = sc.nextInt();
//        }
//        int min = arr[0];
//        int max = arr[0];
//        for (int i = 1; i < arr.length; i++) {
//            if (arr[i] < min) {
//                min = arr[i];
//            }
//            if (arr[i] > max) {
//                max = arr[i];
//            }
//        }
//        System.out.println(" Minimum " + min);
//        System.out.println(" Maximum " + max);
//
//        sc.close();
//    }
//}
//
//
//
//import java.util.Scanner;
//
//public class Main {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//
//        int[] arr = new int[15];
//        System.out.println(" Enter numbers :");
//        for (int i = 0; i < arr.length; i++) {
//            System.out.println();
//            arr[i] = sc.nextInt();
//        }
//        int p = 0;
//        int n = 0;
//        int z = 0;
//        for (int i = 0; i < arr.length; i++) {
//            if (arr[i] > 0) {
//                p++;
//            } else if (arr[i] < 0) {
//                n++;
//            } else {
//                z++;
//            }
//        }
//        System.out.println(" Positive: " + p);
//        System.out.println(" Negative: " + n);
//        System.out.println(" Zero: " + z);
//
//    }
//}

