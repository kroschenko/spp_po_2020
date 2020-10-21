package live.ilyusha.spp4.task2;

import java.util.ArrayList;
import java.util.stream.Collectors;

class CustomString {

    private final ArrayList<Word> words = new ArrayList<>();

    void add(Word word) {
        words.add(word);
    }

    @Override
    public String toString() {
        return words.stream().map(Word::toString).collect(Collectors.joining(" "));
    }

}

