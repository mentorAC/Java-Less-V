import java.util.Date;

public class Main {

    //[modificator] return_type name([param_type, param_name]..){
    //  body...
    //}

    static void  Log(){
        System.out.println("All good!!");
    }
    static void PrintHello(){
        System.out.println("Hello Function!!");
    }
    static void printNumber(int a, int f){
        System.out.println(a);
    }

    //static int sum(int a, int b){ return a+b;}
    static int getTen(){
        return 10;
    }

    static void printArray(int[] arr){
        for (int i = 0; i < arr.length; i++){
            System.out.print(arr[i]+" ");
        }
    }

    static String getMessage() {
        return "hello, this is message!";
    }
    public static void main(String[] args) {
    int[] arr = {1,4,2,5,7};
    printArray(arr);

//        //module1
//
//        Log();
//
//        //module2
//
//        Log();
//
//        //module3
//
//        Log();
//
//        //module4
//
//        Log();
//
//        //module5
//
//        Log();
//
//        //module6

//        PrintHello();
//        PrintHello();
//        PrintHello();


//        printNumber(4);
//        printNumber(2);
//        printNumber(60);

        //sum(4, 7);
        //int ten = getTen();

//        String msg = getMessage();

    }
}