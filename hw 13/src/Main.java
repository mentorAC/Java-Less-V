import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner cs = new Scanner(System.in);
        System.out.println("Enter x:");
        int x = cs.nextInt();
        System.out.println("Enter y:");
        int y = cs.nextInt();
        System.out.println("Enter width:");
        int width = cs.nextInt();
        System.out.println("Enter height:");
        int height = cs.nextInt();
        CreateRect(x,  y, width,height);
    }
    static void CreateRect(int x, int y, int width, int height) {
        for (int i = 0; i < y; i++) {
            System.out.println();
        }

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < x; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j < width; j++) {
                System.out.print("*");
            }
            System.out.println();


        }
    }
}
