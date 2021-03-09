abstract class Pet{
    private String mName;
    private String mMood;
    private String mVoice;
    
    public Pet(String name, String mood, String voice){
        this.mName = name;
        this.mMood = mood;
        this.mVoice = voice;
    }

    public void setName(String name){
        this.mName = name;
    }
    
    public void setMood(String mood){
        this.mMood = mood;
    }

    public void setVoice(String voice){
        this.mVoice = voice;
    }

    public String getName(){
        return this.mName;
    }

    public String getMood(){
        return this.mMood;
    }

    public String getVoice(){
        return this.mVoice;
    }

    public abstract void callPet();
}