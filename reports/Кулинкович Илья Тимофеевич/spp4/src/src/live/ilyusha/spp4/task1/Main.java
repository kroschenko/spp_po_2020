package live.ilyusha.spp4.task1;

public class Main {

    public static void main(String[] args) {
        GradeBook book = new GradeBook("Kulinkovich I. T.");
        book.add("Math", "Gladky", 4);
        book.add("YaP", "Oskar", 10);
        book.add("OSISP", "Kroschenko", 10);
        book.log();
    }

}
