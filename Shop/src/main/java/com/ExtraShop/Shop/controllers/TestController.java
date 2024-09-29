package com.ExtraShop.Shop.controllers;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;

@RestController()
public class TestController {
TestController(){

    int[] arr = {1,3,2,4,3,6,8,3,6};
    var result = Arrays.stream(arr).distinct();
    var result1 = Arrays.stream(arr).filter(x -> x % 2 == 0 ).toArray();
    var result2 = Arrays.stream(arr).map(x -> x+1);


//    Conversation.Start(new Human());
}
    //HTTP_METHODS
    //GET
    //POST
    //PUT
    //DELETE
    @PostMapping("/test/get-data")
    public String getDataPost(){
        return "Hello, I am a POST Method";
    }
    @GetMapping("/test/get-data")
    public String getDataGet(){
        return "Hello, I am a GET Method";
    }
    @PutMapping("/test/get-data")
    public String getDataPut(){
        return "Hello, I am a PUT Method";
    }
    @DeleteMapping("/test/get-data")
    public String getDataDelete(){
        return "Hello, I am a DELETE Method";
    }

}
//
//class  Conversation{
//    static void Start(Human h){
//        h.Speak();
//    }
//}
//
//class Human{
//    void Speak(){ System.out.println("I am human");}
//}
//
//class Employee// extends Human
//{
//    void Speak(){
//        System.out.println("I am an employee");
//    }
//}
//
interface IMovable{
    void move();
    void running();

}
interface ICook{
    void cooking();

}
interface  ISpeakable{
    void Speaking();
}

class Robot implements IMovable, ICook, ISpeakable
{

    @Override
    public void move() {

    }

    @Override
    public void cooking() {

    }

    @Override
    public void Speaking() {

    }

    @Override
    public void running() {

    }
}

//public interface EmployeeRepo extends JpaRepository<Employee, Integer> {
//}
//
//@NoArgsConstructor
//@AllArgsConstructor
//@Data
//@Entity
//@Table(name = "employee")
//public class Employee {
//
////    @Id
//    private Integer id;
//    private String firstName;
//    private String lastName;
//    private Integer age;
//    private String designation;
//    private String phoneNumber;
//    private LocalDate joinedOn;
//    private String address;
//    private LocalDate dateOfBirth;
//    private LocalDateTime createdAt;
//    private LocalDateTime updatedAt;
//
//}