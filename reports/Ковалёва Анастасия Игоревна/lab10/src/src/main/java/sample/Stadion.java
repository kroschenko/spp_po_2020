package sample;

public class Stadion {
    int id;
    String stadion_name;
    String stadion_size;

    public Stadion(String stadion_name, String stadion_size) {
        this.id = id;
        this.stadion_name = stadion_name;
        this.stadion_size = stadion_size;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStadion_name() {
        return stadion_name;
    }

    public void setStadion_name(String stadion_name) {
        this.stadion_name = stadion_name;
    }

    public String getStadion_size() {
        return stadion_size;
    }

    public void setStadion_size(String stadion_size) {
        this.stadion_size = stadion_size;
    }
}
