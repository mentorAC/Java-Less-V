import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        char[][] matrix = new char[size][size];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                matrix[i][j]= ' ';
                if (i == 0 || i == size - 1) {
                    matrix[i][j] = '*';
                }
                if (i == j) {
                    matrix[i][j] = '*';
                }
                if (i + j == size - 1) {
                    matrix[i][j] = '*';

                }

            }




        /*int size = sc.nextInt();
        int[][] matrix = new int[size][size];
        int a = 0;
        boolean b = true;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
               b = !b;
                if (b == false) {
                    a++;
                     matrix[i][j] = a;
                }

            }

        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                System.out.print(matrix[i][j] + " ");

            }
            System.out.println();

        }*/
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}