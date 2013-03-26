package demo;

import static org.junit.Assert.*;

import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.google.common.base.Predicate;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Iterables;
import com.google.common.collect.Maps;

public class PredicateTest {

  List<String> names= ImmutableList.of("barack", "georgeW", "bill", "georgeH", "ronald", "jimmy");
  
   
  private List<String> findNamesWithSize(final int maxSize) {
    Predicate<String> shortNames = new Predicate<String>() {
      @Override
      public boolean apply(String input) {
        return input.length() <= maxSize;
      }
    };
    Iterable<String> shorts = Iterables.filter(names, shortNames);
    return ImmutableList.copyOf(shorts);
  }
  
  @Test
  public void testFindNamesWithSize() {
    List<String> found = findNamesWithSize(5);
    List<String> expected= ImmutableList.of("bill", "jimmy");
    assertEquals(expected, found);
  }
  
  Map<String, Integer> presidents= new ImmutableMap.Builder<String, Integer>()
    .put("barack", 2008)
    .put("georgeW", 2000)
    .put("bill", 1992)
    .put("georgeH", 1988)
    .put("ronald", 1980)
    .put("jimmy", 1976)
    .build();

  private Map<String, Integer> findPresidentsBefore(final int year) {
    Predicate<Integer> predicate = new Predicate<Integer>() {
      @Override
      public boolean apply(Integer input) {
        return input <= year;
      }
    };
    return Maps.filterValues(presidents, predicate); // array.map{ #predicate }
  }
  
  @Test
  public void testFindPresidentsBefore() {
    Map<String, Integer> found = findPresidentsBefore(1990);
    Map<String, Integer> expected= ImmutableMap.of(
        "jimmy", 1976,
        "ronald", 1980,
        "georgeH", 1988
      );
    assertEquals(expected, found);
  }
  
  
}
