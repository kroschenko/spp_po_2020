package live.ilyusha.spp4.task2;

public class Main {

    public static void main(String[] args) {
        Symbol a = new Symbol('a');
        Symbol b = new Symbol('b');
        Symbol c = new Symbol('c');

        Word w1 = new Word();
        w1.add(a);
        w1.add(c);
        w1.add(b);

        Word w2 = new Word();
        w2.add(b);
        w2.add(c);

        Word w3 = new Word();
        w3.add(a);
        w3.add(b);
        w3.add(b);

        CustomString s = new CustomString();
        s.add(w1);
        s.add(w2);
        s.add(w3);

        System.out.println(s.toString());
    }

}
