import java.util.ArrayList;
public class task3{
    public static void main(String[] args) {
        ATM atm = new ATM(1000, 1, 4550);
        atm.withdrawalMoney(33);
        atm.authorization(4550);
        atm.withdrawalMoney(33);
        atm.end();
    }
}
class Session{
    int pass;
    boolean authorization;
    Session(int p){
        this.pass= p;
        this.authorization = false;
    }
    boolean authorization (int p){
        if (p == this.pass){
            this.authorization = true;
            return true;
        }
        return false;
    }
    void end(){
        this.authorization = false;
        System.out.println("Сессия закрыта");
    }
    boolean getStatus(){

        return this.authorization;
    }
}
class Mode{
    String modename;
    Mode(){
        this.modename = "waiting";
        System.out.println("Mode = "+this.modename);
    }
    void setWaitng(){
        this.modename = "waiting";
        System.out.println("Mode = "+this.modename);
    }
    void setAuthorization(){
        this.modename = "authorization";
        System.out.println("Mode = "+this.modename);
    }
    void setPerformance(){
        this.modename = "performance";
        System.out.println("Mode = "+this.modename);
    }
    void setBlocking(){
        this.modename = "blocking";
        System.out.println("Mode = "+this.modename);
    }
    String getMode(){
        return this.modename;
    }
}
class ATM{
    int allmoney;
    int id;
    Mode mode;
    Session ses;
    ATM(int am, int i, int pass){
        this.allmoney = am;
        this.id = i;
        this.mode = new Mode();
        this.ses = new Session(pass);
    }
    void authorization(int pass){
        if (this.mode.getMode().equals("waiting")){
            if (this.ses.authorization(pass)){
                this.mode.setAuthorization();
            }
            else{
                System.out.println("Error");
            }
        }
    }
    void withdrawalMoney(int outmaoney){

        if(this.mode.getMode().equals("authorization") && this.ses.getStatus()){
            this.mode.setPerformance();
            if(this.allmoney >= outmaoney){
                this.allmoney-=outmaoney;
                System.out.println("Снято = "+ outmaoney);
                this.mode.setAuthorization();
            }else{
                this.mode.setBlocking();
                this.ses.end();
                System.out.println("Нехватка денег");
            }
        }else{
            System.out.println("Пользователь не авторезирован");
        }
    }
    void end(){
        this.ses.end();
        this.mode.setWaitng();
    }
}