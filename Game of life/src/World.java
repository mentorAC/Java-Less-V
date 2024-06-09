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
      for(int i= 0; i<matrix.length; i++){
          System.out.print("-");
      }
        for(int i = 0; i< matrix.length; i++){
            for( int j = 0; j< matrix[i].length; j++){
                matrix[i][j].draw();
            }
        }
    }
}
