import java.util.Scanner;

public class Main {
    public static void Task1(){
        Scanner cs = new Scanner(System.in);
        System.out.println(" Enter number A:");
        int value = cs.nextInt();
        System.out.println(" Enter number B:");
        int num = cs.nextInt();
        for (int i = 0; i < value; i++) {
            System.out.print(num);
        }
        for (int i = 0; i < num; i++) {
            System.out.print(value);

        }
    }
    public static void Task2(){
        Scanner cs = new Scanner(System.in);
        System.out.println(" Enter number one:");
        int A = cs.nextInt();
        System.out.println(" Enter number two:");
        int B = cs.nextInt();
        System.out.println(" Enter number three:");
        int C = cs.nextInt();
        for (int i = 0; i < A; i++) {
            System.out.print("[]");
        }
        System.out.println();

        for (int i = 0; i < B; i++) {
            System.out.print("[]");
        }
        System.out.println();

        for (int i = 0; i < C; i++) {
            System.out.print("[]");
        }
    }
    public static void main(String[] args) {
            //Task1();
            //Task2();
    }
}