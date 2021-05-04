package spp.task2;

public class StringUtils
{
    public static int IndexOfDifference(String first, String second) throws Exception
    {
        if (first == null)
        {
            throw new NullPointerException("Argument first must be not null");
        }

        if (second == null)
        {
            throw new NullPointerException("Argument second must be not null");
        }

        int j = 0;
        for (int i = 0; i < first.length() && i < second.length(); i++)
        {
            if (first.charAt(i) != second.charAt(i))
            {
                return i;
            }
            j++;
        }

        if (j < first.length() || j < second.length())
        {
            return j;
        }

        return -1;
    }
}
