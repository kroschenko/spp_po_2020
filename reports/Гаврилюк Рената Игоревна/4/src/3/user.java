class User{
    
    private String mName;
    private mPosition mPos;

    public enum mPosition{
        ABONENT,
        ADMINISTRATOR
    }

    public User(String name, mPosition position){
        this.mName = name;
        this.mPos = position;
    }

    public String getName(){
        return this.mName;
    }

    public void setName(String name){
        this.mName = name;
    }

    public mPosition getPosition(){
        return this.mPos;
    }

    public void setPosition(mPosition position){
        this.mPos = position;
    }

    public String toString(){
        String user = "Name : " + this.mName;
        if(this.mPos == this.mPos.ABONENT){
            user += "\nPosition : abonent";
        }
        else if(this.mPos == this.mPos.ADMINISTRATOR){
            user += "\nPosition : administrator";
        }
        return user;
    }

}