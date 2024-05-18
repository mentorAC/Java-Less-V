public class Main {
    public static void main(String[] args) {
        Human human1 = new Human();
        human1.name = "Max";

        Human human2 = new Human();
        human2.name = "Tom";
//        human1.age = 6;
//        human1.height = 9;
        human2.PrintName();
        human2.PrintName();


    }
}
//public
//private
//protected
//<default>
class Human{
    public int age;
    String name;
    private int height;
    int weight;


    public void PrintName(){
        System.out.println(name);
        name = "Bob";
    }
}