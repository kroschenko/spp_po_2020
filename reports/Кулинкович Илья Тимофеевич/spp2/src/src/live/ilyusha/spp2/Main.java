package live.ilyusha.spp2;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.io.File;
import java.io.IOException;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) throws IOException {
        System.out.printf("task1 = %s\n", Arrays.toString(task1("text.txt", "test")));
        System.out.println("task2");
        
        try {
            Supplier<Stream<String>> lines;
            long skip;
            if (args.length == 1) {
                lines = linesSupplierFactory(Paths.get(args[0]));
                skip = lines.get().count();
            } else if (args.length == 2) {
                lines = linesSupplierFactory(Paths.get(args[1]));
                skip = Long.parseLong(args[0]);
            } else if (args.length == 3 && "-n".equals(args[0])) {
                lines = linesSupplierFactory(Paths.get(args[2]));
                skip = Long.parseLong(args[1]);
            } else if (args.length == 3 && "-n".equals(args[1])) {
                lines = linesSupplierFactory(Paths.get(args[0]));
                skip = Long.parseLong(args[2]);
            } else {
                throw new Exception("Invalid arguments");
            }
            lines.get().skip(lines.get().count() - skip).forEach(System.out::println);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static Supplier<Stream<String>> linesSupplierFactory(Path path) throws Exception {
        return () -> {
            try {
                return Files.lines(path);
            } catch (IOException e) {
                return Stream.empty();
            }
        };
    }

    private static String[] task1(String resource, String baseWord) throws IOException {
        String text = new Scanner(new File("resources/" + resource)).useDelimiter("\\Z").next();
        LinkedList<String> words = new LinkedList<String>(Arrays.asList(text.toString().split("[^A-Za-zА-Яа-я0-9]")));
        words.removeAll(Collections.singleton(""));

        ArrayList<String> result = new ArrayList<>();

        for (String word : words) {
            int lineLength = Math.min(word.length() / 2, baseWord.length());
            if (baseWord.substring(0, lineLength).equals(word.toLowerCase().substring(0, lineLength)) && word.length() > 2) {
                result.add(word);
            }
        }

        return result.toArray(new String[0]);
    }
}
