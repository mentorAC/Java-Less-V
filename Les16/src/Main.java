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

        Human human_h = new Human();
        human_h.name = "Tom";

        Human human_e = new Employee("Apple");
        human_e.name = "Bob";

        human_h.sayHello();
        human_e.sayHello();
    }
}


class Human{
    String name;
    private int age;
    protected int height;
    void sayHello(){
        System.out.println("Hello, I am "+name);
    }
}

class Employee extends Human
{
    Employee(String company){
        this.company = company;
    }
    String company;

    void sayHello(){
        System.out.println("Hello, I am "+name+" and I am working at "+company);
    }
}

class Builder extends Human{

}


class Boss{
    String name;
    int age;
    String company;
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