package demo;

import static org.junit.Assert.assertEquals;

import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.google.common.base.Function;
import com.google.common.base.Joiner;
import com.google.common.base.Splitter;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

public class FunctionTest {

  private static final List<String> NAMES=
      ImmutableList.of("barack", "georgeW", "bill", "georgeH", "ronald", "jimmy");

  private List<Integer> findLength() {
    Function<String, Integer> lengthFinder = new Function<String, Integer>() {
      @Override
      public Integer apply(String input) {
        return input.length();
      }
    };

    return Lists.transform(NAMES, lengthFinder);
  }


  @Test public void testFindLength() {
    List<Integer> lengths = findLength();
    List<Integer> expected= ImmutableList.of(6, 7, 4, 7, 6, 5);
    assertEquals(expected, lengths);
  }


  private static final Map<String, String> CAREERS=
        new ImmutableMap.Builder<String, String>()
    .put("Jimmy", "peanuts,submarines")
    .put("Ronald", "acting")
    .put("GeorgeH", "spy,oil")
    .put("Bill", "jennifer, paula,Elizabeth,Sally,Dolly,Hillary")
    .put("GeorgeW", "sop")
    .put("Barack", "law, teaching")
    .build();

  private Map<String, String> buildCareers() {
    Function<String, String> function= new Function<String, String>() {
      @Override public String apply(String input) {
        Iterable<String> splitted = Splitter.on(",").trimResults().split(input);
        return Joiner.on(" and ").join(splitted) + " before becoming president";
      }
    };

    return Maps.transformValues(CAREERS, function);
  }

  @Test public void testBuildCareers() {
    Map<String, String> map = buildCareers();
    assertEquals("peanuts and submarines before becoming president", map.get("Jimmy"));
    assertEquals("acting before becoming president", map.get("Ronald"));

    String text = Joiner.on("\n").withKeyValueSeparator(" did ").join(map); // flatten map

    System.out.println( text );
  }

}
