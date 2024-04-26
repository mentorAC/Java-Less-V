import java.util.Random;

public class Main {
    public static void main(String[] args) {

        char[][] matrix = new char[8][8];
        fillMatrix(matrix);
        KingFun(matrix);
       int[] xy= KPosFun(matrix);
        DrawFun(matrix, xy[0], xy[1]);
        showFun( matrix);
//        int[] arr = {0,0,0,0};
//        IncFunc(arr);
//        for(int i = 0; i < arr.length; i++){
//            System.out.print(arr[i]+" ");
//        }
//        System.out.println();
//
//
//        int value = 0;
//        IncValue(value);
//        System.out.println(value);
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

    static void KingFun(char[][] ary) {
        Random random = new Random();
        int kingx = random.nextInt(8);
        int kingy = random.nextInt(8);
        ary[kingx][kingy] = 'K';

    }

    static int[] KPosFun(char[][] ary) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (ary[i][j] == 'K') {
                    return new int[]{j, i};
                }
            }
        }
        return null;
    }
    static void DrawFun(char[][] ary, int kingx, int kingy){
        int [] cordi = {-1, -1, -1, 0, 1, 1, 1, 0};
        int[] cordj = { -1, 0, 1, 1, 1, 0, -1, -1};
        for (int i = 0; i < cordi.length; i++) {
            int x= kingx + cordj[i];
            int y = kingy + cordi[i];
            if(x< 0|| x>7|| y<0 || y>7 ){
                continue;
            }
            ary[y][x] = '*';

        }

    }
    static void showFun( char [][] ary){
        for( int i= 0; i< ary.length; i++){
        for( int j = 0; j < ary.length; j ++){
            System.out.print(ary[i][j]);
        }
        System.out.println();
        }
    }

}
//........
//........
//........
//........
//....K...
//........
//........
//........
//........

//        ........
//        ........
//        ...***..
//        ...*K*..
//        ...***..
//        ........
//        ........
