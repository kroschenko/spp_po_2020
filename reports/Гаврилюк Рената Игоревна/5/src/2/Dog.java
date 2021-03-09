class Dog extends Pet{
    private String mMainOnTheTable;

    public Dog(String name, String mood){
        super(name, mood, "Sharik. I'm a simple dog, not a purebred one.");
        this.mMainOnTheTable = "Bonelet";
    }

    public void setMainOnTheTable(String mainOnTheTable) {
        this.mMainOnTheTable = mainOnTheTable;
    }

    public String getMainOnTheTable() {
        return this.mMainOnTheTable;
    }

    @Override
    public void callPet(){
        System.out.println(this.getVoice() + "\nHi, I'm dog " +
                            this.getName() + ". I'm " + this.getMood() + 
                            "\n-What is main on the table?\n-" + this.mMainOnTheTable);
    }
}