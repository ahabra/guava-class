package demo;

import java.util.List;

import org.junit.Test;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;

import static org.junit.Assert.*;

public class ListsTest {

  @Test public void testLists() {
    List<String> list= Lists.newArrayList("a", "b", "c", "d", "e");
    List<List<String>> parts = Lists.partition(list, 3);
    assertEquals(2, parts.size());
    List<String> ed = Lists.reverse(parts.get(1));
    assertEquals(Lists.newArrayList("e", "d"), ed);
  }
  
  @Test public void testImmutableList() {
    List<Integer> list1= ImmutableList.of(1, 2, 3);
    List<Integer> list2= ImmutableList.<Integer>builder()
      .add(10)
      .add(11, 12)
      .addAll(list1)
      .build();
    
    assertEquals(ImmutableList.of(10, 11, 12, 1, 2, 3), list2);
  }
  
}
