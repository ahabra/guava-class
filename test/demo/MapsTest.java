package demo;

import static org.junit.Assert.assertEquals;

import java.util.Map;

import org.junit.Test;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Multimap;

public class MapsTest {

  @Test public void testMap() {
    //Map<Integer, String> map = new HashMap<Integer, String>();
    Map<Integer, String> map = Maps.newHashMap();
    map.put(1, "a");
  }

  @Test public void testMultimap() {
    Multimap<Integer, String> map= ArrayListMultimap.create();
    map.put(1, "a");
    map.put(2, "b");
    map.put(1, "c");
    assertEquals(Lists.newArrayList("a", "c"), map.get(1));
    assertEquals(Lists.newArrayList("b"), map.get(2));
  }

  @Test(expected=UnsupportedOperationException.class)
  public void testImmutableMap() {
    Map<Integer, String> map1= ImmutableMap.of(1, "a", 2, "b");
    Map<Integer, String> map2= new ImmutableMap.Builder<Integer, String>()
      .put(3, "c")
      .put(4, "d")
      .putAll(map1)
      .build();
    assertEquals(4, map2.size());
    map2.put(10, "x");
  }

}
