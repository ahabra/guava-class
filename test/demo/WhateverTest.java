package demo;

import static org.junit.Assert.assertEquals;

import java.util.List;
import java.util.Set;

import org.junit.Test;

import com.google.common.base.Joiner;
import com.google.common.base.Preconditions;
import com.google.common.base.Splitter;
import com.google.common.base.Throwables;
import com.google.common.collect.Sets;

public class WhateverTest {

  @Test public void splitJoin() {
    String text = "a,b,,c, d, e ";
    Iterable<String> split = Splitter.on(",").omitEmptyStrings().trimResults().split(text);
    String joined = Joiner.on(".").join(split);
    assertEquals("a.b.c.d.e", joined);
  }
  
  @Test(expected=RuntimeException.class) 
  public void throwables() {
    try {
      throw new Exception();
    } catch (Exception e) {
      throw Throwables.propagate(e);
    }
  }
  
  private int field=-1;
  
  void pre(int age, String name) {
    Preconditions.checkArgument(age>0 && age<120, "Invalid age");
    Preconditions.checkNotNull(name, "name must have a value");
    Preconditions.checkState(field>0);
    
    // now do whatever
  }
  
  @Test(expected=IllegalArgumentException.class)
  public void testPreconditions() {
    pre(-2, "abdul");
  }
  
  
  @SuppressWarnings("unchecked")
  @Test 
  public void testSets() {
    Set<Integer> set1= Sets.newHashSet(1, 2);
    Set<Integer> set2= Sets.newHashSet(3, 4);
    Set<List<Integer>> cp = Sets.cartesianProduct(set1, set2);
    System.out.println(cp);
  }
  
}
