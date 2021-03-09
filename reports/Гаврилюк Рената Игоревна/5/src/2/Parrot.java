class Parrot extends Pet{
    private String mQuote;

    public Parrot(String name, String mood){
        super(name, mood, "Freedom for parrots!\nFre-e-dom for pa-rrots!");
        this.mQuote = "I can do it! I'll prove it!.. I'll prove it!.. \nThey'll find out about me. people will talk about me...";
    }

    public void setQuote(String quote) {
        this.mQuote = quote;
    }

    public String getQuote() {
        return this.mQuote;
    }

    @Override
    public void callPet(){
        System.out.println(this.getVoice() + "\nHi, I'm prodigal parrot " +
                            this.getName() + ". I'm " + this.getMood() + 
                            "\n" + this.mQuote);  
    }
}