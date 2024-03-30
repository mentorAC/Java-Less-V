import java.util.Scanner;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        //{1,2,3,4,5}
        //{
        // {1,2,3}
        // {1,2,3}
        // {1,2,3}
        // }

//        int[][] matrix0 = new int[3][3];
//        int[][] matrix = {
//            {1,2,3},
//            {4,5,6},
//            {8,9,0}
//        };
//
//        for (int  i = 0; i < matrix.length; i++){
//            for (int j = 0; j< matrix[i].length; j++){
//                //System.out.print(matrix[i][j]+" ");
//                System.out.print("["+i+"]["+j+"]|");
//            }
//            System.out.println();
//        }
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int[][] matrix = new int[size][size];
        Random random = new Random();
        for (int i = 0; i < matrix.length; i++) {

            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = random.nextInt(100);
            }
        }
//        for( int i=0; i< matrix.length;i++) {
//            int sum = 0;
//
//            for (int j = 0; j < matrix.length; j++) {
//
//                System.out.print(matrix[i][j] + " " );
//                sum += matrix[i][j];
//            }
//            System.out.print( " -> " );
//
//            System.out.print( sum );
//
//
//            System.out.println();
        //      }
        for (int i = 0; i < matrix.length; i++) {

            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        int max = 0;
        int ik = 0;
        int jk = 0;
        for (int i = 0; i < matrix.length; i++) {

            for (int j = 0; j < matrix[i].length; j++) {

                if (matrix[i][j] > max) {
                    max = matrix[i][j];
                    ik = i;
                    jk=j;


                }
            }
        }

        System.out.println(max + " i" + ik + " j" + jk );

        for (int i = 0; i < matrix.length; i++) {

            for (int j = 0; j < matrix[i].length; j++) {
                if (i == j)
                    System.out.print(matrix[i][j] + " ");

            }


        }
    }
}
