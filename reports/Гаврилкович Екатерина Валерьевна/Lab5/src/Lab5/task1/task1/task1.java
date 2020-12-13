import java.util.*;

public class task1{
    public static void main(String[] args) {
            
        Theatre theatre = new Theatre();
        theatre.getHeight();
        theatre.getPrice();
        theatre.getCount();

    }
}

interface Building{
    void getHeight();
    void getPrice();
}

abstract class PublicBuilding implements Building{

    public void getHeight(){
        System.out.println("Height: 100");
    }
    
    public void getPrice(){
        System.out.println("Price: 10000$");
    }

    public void getCount(){
        System.out.print("Count: 4000");
    }    
}

class Theatre extends PublicBuilding{

    public Theatre(){
        System.out.println("Theatre!");
    }
}