import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class StringUtilsTest {
    @Test
    public void looseByNullRemove() throws NullPointerException {
        Throwable thrown = assertThrows(NullPointerException.class, () -> {
            StringUtils.loose(null, null);
        });
        assertEquals(thrown.getClass(), NullPointerException.class);
    }
    @Test
    public void looseSuccess() {
        assertNull(StringUtils.loose(null, "any"));
        assertEquals("", StringUtils.loose("", "anyystr"));
        assertEquals("anyyyy", StringUtils.loose("anyyyy", null));
        assertEquals("anyyyy", StringUtils.loose("anyyyy", ""));
        assertEquals("eo", StringUtils.loose("hello", "hl"));
        assertEquals("ho", StringUtils.loose("hello", "le"));
    }
}