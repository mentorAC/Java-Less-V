import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter quantity rows: ");
        int rows = sc.nextInt();
        System.out.println("Enter quantity cols: ");
        int cols = sc.nextInt();
        System.out.println("Enter quantity alive organism: ");
        int organism = sc.nextInt();

        World world = new World(rows,cols);
        world.Generate(organism);

        while(true) {
            world.PrintMatrix();
            world.Step();
        }


//       Organism org1;
//        Organism org2;
//        Organism org3;
//        Organism org4;
//        Organism matrix[][] = new Organism[2][2];
//        for(int i = 0; i < matrix.length; i++){
//            for(int j = 0; j < matrix.length; j++){
//                 matrix[i][j] = new Organism();
//            }
//        }
//
//
//        for(int i = 0; i < matrix.length; i++){
//            for(int j = 0; j < matrix.length; j++){
//
//                System.out.print(matrix[i][j]);
//            }
//            System.out.println();
//        }
    }
}