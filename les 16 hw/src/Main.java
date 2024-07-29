abstract class Cosmetic{
    protected double price;
    protected String name;
    protected String marka;
    public Cosmetic(double price, String name, String marka){
        this.price=price;
        this.name= name;
        this.marka=marka;
    }
}

class Lipstick extends Cosmetic{
    public Lipstick(double price, String name, String marka){
        super(price, name,marka);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Lipstick) {
            Lipstick cosmetic1 = (Lipstick) obj;
            return this.name == cosmetic1.name && cosmetic1.marka == this.marka;
        }
        return false;
    }
}
class Blush extends Cosmetic{
    public Blush(double price, String name, String marka){
        super(price, name,marka);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Blush) {
            Blush cosmetic2 = (Blush) obj;
            return this.name == cosmetic2.name && cosmetic2.price == this.price;
        }
        return false;
    }
}

        abstract class Transport {
            public abstract void ride();
            public abstract void beep();
        }


        class Car extends Transport {
            public void ride() {
                System.out.println("Car is driving");

            }
            public void beep(){
                System.out.println(" Bee Bee");

            }
        }

        class Train extends Transport {
            public void ride() {
                System.out.println("Train is moving");
            }
            public void beep(){
                System.out.println("beep!");

            }
        }

        class Driver {
    String name;
    Driver(String name){
        this.name = name;
    }
    Transport transport;
            public void sitIn(Transport transport) {
                System.out.println("Driver is sitting");
                this.transport=transport;
            }

            public void drive() {
                transport.ride();
            }

            public void beep() {
                transport.beep();
            }

            public void exit() {
                System.out.println("Driver is exiting");
                transport = null;
            }

            @Override
            public String toString() {
                return "Driver ("+name+")!!!!";
            }
        }

        public class Main {
            public static void main(String[] args) {
//                Driver driver = new Driver("Tom");
//
//                Cosmetic cosmetic[] = new Cosmetic[] {
//                        new Blush( 123.3, "Cherry", "Maybelline"),
//                        new Lipstick( 525, "Sky", "Dior"),
//
//                };
//                Cosmetic cosmetic1 = new Lipstick(525, "Sky","Dior");
//                System.out.println(contains(cosmetic, cosmetic1));
//                Car car = new Car();
//                Train train = new Train();
//
//                driver.sitIn(car);
//                driver.drive();
//                driver.beep();
//                driver.exit();
//
//                System.out.println();
//
//                driver.sitIn(train);
//                driver.drive();
//                driver.beep();
//                driver.exit();

                //Object obj = new Object();
                //obj.
//                Object obj = driver;
//                System.out.println(obj.toString());
                try {
                    test();
                }
                catch(Exception ex){
                    System.out.println(ex.getMessage());
                }
                System.out.println("End");
            }
            static void test (){
                int zero = 0;
                int a = 2 / zero;
            }
            public static boolean contains(Cosmetic[] ary, Cosmetic obj ){
                for(int i= 0; i< ary.length; i++){
                    if(ary[i].equals(obj)){
                       return true;
                    }
                }
                return false;
            }
        }
