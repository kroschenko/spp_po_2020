import java.util.ArrayList;
public class task1
    public static void main(String[] args) {
        Apple f1 = (Apple)FactoryPhone.createPhone("Apple", 32, "ellow");
        FactoryPhone f2 = FactoryPhone.createPhone("Samsung", 64, "ellow");
        f1.sayСharacteristics();
    }
}
class FactoryPhone{
    public static FactoryPhone createPhone(String model, int mem, String color){
        if (model.equals("Apple")){
            System.out.println("Apple phone crate!");
            return new Apple(mem, color);
        }
        if (model.equals("Samsung")){
            System.out.println("Samsung phone crate!");
            return new Samsung(mem, color);
        }
        else{
            System.out.println("Error");
        }
        return null;
    }
}
class Apple extends FactoryPhone {
    int mem;
    String color;
    public Apple(int mem, String color){
        this.mem=mem;
        this.color=color;
    }
    public void sayСharacteristics() {

        System.out.println("mem = "+this.mem+" color = "+ this.color);
    }
}
class Samsung extends FactoryPhone {
    int mem;
    String color;
    public Samsung(int mem, String color){
        this.mem=mem;
        this.color=color;
    }
    public void sayСharacteristics(int mem, String color) {
        System.out.println("mem = "+this.mem+" color = "+ this.color);
    }
}