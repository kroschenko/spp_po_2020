import org . junit .*;
import static org . junit . Assert .*;

public class TestStringUtils {
//    Спецификация метода:
//
// 1   keep (null , null ) = NullPointerException
// 2   keep (null , *) = null
// 3   keep ("", *) = ""
// 4   keep (* , null ) = ""
// 5   keep (* , "") = ""
// 6   keep (" hello ", "hl") = " hll "
// 7   keep (" hello ", "le") = " ell "


    @Test (expected = NullPointerException.class )
    public void test1(){
        assertEquals("", StringUtils.keep(null , null ));
    }

    @Test
    public void test2(){
        assertEquals(null,
                StringUtils.keep(null , "*"));
    }

    @Test
    public void test3(){
        assertEquals("", StringUtils.keep("", "*"));
    }

    @Test
    public void test4(){
        assertEquals("", StringUtils.keep("*", null ));
    }

    @Test
    public void test5(){
        assertEquals("", StringUtils.keep("*" , ""));
    }

    @Test
    public void test6(){
        assertEquals(" hll ", StringUtils.keep(" hello ", "hl"));
    }

    @Test
    public void test7(){
        assertEquals(" ell ", StringUtils.keep(" hello ", "le"));
    }
}
