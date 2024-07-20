public class Main {
    public static void main(String[] args) {
//        Employee employee = new Employee();
////        employee.
//
//        Human human = new Builder();
//        Employee emp = (Employee)human;
//        emp.company = "Apple";
//        //Human human1 = new Student()
//        System.out.println(emp.company);

//        Human human_h = new Human();
//        human_h.name = "Tom";
//
//        Human human_e = new Employee("Apple");
//        human_e.name = "Bob";
//        human_e.height = 2;
//
//        human_h.sayHello();
//        human_e.sayHello();
//        Animal animal[] = new Animal[]{
//                new Cat(),
//                new Dog(),
//                new Pig(),
//                new Dog(),
//                new Pig(),
//
//        };

        Cat cat = new Cat();
        System.out.println(cat);


//        Dog patron = new Dog();
//        Pig pig = new Pig();
//        Horse horse = new Horse();
//
//        AnimalSay(cat);
//        AnimalSay(patron);
//        AnimalSay(pig);
//        AnimalSay(horse);

        //Animal animal = new Animal();
        //animal.Say();

//        for (int i = 0; i < animal.length; i++) {
//            AnimalSay(animal[i]);
//        }




    }

    public static void AnimalSay(Animal animal) {
        animal.Say();
    }
}


class Human{
    public String name;
    private int Age;
    protected int height;
    void sayHello(){
        System.out.println("Hello, I am "+name);
    }
}

class Employee extends Human
{
    String company;
    Employee(){}
    Employee(String company){
        this.company = company;
    }
    void sayHello(){
        System.out.println("Hello, I am "+name+" and I am working at "+company);
    }
}

class Boss extends Employee{
    int room;
}

class Student{
    Student(){}
    Student(String name){
        this.name = name;
    }
    Student(String name, int age){
        this(name);
        this.age = age;
    }
    Student(String name, int age, boolean isHasSalary){
        this(name, age);
        this.isHasSalary = isHasSalary;
    }
    String name;
    int age;
    boolean isHasSalary;
}
abstract class Animal{
    public abstract void Say();
}
class Cat extends Animal
{
    @Override
    public void Say(){
        System.out.println(" I am cat and I say meow");
    }

    @Override
    public String toString(){
        return "I am a cat!";
    }
}
class Dog extends Animal
{
    public void Say(){
        System.out.println("I am dog and I say gav");
    }
}
class Pig extends Animal
{
    public void Say() {
        System.out.println("I am pig and I sar hrrr");
    }
}
class Horse extends Animal
{
    public void Say() {
        System.out.println("I am horse and I sar brrr");
    }
}
