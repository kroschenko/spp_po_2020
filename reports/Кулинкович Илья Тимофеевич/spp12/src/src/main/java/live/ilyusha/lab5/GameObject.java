package live.ilyusha.lab5;

import java.util.List;

public class GameObject {
    private String userName;
    private List<Integer> numbers;

    public String getUserName() {
        return userName;
    }

    public GameObject setUserName(String userName) {
        this.userName = userName;
        return this;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public GameObject setNumbers(List<Integer> numbers) {
        this.numbers = numbers;
        return this;
    }
}