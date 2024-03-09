import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int[] arr = new int[size];
        int count = 0;


        System.out.println("size ");
        for(int i = 0; i< arr.length; i++){
            arr[i] = sc.nextInt();

        }
        for(int i = 0; i< arr.length-1; i++){
            System.out.print(arr[i]);
            if( arr[i]!= arr[i+1]){
                System.out.println ( );

            }
        }
//            if( arr[i]>arr[i-1]&& arr[i]> arr[i+1]){
//                System.out.println(arr[i]);
//            }
//        }
//            for( int j = 0; j < arr.length; j++ ){
//                if( i!=j && arr[i] == arr[j]){
//                    count ++;
//                }
//            }
//            if( count == 0){
//                System.out.println(arr[i]);
//            }
//            count=0;
//        }

//            for( int j = i+1; j< arr.length; j++){
//                if(arr[i] == arr[j]) {
//                    count++;
//                }
//            }
//
//        }

//        for(int i = 0; i< arr.length - 1; i++){
//            if ( arr[i] != arr[i+ 1]){
//                count ++;
//            }
//        }
//        System.out.println( " Count: " + (count+1));
//        int min = 999999999;
//        for(int i = 0; i< arr.length; i++) {
//            if (arr[i] < min && arr[i] > 0) {
//                min = arr[i];
//            }
//        }
//            System.out.println(" min" + min);

//        for(int i = 0; i< arr.length -1; i++){
//            if(arr[i]>0 && arr[i+1] >0 || arr[i] < 0 && arr[i+1] < 0){
//                System.out.println(arr[i]+ " " + arr[ i+1]);
//                break;
//            }
//        }

//        for(int i = 0; i < 10; i++){
//            if(i ==6){
//                //break;
//                continue;
//            }
//            System.out.println(i);
//        }


    }
}