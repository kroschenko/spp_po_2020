package live.ilyusha.spp4.task2;

import java.util.ArrayList;
import java.util.stream.Collectors;

class Word {

    private ArrayList<Symbol> chars = new ArrayList<>();

    void add(Symbol symbol) {
        chars.add(symbol);
    }

    @Override
    public String toString() {
        return chars.stream().map(x -> String.valueOf(x.getValue())).collect(Collectors.joining(""));
    }

}
