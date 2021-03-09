class Number{
    
    private String mNumber;
    private boolean mIsPaid;

    public Number(String number){
        this.mNumber = number;
        this.mIsPaid = true;
    }

    public void setNumber(String number){
        this.mNumber = number;
    }

    public String getNumber(){
        return this.mNumber;
    }
    
    public boolean getIsPaid(){
        return this.mIsPaid;
    }

    public boolean changeNumber(String number){
        //if(smth.wrong())
        //return false;

        System.out.print("Number ");
        System.out.print(this.mNumber);
        System.out.print(" was changed to ");
        System.out.println(number);
        this.setNumber(number);
        return true;
    }

    public boolean payForTalk(){
        if(!this.mIsPaid){
            this.mIsPaid = true;
            System.out.print("Number ");
            System.out.print(this.mNumber);
            System.out.println(" was paid");
            return true;
        }
        else {
            System.out.print("Number ");
            System.out.print(this.mNumber);
            System.out.println(" has been already paid");
            return false;
        }
    }

    public void ring(){
        if(this.mIsPaid){
            System.out.print("Number ");
            System.out.print(this.mNumber);
            System.out.println(" is ringing. Money is disappearing...");
            this.mIsPaid = false;
        }
        else{
            
            System.out.print("Number ");
            System.out.print(this.mNumber);
            System.out.println(" isn't paid");
        }
    }

}