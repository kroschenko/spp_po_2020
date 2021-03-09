abstract class SamsungMobile implements IMobile {

    private String mName;
    private int mPrice;

    public SamsungMobile(String name, int price){
        this.mName = name;
        this.mPrice = price;
    }

    public void setName(String name) {
        this.mName = name;
    }

    public void setPrice(int price) {
        this.mPrice = price;
    }

    @Override
    public String getName(){
        return this.mName;
    }

    @Override
    public int getPrice(){
        return this.mPrice;
    }
}