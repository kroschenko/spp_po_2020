package live.ilyusha.spp1;

import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        Supplier<DoubleStream> argInts = () -> Stream.of(args).map(Double::parseDouble).mapToDouble(Double::doubleValue);

        /* average */
        double average = argInts.get().sum() / argInts.get().count();
        System.out.printf("average = %f\n", average);

        /* variance */
        double variance = argInts.get().map(i -> Math.pow(i - average, 2)).sum() / argInts.get().count();
        System.out.printf("variance = %f\n", variance);

        /* reverse */
        System.out.printf("reversed = %s\n", Arrays.toString(reverse(argInts.get().boxed().toArray())));

        /* palindrome */
        String testString = "А лис, он умен – крыса сыр к нему носила.";
        System.out.printf("palindrome = %s\n", palindrome(testString));
    }

    private static<T> T[] reverse(T @NotNull [] array) {
        for (int i = 0; i < array.length / 2; i++) {
            T temp = array[i];
            array[i] = array[array.length - i - 1];
            array[array.length - i - 1] = temp;
        }
        return array;
    }

    private static boolean palindrome(String str) {
        String fixed = str.replaceAll("[^A-Za-zА-Яа-я0-9]", "").toLowerCase();
        Character[] chars = fixed.chars().mapToObj(c -> (char)c).toArray(Character[]::new);
        String reversed = Arrays.stream(reverse(chars)).map(Object::toString).collect(Collectors.joining());
        return reversed.equals(fixed);
    }

}
