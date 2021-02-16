import live.ilyusha.Sum;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SumTest {
    @Test
    public void accum() {
        assertEquals(7, Sum.accum(1, 4, 2));
    }

    @Test
    public void accumLong() {
        assertEquals(Integer.MAX_VALUE + 1L, Sum.accum(Integer.MAX_VALUE, 1));
    }
}
