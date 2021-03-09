package live.ilyusha.lab5;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;

@Service
public class GameService {
    private final Random random;
    private List<Integer> numbers;

    @Autowired
    public GameService() {
        this.random = new Random();
    }

    public List<Integer> getNumbers() {
        if (Objects.isNull(numbers)) {
            generateNumbers();
        }
        return numbers;
    }

    public void setNumbers(final List<Integer> numbers) {
        this.numbers = numbers;
    }

    public void generateNumbers() {
        this.numbers = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            this.numbers.add(random.nextInt(10));
        }
    }
}