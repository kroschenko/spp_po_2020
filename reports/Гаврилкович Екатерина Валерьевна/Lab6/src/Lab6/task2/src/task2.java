public class task2{
    public static void main(String[] args) {
        ElectronicThermometer t1 = new ElectronicThermometer();
        MercuryThermometer t2 =new MercuryThermometer(100, 0, 30);
        Thermometer.measure(t1, 1000);
        t1.getT();
        Thermometer.measure(t2, 25);
        t2.getT();
        Thermometer.measure(t2, 1000);

        t2.getT();
    }
}
class ElectronicThermometer{
    int T;
    ElectronicThermometer(){
        this.T = 0;
    }
    ElectronicThermometer(int t){
        this.T = t;
    }
    void measure(int t){
        this.T = t;
    }
    void getT(){
        System.out.println("T = "+ this.T);
    }
}
class MercuryThermometer{
    int minT;
    int maxT;
    int T;
    MercuryThermometer(int max, int min){
        this.minT = min;
        this.maxT = max;
    }
    MercuryThermometer(int max, int min, int t){
        this.minT = min;
        this.maxT = max;
        if (t <= this.maxT && t >= this.minT){
            this.T = t;
        }else {
            this.T = this.minT;
        }
    }
    void measure(int t){
        if (t <= this.maxT && t >= this.minT){
            this.T = t;
        }
    }
    void getT(){
        System.out.println("T = "+ this.T);
    }
}
class Thermometer{
    static public void measure(MercuryThermometer m, int t){
        m.measure(t);
    }
    static public void measure(ElectronicThermometer m, int t){
        m.measure(t);

    }
}