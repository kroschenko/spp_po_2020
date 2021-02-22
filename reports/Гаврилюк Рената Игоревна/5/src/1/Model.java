class Model extends SamsungMobile {

    private String mBatchNumber;

    public Model(String name, int price, String batchNumber){
        super(name, price);
        this.mBatchNumber = batchNumber;
    }

    public void setBranchNumber(String batchNumber){
        this.mBatchNumber = batchNumber;
    }

    public String getBachNumber(){
        return this.mBatchNumber;
    }

    @Override
    public void print(){
        System.out.println("Samsung Mobile " + this.getName() +
                            " with batch number " + this.mBatchNumber +
                            " costs " + this.getPrice());
    }

}