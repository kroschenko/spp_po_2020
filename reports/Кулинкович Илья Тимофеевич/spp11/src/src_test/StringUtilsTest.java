import live.ilyusha.StringUtils;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class StringUtilsTest {
    @Test(expected = NullPointerException.class)
    public void looseByNullRemove() {
        assertEquals("", StringUtils.loose(null, null));
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