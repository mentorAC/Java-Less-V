import java.util.Random;

public class Main {
    public static void main(String[] args) {

        char[][] matrix = new char[8][8];
        fillMatrix(matrix);
        setRandomLetFun(matrix, 'A');
        setRandomLetFun(matrix, 'B');
        int[] posA = APosFun(matrix);
        int[] posB = BPosFun(matrix);
        DrawFun(matrix, posA[0], posA[1], posB[0], posB[1]);
        showFun(matrix);
    }

    static void IncValue(int a) {
        a++;
    }

    static void IncFunc(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i]++;
        }
    }

    static void fillMatrix(char[][] ary) {
        for (int i = 0; i < ary.length; i++) {
            for (int j = 0; j < ary.length; j++) {
                ary[i][j] = '.';
            }
        }

    }



    static void setRandomLetFun(char[][] ary, char letter) {
        Random random = new Random();
        int Bx = random.nextInt(8);
        int By = random.nextInt(8);
        ary[Bx][By] = letter;

    }

    static int[] APosFun(char[][] ary) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (ary[i][j] == 'A') {
                    return new int[]{j, i};
                }
            }
        }
        return null;
    }

    static int[] BPosFun(char[][] ary) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (ary[i][j] == 'B') {
                    return new int[]{j, i};
                }
            }
        }
        return null;
    }

    static void DrawFun(char[][] ary, int Ax, int Ay, int Bx, int By) {

        int minX = Math.min(Ax, Bx);
        int maxX = Math.max(Ax, Bx);
        int minY = Math.min(Ay, By);
        int maxY = Math.max(Ay, By);


        for (int i = minY; i <= maxY; i++) {
            for (int j = minX; j <= maxX; j++) {

                if (i == minY || i == maxY || j == minX || j == maxX) {
                    ary[i][j] = '*';
                }
                if (i == minY && j == minX){
                    ary[i][j] = 'A';
                }

                if (i == maxY && j == maxX){
                    ary[i][j] = 'B';
                }
            }
        }
    }

    static void showFun(char[][] ary) {
        for (int i = 0; i < ary.length; i++) {
            for (int j = 0; j < ary.length; j++) {
                System.out.print(ary[i][j]);
            }
            System.out.println();
        }
    }
}