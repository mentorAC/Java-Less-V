public class Main {
    public static void main(String[] args) {
//        Human human1 = new Human();
//        human1.name = "Max";
//
//        Human human2 = new Human();
//        human2.name = "Tom";
//        human1.age = 6;
//        human1.height = 9;
//        human2.PrintName();
//        human2.PrintName();
//
//Lampa lampa1 = new Lampa();
//lampa1.ShowStatus();
//lampa1.TurnOn();
//        lampa1.ShowStatus();
//        lampa1.TurnOff();
//        lampa1.ShowStatus();
//        lampa1.TurnOn();
//        lampa1.TurnOn();
//        lampa1.TurnOn();
//        lampa1.TurnOn();
//        lampa1.TurnOn();
//        lampa1.TurnOn();
//        lampa1.TurnOn();
//        lampa1.TurnOn();
//        lampa1.TurnOn();
//        lampa1.TurnOn();
//        lampa1.ShowStatus();
//        TV tv1 = new TV();
//        tv1.ShowChannel();
//        tv1.Down();
//        tv1.ShowChannel();
//        tv1.Up();
//        tv1.ShowChannel();
//        tv1.CurrentChannel(121);
//        tv1.ShowChannel();



//        Human h = new Human();
//        h.setName("Tom");
//        h.setAge(-20);
//        System.out.println(h.getAge());


    Number num1 = new Number();
    num1.setValue(12);
    Number num2 = new Number();
    num2.setValue(3);

//
//        System.out.println( num1.sub(num2)); //9
//        System.out.println(num1.sum(num2)); //15
//        System.out.println (num1.div(num2));  //4
//        System.out.println( num1.mult(num2)); //36

System.out.println(num1.sum(num2).sum(num1).mult(num2).sub(5).sub(num1));//76

    }
}
//public
//private
//protected
//<default>
class Number{
    private int value;
    public void setValue(int newValue){
        this.value = newValue;
    }
    public Number sum(Number number){
        int sum = number.value + value;
        Number result = new Number();
        result.setValue(sum);
        return  result;

    }
    public Number sub(int number){
        int sub = value - number;
        Number result = new Number();
        result.setValue(sub);
        return result;
    }
    public int sub(Number num){
        int sub = value - num.value;
        return sub;
    }
    public int div( Number number){
        if(number.value!=0){
            int div = value/number.value;
            return div;
        }else{
            System.out.println("Erorr");
        }
         return 0;
    }
    public Number mult(Number number){
        int mult = number.value * value;
        Number result = new Number();
        result.setValue(mult);
        return  result;
    }

}

class Human{
    private int age;
    private String name;
    private int height;
    int weight;
    public void setName(String newname){
        this.name =newname;
    }
    public String getName(){
        return name;
    }

    public void setAge(int newValue){
        if(newValue <= 0){
            System.out.println("Error! Your age is invalid!");
        }else{
            this.age = newValue;
        }
    }
    public int getAge(){
        return age;
    }
    public void PrintName(){
        System.out.println(name);
        name = "Bob";
    }
}

class Lampa{
   private boolean status = false;
   private int count= 0;
    public void TurnOn(){
        status= true;
        count++;
    }
    public void TurnOff(){
        status = false;
    }
    public void ShowStatus(){
        if(count>=10){
            System.out.println(" Lampa broke");
            return;
        }
        if(status== true){
            System.out.println(" Working");

        }else{
            System.out.println("Not Working");

        }

    }
}
class TV{
    public int channel = 1;
    public void Up(){
        channel++;
        if(channel>=101){
            channel=1;
        }
    }
    public void Down(){
        channel--;
        if (channel <= 0) {
            channel=100;
        }
    }
    public void CurrentChannel(int channel){
       this.channel=channel;
       if(channel<=0){
           this.channel=1;
       }
       else if (channel>=100){
           this.channel=100;
       }else{
           this.channel=channel;
       }
    }
    public void ShowChannel(){
        System.out.println(channel);
    }
}