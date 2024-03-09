import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("size ");
        int size = sc.nextInt();
        int[] arr = new int[size];
        int even = 0;
        int odd = 0;

        System.out.println("elements ");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
            if (arr[i] % 2 == 0) {
                even++;
            }
            if (arr[i] % 2 != 0) {
                odd++;
            }
        }
        System.out.println(" even " + even);

        System.out.println(" odd " + odd);
        if(even>odd) {
            System.out.println(" even " + even);
        } else{
            System.out.println(" odd  " + odd);


        }
    }




        /*  Scanner sc = new Scanner(System.in);
        System.out.println("size ");
        int size = sc.nextInt();
        int[] arr = new int[size];
        int max = 0;

        System.out.println("elements ");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
            if (arr[i] > max) {
                max = arr[i];
            }

        }
        System.out.println(" max " + max);
    }  */

        /* Scanner sc = new Scanner(System.in);
        System.out.println("size ");
        int size = sc.nextInt();
        int[] arr = new int[size];
        int sum = 0;

        System.out.println("elements ");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
            if (arr[i] % 2 == 0) {
                sum += arr[i];
            }
        }

        System.out.println("Number of even elements: " + sum);
    }*/
}
