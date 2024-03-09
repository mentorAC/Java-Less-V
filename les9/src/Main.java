import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner( System.in);
        int size = sc.nextInt();
        int[] arr = new int[size];
        int count = 0;
        int min = 100;
        int mini = 0;
        int max = 0;
        int maxi =0;
        Random  random = new Random();
        for( int i = 0; i< arr.length; i++){
            arr[i] = random.nextInt(100);
        }
        for( int i = 0; i< arr.length;i++) {

            System.out.print( arr[i] +" ");
        }
        for( int i = 0; i< arr.length;i++) {
            if (arr[i] < min && arr[i] > 0) {
                min = arr[i];
                mini=i;
            }
        }
        for( int i = 0; i< arr.length;i++){
        if( arr[i] > max && arr[i] > 0){
            max = arr[i];
            maxi = i;
        }
        }
        int g = arr[maxi];
        arr[maxi] = arr[mini];
        arr[mini] = g;

        System.out.println( );


//            int sum = 0;
//        for( int i = 0; i< arr.length;i++) {
//            sum += arr[i];
//        }
//        int c = sum/size;
//        arr[4] =c;
        for( int i = 0; i< arr.length;i++) {

            System.out.print( arr[i] +" ");
        }
//        int count = 0;
//        int[] arr = new int[size];
//        for( int i = 0; i< arr.length; i++){
//            arr[i ] = sc.nextInt();
//        }
//        for( int i = 0; i< arr.length; i++) {
//            if (arr[i] == 1) {
//                count++;
//            }
//        }
//        int b = 365 - count;
//        if( count > b) {
//            System.out.println("Yes ");
//        }else{
//                System.out.println("No ");
//
//            }
//








    }
}