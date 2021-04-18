package spp.task1;

public class Sum {
    public static int Accum(int... values)
    {
        int result = 0;
        for (int i = 0; i < values.length; i++)
        {
            result += values[i];
        }
        return result;
    }

    public static long AccumLong(int... values)
    {
        long result = 0;
        for (int i = 0; i < values.length; i++)
        {
            result += values[i];
        }

        return result;
    }
}