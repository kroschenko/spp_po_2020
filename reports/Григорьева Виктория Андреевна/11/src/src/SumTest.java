import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SumTest {
    @Test
    public void accumSuccess() {
        Integer accum = Sum.accum(1, 2, 3, 5);
        assertNotNull(accum);
        assertEquals(Integer.valueOf(11), accum); }

    @Test
    public void accumByIncorrectParam() throws NullPointerException {
        Throwable thrown = assertThrows(NullPointerException.class, () -> {
            Integer accum = Sum.accum(null, 2, 3, 5);
        });
        assertEquals(thrown.getClass(), NullPointerException.class);
    }
}