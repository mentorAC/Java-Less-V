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

Lampa lampa1 = new Lampa();
lampa1.ShowStatus();
lampa1.TurnOn();
        lampa1.ShowStatus();
        lampa1.TurnOff();
        lampa1.ShowStatus();
        lampa1.TurnOn();
        lampa1.TurnOn();
        lampa1.TurnOn();
        lampa1.TurnOn();
        lampa1.TurnOn();
        lampa1.TurnOn();
        lampa1.TurnOn();
        lampa1.TurnOn();
        lampa1.TurnOn();
        lampa1.TurnOn();
        lampa1.ShowStatus();
        TV tv1 = new TV();
        tv1.ShowChannel();
        tv1.Down();
        tv1.ShowChannel();
        tv1.Up();
        tv1.ShowChannel();
        tv1.CurrentChannel(121);
        tv1.ShowChannel();









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