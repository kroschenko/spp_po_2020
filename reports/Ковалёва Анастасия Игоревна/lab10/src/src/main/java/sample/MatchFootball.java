package sample;

public class MatchFootball {

    int id;
    String match_name, comand, referee, stadion, stadion_size;

    public MatchFootball(int id, String match_name, String comand, String referee, String stadion, String stadion_size) {
        this.id = id;
        this.match_name = match_name;
        this.comand = comand;
        this.referee = referee;
        this.stadion = stadion;
        this.stadion_size = stadion_size;
    }

    public MatchFootball(int id, String match_name, String comand, String referee, String stadion) {
        this.id = id;
        this.match_name = match_name;
        this.comand = comand;
        this.referee = referee;
        this.stadion = stadion;
    }

    @Override
    public String toString() {
        return "MatchFootball{" +
                "id=" + id +
                ", match_name='" + match_name + '\'' +
                ", comand='" + comand + '\'' +
                ", referee='" + referee + '\'' +
                ", stadion=" + stadion +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMatch_name() {
        return match_name;
    }

    public void setMatch_name(String match_name) {
        this.match_name = match_name;
    }

    public String getComand() {
        return comand;
    }

    public void setComand(String comand) {
        this.comand = comand;
    }

    public String getReferee() {
        return referee;
    }

    public void setReferee(String referee) {
        this.referee = referee;
    }

    public String getStadion() {
        return stadion;
    }

    public void setStadion(String stadion) {
        this.stadion = stadion;
    }

    public String getStadion_size() {
        return stadion_size;
    }

    public void setStadion_size(String stadion_size) {
        this.stadion_size = stadion_size;
    }
}
