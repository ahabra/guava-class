package demo;

import java.util.List;

import org.junit.Test;
import static org.junit.Assert.*;

import com.google.common.collect.Lists;
import com.google.common.primitives.Ints;

public class IntsTest {

  @Test public void testInts() {
    int[] a= {1, 2};
    int[] b= {3, 4};
    int[] con = Ints.concat(a, b);
    int[] expected= {1, 2, 3, 4};
    assertArrayEquals(expected, con);
    assertFalse( Ints.contains(con, 10) );
    assertEquals(2, Ints.indexOf(con, 3));
    assertEquals(2, Ints.lastIndexOf(con, 3));

    assertEquals(9, Ints.max(1, 4, -1, 9, 3));
    assertEquals(-1, Ints.min(1, 4, -1, 9, 3));

    List<Integer> list= Lists.newArrayList(1, 2, 3, 4);
    int[] arr= Ints.toArray(list);
    assertArrayEquals(expected, arr);
  }

}
