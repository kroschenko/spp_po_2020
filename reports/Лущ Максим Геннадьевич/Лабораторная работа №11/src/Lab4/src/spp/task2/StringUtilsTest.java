package spp.task2;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static spp.task2.StringUtils.IndexOfDifference;

@RunWith(Parameterized.class)
public class StringUtilsTest
{
    private String first;
    private String second;
    private int excepted;

    public StringUtilsTest(String first, String second, int excepted) {
        this.first = first;
        this.second = second;
        this.excepted = excepted;
    }

    @Parameterized.Parameters(name = "{index}:({0},{1},{2}")
    public static Iterable<Object[]> dataForTest() {
        return Arrays.asList(new Object[][]{
                {"", "", -1},
                {"", "abc ", 0},
                {"abc", "", 0},
                {"abc", "abc", -1},
                {"ab", "abxyz", 2},
                {"abcde", "abxyz", 2},
                {"abcde", "xyz", 0},
        });
    }

    @Test(expected = NullPointerException.class)
    public void IndexOfDifference_When_ValuesNull_Should_ThrowException() throws Exception
    {
        var result = IndexOfDifference(null, null);
    }

    @Test
    public void IndexOfDifference_When_ValuesValid_Should_returnExceptedValue() throws Exception
    {
        var result = IndexOfDifference(first, second);
        assertEquals(result, excepted);
    }
}
