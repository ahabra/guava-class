package demo;

import static org.junit.Assert.*;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

import org.junit.Test;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;

public class CacheTest {

  static class FatAndBadObject {
    String key;
    public FatAndBadObject(String key) {
      this.key= key;
      System.out.println("Creating FatAndBadObject(" + key + ")");
    }
  }

  @Test
  public void test() throws ExecutionException {
    LoadingCache<String, FatAndBadObject> fatAndBadCache = CacheBuilder.newBuilder()
        .maximumSize(1000)
        .expireAfterWrite(1, TimeUnit.HOURS)
        .build(
            new CacheLoader<String, FatAndBadObject>() {
              @Override
              public FatAndBadObject load(String key) throws Exception {
                return new FatAndBadObject(key);
              }

            });

    assertEquals(0, fatAndBadCache.size());
    FatAndBadObject fatAndBadObject = fatAndBadCache.get("key1");
    assertEquals("key1", fatAndBadObject.key);
    assertEquals(1, fatAndBadCache.size());

    fatAndBadObject = fatAndBadCache.get("key2");
    assertEquals("key2", fatAndBadObject.key);
    assertEquals(2, fatAndBadCache.size());

    fatAndBadObject = fatAndBadCache.get("key1");
    assertEquals("key1", fatAndBadObject.key);
    assertEquals(2, fatAndBadCache.size());

  }

}
