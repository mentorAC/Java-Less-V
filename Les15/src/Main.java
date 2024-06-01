public class Main {
    public static void main(String[] args) {
//        Car car = new Car("Audi");
//        car.setMark("Audi");

//        Human human = new Human("Tom", "Amazon", 12);

//        int a = 123;
        Tea tea = new Tea("green");
        tea.sugarFree = false;
        tea.brewTea();
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