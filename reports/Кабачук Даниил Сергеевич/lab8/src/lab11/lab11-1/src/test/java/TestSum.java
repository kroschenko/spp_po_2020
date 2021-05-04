import org . junit .*; // Импорт всех основных классов и аннотаций JUnit

import java.math.BigInteger;

import static org . junit . Assert .*;

public class TestSum {

    @Test
    public void testSumAccumLong(){

        int arr[] = new int[Integer.MAX_VALUE/5];
        BigInteger sum = BigInteger.ZERO ;
        for (int i=0; i< arr.length;i++) {
            arr[i] = (int) (Integer.MAX_VALUE);
            sum = sum.add(BigInteger.valueOf(arr[i]));
        }
        assertEquals(sum.longValue(), Sum.accumLong(arr));
    }
    @Test
    public void testSumAccum(){

        assertEquals(1+2+3+4+5+6, Sum.accum(1,2,3,4,5,6));
    }

}

