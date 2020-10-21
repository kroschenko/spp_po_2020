class Flat{
    private int mFloor;
    private int mNumRooms;
    private Double mArea;
    private Double mPrice;
    private String mAddress;
    private boolean mIsForRent;

    public Flat(int floor, int numRooms, Double area, Double price, String address, boolean isForRent){
        this.setAddress(address);
        this.setArea(area);
        this.setFloor(floor);
        this.setIsRented(isForRent);
        this.setNumRooms(numRooms);
        this.setPrice(price);
    }

    public void setFloor(int floor){
        this.mFloor = floor;
    }

    public void setNumRooms(int numRooms){
        this.mNumRooms = numRooms;

    }

    public void setArea(Double area){
        this.mArea = area;
    }

    public void setPrice(Double price){
        this.mPrice = price;
    }

    public void setAddress(String address){
        this.mAddress = address;
    }

    public void setIsRented(Boolean isForRent){
        this.mIsForRent = isForRent;
    }
    
    public int getFloor(){
        return this.mFloor;
    }

    public int getNumRooms(){
        return this.mNumRooms;
    }

    public Double getArea(){
        return this.mArea ;
    }

    public Double getPrice(){
        return this.mPrice;
    }

    public String getAddress(){
        return this.mAddress;
    }

    public Boolean getIsForRent(){
        return this.mIsForRent;
    }

    public void printFlat(){
        System.out.println("---------------------");
        System.out.print("Address: ");
        System.out.println(mAddress);
        System.out.print("Number of rooms:");
        System.out.println(mNumRooms);
        System.out.print("Area: ");
        System.out.println(mArea);
        System.out.print("Floor: ");
        System.out.println(mFloor);
        System.out.print("Price: ");
        System.out.println(mPrice);
        System.out.print("IsForRent: ");
        System.out.println(mIsForRent);
        System.out.println();
    }

    public boolean equals(Flat fl){
        if(this.mFloor == fl.mFloor &&
        this.mNumRooms == fl.mNumRooms &&
        this.mArea.equals(fl.mArea) &&
        this.mPrice.equals(fl.mPrice) &&
        this.mAddress.equals(fl.mAddress) &&
        this.mIsForRent == fl.mIsForRent){
            return true;
        }
        return false;
    }
}