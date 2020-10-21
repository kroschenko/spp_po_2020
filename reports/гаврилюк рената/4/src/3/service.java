class Service{

    public enum mService {
        SMS,
        MMS,
        INTERNET
    }

    private mService mServiceName;
    private boolean mIsTurnedOn;
    private boolean mIsPaid;

    public Service(mService serviceName){
        this.mServiceName = serviceName;
        this.mIsTurnedOn = false;
        this.mIsPaid = true;
    }

    public mService getServiceName(){
        return this.mServiceName;
    }

    public void setServiceName(mService serviceName){
        this.mServiceName = serviceName;
    }

    public boolean getIsTurnedOn(){
        return this.mIsTurnedOn;
    }

    public boolean getIsPaid(){
        return this.mIsPaid;
    }

    public void addService(){
        System.out.print("Service ");
        System.out.print(this.toString());
        System.out.println(" added");
        this.mIsTurnedOn = true;
        this.mIsPaid = true;
    }

    public boolean turnOffService(){
        //if(smth.wrong())
        //return false;
        this.mIsTurnedOn = false;
        return true;
    }
    
    public boolean turnOnService(){
        //if(smth.wrong())
        //return false;
        this.mIsTurnedOn = true;
        return true;
    }

    public boolean payForService(){
        if(!this.mIsPaid){
            this.mIsPaid = true;
            System.out.print("Service ");
            System.out.print(this.toString());
            System.out.println(" was paid");
            return true;
        }
        else{
            System.out.print("Service ");
            System.out.print(this.toString());
            System.out.println(" has been already paid");
            return false;
        }
    }

    public void useService(){
        if(this.mIsPaid && this.mIsTurnedOn){
            System.out.print("Service ");
            System.out.print(this.toString());
            System.out.println(" is used. Money is disappearing...");
            this.mIsPaid = false;
        }
        else if(!this.mIsPaid && this.mIsTurnedOn 
                || !this.mIsPaid && !this.mIsTurnedOn){
            System.out.print("Service ");
            System.out.print(this.toString());
            System.out.println(" isn't paid. Service is turned off...");
            this.mIsTurnedOn = false;
        }
        else if(this.mIsPaid && !this.mIsTurnedOn){
            System.out.print("Service ");
            System.out.print(this.toString());
            System.out.println(" isn't turned on");
        }
    }

    public String toString(){
        String serviceString = new String();
        if(this.mServiceName == this.mServiceName.SMS){
            serviceString = "SMS";
        }
        else if(this.mServiceName == this.mServiceName.MMS){
            serviceString = "MMS";
        }
        else if(this.mServiceName == this.mServiceName.INTERNET){
            serviceString = "INTERNET";
        }
        return serviceString;
    }

}