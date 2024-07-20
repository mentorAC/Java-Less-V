import java.util.Scanner;

class Train {
    private int number;
    private int stops;
    private int cars;
    private int departureTimemin;
    private int departureTimehour;

    private int arrivalTimemin;
    private int arrivalTimehour;


    public void consoleTrain() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of train: ");
        this.number = sc.nextInt();

        System.out.print("Enter quantity stops: ");
        this.stops = sc.nextInt();

        System.out.print("Enter quantity cars: ");
        this.cars = sc.nextInt();

        System.out.print("Enter departureTime  : ");
        this.departureTimemin = sc.nextLine();

        System.out.print("Enter arrivalTime : ");
        this.arrivalTimemin = sc.nextLine();
    }


    public void printTrain() {
        System.out.println("number of train: " + number);
        System.out.println("quantity stops: " + stops);
        System.out.println("quantity cars: " + cars);
        System.out.println("departureTime: " + departureTime);
        System.out.println("arrivalTime: " + arrivalTime);
    }
}

