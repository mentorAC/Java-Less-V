public class Main {
    public static void main(String[] args) {
        //World world = new World(10,10);
       //world.PrintMatrix();

        Organism org1;
        Organism org2;
        Organism org3;
        Organism org4;
        Organism matrix[][] = new Organism[2][2];
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix.length; j++){
                matrix[i][j] = new Organism();
            }
        }


        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix.length; j++){

                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
    }
}