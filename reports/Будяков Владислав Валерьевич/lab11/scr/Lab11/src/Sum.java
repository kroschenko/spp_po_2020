public class Sum {
    public static Integer accum(Integer... values) { int result = 0;
        for (int value : values) {
            result += value;
        }
        return result;
    }
}