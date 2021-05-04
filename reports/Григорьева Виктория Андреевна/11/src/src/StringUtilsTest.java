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
        assertNull(StringUtils.loose(null, "yum"));
        assertEquals("", StringUtils.loose("", "yumm"));
        assertEquals("yummy", StringUtils.loose("yummy", null));
        assertEquals("yummy", StringUtils.loose("yummy", ""));
        assertEquals("eo", StringUtils.loose("lesson", "lsn"));
        assertEquals("on", StringUtils.loose("lesson", "les"));
    }
}