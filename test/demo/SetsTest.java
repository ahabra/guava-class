package demo;

import static com.google.common.collect.Lists.newArrayList;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.Set;

import org.junit.Test;

import com.google.common.collect.Sets;

public class SetsTest {

  @Test
  public void testHashset() {
//    Set<Integer> seta= new HashSet<Integer>(Arrays.asList(1, 2, 3));
    Set<Integer> set= Sets.newHashSet(1, 2, 3);
    set = Sets.intersection(set, Sets.newHashSet(5, 6, 7, 3));
    assertEquals(Sets.newHashSet(3), set);
  }

  @Test
  @SuppressWarnings("unchecked")
  public void testCartesianProduct() {

    Set<?> set1= Sets.newHashSet(1, 2, 3);
    Set<?> set2= Sets.newHashSet("a", "b");

    Set<List<Object>> prod = Sets.cartesianProduct(set1, set2);

    assertEquals(6, prod.size());
    assertTrue(prod.contains(newArrayList(1, "a")));
    assertTrue(prod.contains(newArrayList(1, "b")));
    assertTrue(prod.contains(newArrayList(2, "a")));
    assertTrue(prod.contains(newArrayList(2, "b")));
    assertTrue(prod.contains(newArrayList(3, "a")));
    assertTrue(prod.contains(newArrayList(3, "b")));
  }

}
