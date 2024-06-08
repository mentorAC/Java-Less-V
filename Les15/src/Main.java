public class Main {
    public static void main(String[] args) {
//        Car car = new Car("Audi");
//        car.setMark("Audi");

//        Human human = new Human("Tom", "Amazon", 12);

//        int a = 123;

//        Tea tea = new Tea("green");
//        tea.sugarFree = false;
//        tea.brewTea();
//        Rect rect = new Rect( 2, 6);
//        System.out.println(rect.Area());
//        System.out.println(rect.Perimeter());
        Circle circle1 = new Circle(8, 3, 6);
        System.out.println(circle1.toString());
 }

    int add(int a, int b){
        return a+b;
    }
    double add(double a, double b ){
        return a+b;
    }
    String add(String a, String b){
        return a+b;
    }
}
 class Circle {
    private double x;
    private double y;
    private double radius;

    public Circle(){
        this(0,0,0);

    }
     public Circle(double x, double y, double radius){
         this.x = x;
         this.y = y;
         this.radius = radius;
     }
     public double length(){
        return length(radius);
     }
     public double length(double radius){
         return 2*Math.PI *radius;
     }
     public Circle GetCircleCopy(){
        return new Circle( x, y, this.radius);
     }
     public Circle GetCircleCopy( Circle circle){
        return new Circle(circle.x, circle.y, circle.radius);
     }
     public boolean Point(double x, double y){
        double Part = Math.pow(x - this.x,2)+ Math.pow(y- this.y,2);
        return Part<=Math.pow(radius,2);
     }

     @Override
     public String toString() {
         return " x: " +x + "y: "+y + "radius: "+ radius;
     }
 }

class Student{
    private String name;
    private int course;
    private boolean salary;

    public Student(String name, int course, boolean salary){
       this(name,course);
        this.salary = salary;
    }
    public Student(String name){
        this.name = name;
    }
    public Student(String name, int course) {
        this(name);
        this.course = course;
    }

}
class Rect{
    private double length;
    private double width;
    public Rect(double length, double width){
        this.length = length;
        this.width = width;

    }
    public double Perimeter(){
        return (length+width)*2;
    }
    public double Area(){
        return length*width;
    }
}

class Car {
    public Car(String mark){
        System.out.println("This is car constructor!");
        this.mark = mark;
    }
    private String model;
    private String mark;

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
}

class Human{

    String name;
    String workPlace;
    int roomNum;
    public Human(String name){
        this.name = name;
        System.out.println("This is human constructor #1");
    }

    public Human(String name, String workplace){
        this(name);
        this.workPlace = workplace;
        System.out.println("This is human constructor #2");

    }

    public Human(String name, String workPlace, int roomNum){
        this(name, workPlace);
        this.roomNum = roomNum;
        System.out.println("This is human constructor #3");

    }
}

class Tea{
    Tea(String type){
        tea = type;
    }
    boolean sugarFree = true;
    String tea = "__";

    void brewTea(){
        System.out.println("The "+tea+" has brewing!");
        if(sugarFree == false){
            System.out.println("With sugar!");
        }
    }
}