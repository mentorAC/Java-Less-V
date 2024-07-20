import java.util.Random;

public class World {
    private Organism matrix[][];
    public World(int rows, int cols) {
        matrix = new Organism[rows][cols];
        matrixtwo = new Organism[rows][cols];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j]= new Organism();
                matrixtwo[i][j]= new Organism();
            }
        }
    }
    private Organism matrixtwo[][];
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
        System.out.println();
    }

    public void Generate( int count){
        for( int i =0; i< count; i++){
            Random random = new Random();
            int y,x;
            do {
                y = random.nextInt(matrix.length);
                x = random.nextInt(matrix[0].length);
            } while(matrix[y][x].isLife());
            matrix[y][x].resurrect();
        }
    }
    public void Step() {
        for (int i = 0; i < matrixtwo.length; i++) {
            for (int j = 0; j < matrixtwo[i].length; j++) {
                matrixtwo[i][j].kill();
            }
            }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
               int count = Neighbour(i,j);
               if(count<2 || count >3){
                   matrixtwo[i][j].kill();
               }
               if( count==3){
                   matrixtwo[i][j].resurrect();
               }
               if((count==2 || count==3) && matrix[i][j].isLife()){
                   matrixtwo[i][j].resurrect();
               }
            }



        }
        var temp = matrix;
        matrix= matrixtwo;
        matrixtwo= temp;
    }
    private int Neighbour(int i, int j){
        int[] biasI = {-1, -1, -1, 0, 1, 1, 1, 0};
        int[] biasJ = {-1, 0, 1, 1, 1, 0, -1, -1};
        int count = 0;
        for( int k = 0; k< biasI.length; k++){
            int i_ = i+biasI[k];
            int j_ = j+biasJ[k];
            if(inBoard(i_,j_) && matrix[i_][j_].isLife()){
                count ++;
            }

        }
        return count;

    }
    private boolean inBoard(int i, int j){
        return i >= 0&& j>=0&& i< matrix.length && j< matrix[i].length;
    }

}
