import java.util.Vector;

class Administrator extends User{

    private Vector<Abonent> mAbonents;

    public Administrator(String name) {
        super(name, User.mPosition.ADMINISTRATOR);
        mAbonents = new Vector<>();
    }

    public Vector<Abonent> getAbonents(){
        return this.mAbonents;
    }

    public int findAbonent(Abonent findedAbonent){
        int i = 0;
        for(Abonent abonent : this.mAbonents){
            if(abonent.getName().equals(findedAbonent.getName())){
                return i;
            }
            ++i;
        }
        return -1;
    }

    public boolean addAbonent(Abonent abonent){
        if(this.findAbonent(abonent) == -1){
            this.mAbonents.add(abonent);
            System.out.print("Abonent ");
            System.out.print(abonent.getName());
            System.out.print(" added to administrator ");
            System.out.println(this.getName());
            return true;
        }
        else {
            System.out.print("Abonent ");
            System.out.print(abonent.getName());
            System.out.print(" has been already added to administrator ");
            System.out.println(this.getName());
            return false;
        }
    }

    public boolean deleteAbonent(Abonent abonent, String number){
        int index = this.findAbonent(abonent);
        if(index != -1){
            this.mAbonents.remove(index);
            System.out.print("Abonent ");
            System.out.print(abonent.getName());
            System.out.print(" was removed from administrator ");
            System.out.println(this.getName());
            return true;
        }
        else {
            System.out.print("Abonent ");
            System.out.print(abonent.getName());
            System.out.print(" isn't controlled by administrator ");
            System.out.println(this.getName());
            return false;
        }
    }  

    public boolean changeNumber(Abonent abonent, Number number, String newNumber){
        int index = this.findAbonent(abonent);
        if(index != -1){
            number.setNumber(newNumber);
            System.out.print("New number of abonent ");
            System.out.print(abonent.getName());
            System.out.print(" is ");
            System.out.println(newNumber);
            return true;
        }
        else {
            System.out.print("Abonent ");
            System.out.print(abonent.getName());
            System.out.print(" isn't controlled by administrator ");
            System.out.println(this.getName());
            return false;
        }
    }

    public boolean blockAbonent(Abonent abonent){
        int index = this.findAbonent(abonent);
        if(index != -1){
            if(!this.mAbonents.elementAt(index).isNumberPaid()){
                this.mAbonents.elementAt(index).blockAbonent();
                return true;
            }
            else{
                System.out.print("Abonent ");
                System.out.print(abonent.getName());
                System.out.println(" isn't blocked. Number is paid");
            }
        }
        else {
            System.out.print("Abonent ");
            System.out.print(abonent.getName());
            System.out.print(" isn't controlled by administrator ");
            System.out.println(this.getName());
        }
        return false;
    }
    
    public boolean unblockAbonent(Abonent abonent){
        int index = this.findAbonent(abonent);
        if(index != -1){
            if(this.mAbonents.elementAt(index).isNumberPaid()){
                this.mAbonents.elementAt(index).unblockAbonent();
                return true;
            }
            else{
                System.out.print("Abonent ");
                System.out.print(abonent.getName());
                System.out.println(" isn't unblocked. Number isn't paid");
            }
        }
        else {
            System.out.print("Abonent ");
            System.out.print(abonent.getName());
            System.out.print(" isn't controlled by administrator ");
            System.out.println(this.getName());
        }
        return false;
    }

    public boolean turnOffService(Abonent abonent, Service service){
        int index = this.findAbonent(abonent);
        if(index != -1){
            if(this.mAbonents.elementAt(index).findService(service) != -1){
                service.turnOffService();
                System.out.print("Service ");
                System.out.print(service.getServiceName());
                System.out.print(" was turned off for abonent ");
                System.out.println(abonent.getName());
                return true;
            }
            else{
                System.out.print("Abonent ");
                System.out.print(abonent.getName());
                System.out.print(" hasn't got service ");
                System.out.println(service.getServiceName());
            }
        }
        else {
            System.out.print("Abonent ");
            System.out.print(abonent.getName());
            System.out.print(" isn't controlled by administrator ");
            System.out.println(this.getName());
        }
        return false;
    }
    
    public boolean turnOnService(Abonent abonent, Service service){
        int index = this.findAbonent(abonent);
        if(index != -1){
            if(this.mAbonents.elementAt(index).findService(service) != -1){
                service.turnOnService();
                System.out.print("Service ");
                System.out.print(service.getServiceName());
                System.out.print(" was turned on for abonent ");
                System.out.println(abonent.getName());
                return true;
            }
            else{
                System.out.print("Abonent ");
                System.out.print(abonent.getName());
                System.out.print(" hasn't got service ");
                System.out.println(service.getServiceName());
            }
        }
        else {
            System.out.print("Abonent ");
            System.out.print(abonent.getName());
            System.out.print(" isn't controlled by administrator ");
            System.out.println(this.getName());
        }
        return false;
    }
}