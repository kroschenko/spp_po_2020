class Cat extends Pet{
    private String mDocuments;

    public Cat(String name, String mood){
        super(name, mood, "We have the funds.\nWe are not smart enough.");
        this.mDocuments = "Whiskers, paws and tail";
    }

    public void setDocuments(String documents) {
        this.mDocuments = documents;
    }

    public String getDocuments() {
        return this.mDocuments;
    }

    @Override
    public void callPet(){
        System.out.println(this.getVoice() + "\nHi, I'm cat " +
                            this.getName() + ". I'm " + this.getMood() + 
                            "\n" + this.mDocuments + " here are my documents");  
    }
}