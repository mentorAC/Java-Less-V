import java.util.Random;

public class World {
    private Organism matrix[][];
    public World(int rows, int cols) {
        matrix = new Organism[rows][cols];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j]= new Organism();
            }
        }
    }
    public void PrintMatrix(){
      for(int i= 0; i<matrix[0].length+ 2; i++){
          System.out.print("-");
      }
        System.out.println();
        for(int i = 0; i< matrix.length; i++){
            System.out.print("|");
            for( int j = 0; j< matrix[i].length; j++){
                matrix[i][j].draw();


            }
            System.out.print("|");
            System.out.println();
        }
        for(int i = 0; i< matrix[0].length+2; i++){
            System.out.print("-");
        }
    }
    public void Generate( int count){
        for( int i =0; i< count; i++){
            Random random = new Random();
            int y = random.nextInt(matrix.length);
            int x = random.nextInt(matrix[0].length);
            matrix[y][x].resurrect();
        }
    }
}
