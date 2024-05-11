import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        char[][] board = {
                {' ', ' ', ' '},
                {' ', ' ', ' '},
                {' ', ' ', ' '}
        };
        int x, y;
        x = 1;
        y = 1;
        boolean isxstep = true;
        while (true) {
            String input = sc.next();
            if (input.compareTo("w") == 0) {
                y--;
            }
            if (input.compareTo("a") == 0) {
                x--;
            }
            if (input.compareTo("d") == 0) {
                x++;
            }
            if (input.compareTo("s") == 0) {
                y++;
            }
            if (input.compareTo("b") == 0 && board[y][x] == ' ') {
                board[y][x] = 'x';
                if (isxstep == true) {
                    board[y][x] = 'x';
                    isxstep = false;
                } else {
                    board[y][x] = '0';
                    isxstep = true;
                }
            }


            try {
                final String os = System.getProperty("os.name");

                String[] cls = new String[]{"cmd.exe", "/c", "cls"};
                Runtime.getRuntime().exec(cls);

            } catch (final Exception e) {
                System.out.println("??????? ?????? ?? ???????: " + e.getMessage());
            }
            PrintBoard(board, x, y, isxstep);
            char win= WinFun(board);
            if(win=='x'){
                System.out.println("X-WINNER");
                break;
            }else if(win=='0'){
                System.out.println("0-WINNER");
                break;
            }
        }


    }


    public static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";

    public static void PrintBoard(char[][] board, int x, int y, boolean isxstep) {
        System.out.println("+---+---+---+");
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                if (j == x && i == y) {
                    if (isxstep == true) {
                        System.out.print(ANSI_RED_BACKGROUND + board[i][j] + ANSI_RESET);
                    } else {
                        System.out.print(ANSI_GREEN_BACKGROUND + board[i][j] + ANSI_RESET);

                    }
                } else {
                    System.out.print(board[i][j]);
                }
                System.out.print(" | ");

            }
            System.out.println();
            System.out.println("+---+---+---+");

        }


    }

    public static char WinFun(char[][] board) {
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == board[i][1] && board[i][2] == board[i][1]) {
                return board[i][0];
            }
            if (board[0][i] == board[1][i] && board[2][i] == board[1][i]) {
                return board[0][i];
            }
        }
        if ((board[0][0] == board[1][1] && board[1][1] == board[2][2]) ||
                (board[0][2] == board[1][1] && board[1][1] == board[2][0])) {
            return board[1][1];

        }
        return ' ';
    }


    public static final String ANSI_RED_BACKGROUND = "\u001B[41m";
    public static final String ANSI_RESET = "\u001B[0m";
}