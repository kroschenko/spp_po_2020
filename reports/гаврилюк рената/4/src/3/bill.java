import java.util.Vector;

class Bill{

    public boolean pay(Number number, Vector<Service> services){
        //if(smth.wrong())
        //return false;
        number.payForTalk();
        for(Service service : services){
            if(!service.getIsPaid()){
                service.payForService();
            }
            else {
                System.out.print("Service ");
                System.out.print(service.toString());
                System.out.println(" has been already paid");
            }
        }

        System.out.println("Bill is paid");
        return true;
    }
    
    public boolean payForNumber(Number number){
        if(!number.getIsPaid()){
            number.payForTalk();
            return true;
        }
        else{
            System.out.print("Number ");
            System.out.print(number);
            System.out.println(" has been already paid");
            return false;
        }
    }

    public boolean payForService(Service service){
        if(!service.getIsPaid()){
            service.payForService();
            return true;
        }
        else{
            System.out.print("Service ");
            System.out.print(service.toString());
            System.out.println(" has been already paid");
            return false;
        }
    }

}