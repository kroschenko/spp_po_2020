import java.util.Vector;

class Abonent extends User{

    private Number mNumber;
    private Vector<Service> mServices;
    private boolean mIsBlocked;
    private Administrator mAdministrator;
    
    public Abonent(String name, String number, Vector<Service> services, 
                    Administrator administrator) {
        super(name, User.mPosition.ABONENT);
        this.mNumber = new Number(number);
        this.mServices = services;
        this.mAdministrator = administrator;
        this.mIsBlocked = false;
    }

    public boolean isAbonentBlocked(){
        return this.mIsBlocked;
    }
    
    public boolean isNumberPaid(){
        return this.mNumber.getIsPaid();
    }

    public void blockAbonent(){
        this.mIsBlocked = true;
        System.out.print("Abonent ");
        System.out.print(super.getName());
        System.out.println(" is blocked");
    }

    public void unblockAbonent(){
        this.mIsBlocked = false;
        System.out.print("Abonent ");
        System.out.print(super.getName());
        System.out.println(" is unblocked");
    }
    
    public boolean payBill(Bill bill){
        System.out.print("Abonent ");
        System.out.print(super.getName());
        System.out.println(" pays for bill");

        return bill.pay(mNumber, mServices);
    }

    public boolean payForNumber(Bill bill){
        System.out.print("Abonent ");
        System.out.print(super.getName());
        System.out.println(" pays for telephone");
        
        return bill.payForNumber(mNumber);
    }
    
    public boolean payForService(Bill bill, int idService){
        System.out.print("Abonent ");
        System.out.print(super.getName());
        System.out.println(" pays for service");
        
        return bill.payForService(mServices.elementAt(idService));
    }

    public boolean addService(Service service){
        if(!mServices.contains(service)){
            mServices.add(service);
            return true;
        }
        return false;
    }

    public int findService(Service findedService){
        int i = 0;
        for(Service service : this.mServices){
            if(service.getServiceName().equals(findedService.getServiceName())){
                return i;
            }
            ++i;
        }
        return -1;
    }

    public void useService(Service service){
        if(!this.mIsBlocked){
            int id = findService(service);
            if(id != -1){
                this.mServices.elementAt(id).useService();
            }
            else{
                System.out.print("Abonent ");
                System.out.print(super.getName());
                System.out.println(" cann't use service. Service isn't added");
            }
        }
        else{
            System.out.print("Abonent ");
            System.out.print(super.getName());
            System.out.println(" cann't use service, because he is blocked");
        }
    }
    
    public void ring(){
        if(!this.mIsBlocked){
            this.mNumber.ring();
        }
        else{
            System.out.print("Abonent ");
            System.out.print(super.getName());
            System.out.println(" cann't ring, because he is blocked");
        }
    }

    public boolean changeNumber(String number){
        return this.mAdministrator.changeNumber(this, mNumber, number);
    }

    public String getNumber(){
        return this.getNumber();
    }

    public boolean turnOffService(Service service){
        return this.mAdministrator.turnOffService(this, service);
    }

    public boolean turnOnService(Service service){
        return this.mAdministrator.turnOnService(this, service);
    }
    
    public String toString(){
        String user = super.toString();
        user += "\nNumber : " + mNumber.getNumber();
        return user;
    }

}