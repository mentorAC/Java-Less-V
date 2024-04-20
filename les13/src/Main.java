import java.util.Random;
import java.util.Scanner;


public class Main {
     static int[] CreateMas( int size){
        int[] ary = new int [size];
        Random random = new Random();
        for ( int i =0;i< ary.length; i++){
            ary[i] = random.nextInt(100);
        }
       return ary;
    }
    static void showMas(int[] ary){
        for ( int i =0;i< ary.length; i++){
            System.out.print( ary[i] + " ");
        }

    }
    static int  MaxFun( int [] ary){
        int max = 0;
        for ( int i =0;i< ary.length; i++){
            if( ary[i] >max){
                max = ary[i];
            }
        }
        return max;
    }
    static int MinFun ( int [] ary){
        int min = 100;
        for ( int i =0;i< ary.length; i++){
            if( ary[i]< min){
                min = ary[i];
            }
        }
        return min;
    }
    static void GreenFun( int [] ary){
        String ANSI_GREEN = "\u001B[32m";
        String ANSI_RESET = "\u001B[0m";
        for ( int i =0;i< ary.length; i++){
            if( ary[i]%2 == 0){
                System.out.print(ANSI_GREEN + ary[i] + " " + ANSI_RESET + " " );


            }else {
                System.out.print( ary[i] + " ");
            }
        }


    }
    static void ThreeFun ( int[] ary){

        for ( int i =0;i< ary.length; i++){
            if( ary[i]%3 == 0){
                System.out.print( 0 + " ");
            }else{
                System.out.print(ary[i] + " ");
            }
        }
    }
    //
    static int [][] CreateRect( int a, int b) {
        int[][] matrix = new int[a][b];

        for (int j = 0; j < matrix[0].length; j++) {
            matrix[0][j] = 1;
            matrix[a - 1][j] = 1;

        }
        for (int i = 0; i < matrix.length; i++) {
            matrix[i][0] = 1;
            matrix[i][b - 1] = 1;
        }
        return matrix;

    }
    static void PrintRect( int[][] matrix){
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if( matrix[i][j]==1 ){
                    System.out.print("*");
                }else if (matrix[i][j]==0 ){
                    System.out.print(" ");

                }
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int [][] matrix = CreateRect(4,7);
        PrintRect(matrix); 



//        int [] ary = CreateMas(size);
//        showMas(ary);
//        int max = MaxFun(ary);
//        int min = MinFun(ary);
//        System.out.println();
//        System.out.println( max );
//        System.out.println( min );
//        GreenFun(ary);
//        System.out.println();
//        ThreeFun(ary);
    }
}