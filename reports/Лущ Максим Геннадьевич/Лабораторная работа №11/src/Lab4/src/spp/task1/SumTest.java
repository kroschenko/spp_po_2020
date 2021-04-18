package spp.task1;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;
import static spp.task1.Sum.Accum;
import static spp.task1.Sum.AccumLong;

public class SumTest
{
    @Test
    public void Accum_When_ValuesValid_Should_ReturnExceptedValue()
    {
        var result = Accum(1, 2, 5);
        assertEquals(result, 8);
    }

    @Test
    public void Accum_When_ValuesInvalid_Should_ReturnExceptedValue()
    {
        var result = Accum(Integer.MAX_VALUE, 12, 5);
        assertEquals(result, Integer.MIN_VALUE + 12 + 5 - 1);
    }

    @Test
    public void AccumLong_When_ValuesValid_Should_ReturnExceptedValue()
    {
        var result = AccumLong(1, 2, 5);
        assertEquals(result, 8);
    }

    @Test
    public void AccumLong_When_ValuesInvalid_Should_ReturnExceptedValue()
    {
        var result = AccumLong(Integer.MAX_VALUE, 12, 5);
        assertEquals(result, (long) (Integer.MAX_VALUE) + (long) 12 + (long) 5);
    }
}
