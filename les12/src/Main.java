import java.util.Random;
import java.util.Scanner;

public class Main {
    static int[] createArr(){
        Scanner sc = new Scanner( System.in);
        int size = sc.nextInt();
        int[] arr = new int [size];
        return arr;
    }
    static void fillArr(int [] arr ){
        Random random = new Random();
        for ( int i = 0; i< arr.length; i++){
            arr[i]= random.nextInt(10);
        }

    }
    static void printArr( int[] arr){
        for ( int i = 0; i< arr.length; i++){
            System.out.print(arr[i] + " ");
        }
    }
    static int sumArr( int[] arr){
        int result = 0;
        for ( int i = 0; i< arr.length; i++){
            result += arr[i];

        }
        return result;
    }
    static double avgArr( int [] arr){
       return sumArr(arr) / (double) arr.length;
    }
    static int maxFun ( int [] arr){
        int max = 0;
        for ( int i = 0; i< arr.length; i++){
            if ( arr[i] > max){
                max = arr[i];

            }
        }
        return max;
    }
    static int searchFun( int [] arr, int value){
        int s = 0;
        for ( int i = 0; i< arr.length; i++){
            if( arr[i] == value){
                return i;
            }
        }
        return -1;
    }
    static int[][] createMatrix(){
        Scanner sc = new Scanner( System.in);
        int size = sc.nextInt();
        int[][] matrix= new int [size][size];
        return matrix;
    }
    static void fillArr(int [][] matrix ){
        Random random = new Random();
        for ( int i = 0; i< matrix.length; i++){
            for ( int j = 0; j< matrix.length; j++){
                matrix[i][j] = random.nextInt(10);
            }
        }

    }
    static void printArr( int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
    static int[] getmaindiag (int[][] matrix) {

        int ary[] = new int[matrix.length];
        int q = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if (i == j) {
                    ary[q] = matrix[i][j];
                    q++;

                }
            }

        }
        return ary;
    }

    public static void main(String[] args) {
            int[][] Matrix = createMatrix();
            fillArr(Matrix);
            printArr(Matrix);
            System.out.println();
            getmaindiag ( Matrix);
            int[] diag= getmaindiag ( Matrix);
            printArr(diag);

//       int[] Array = createArr();
//       fillArr(Array);
//        printArr(Array);
//        System.out.println();
//        int result = sumArr(Array);
//        System.out.println(result );
//        System.out.println("avgArr" + " " + avgArr(Array));
//        System.out.println( " Max " + maxFun(Array) );
//        System.out.println( " searchFun " + searchFun( Array, maxFun(Array) ));

    }
}