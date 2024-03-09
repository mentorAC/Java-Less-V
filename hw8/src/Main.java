import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int[] arr = new int[size];
        int count = 0;


        System.out.println("size ");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();

        }
        for (int i = 0; i < arr.length - 1; i++) {
            System.out.print(arr[i]);
            if (arr[i] != arr[i + 1]) {
                System.out.println();

            }
        }
    }
}