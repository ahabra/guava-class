package demo;

import static org.junit.Assert.*;

import org.junit.Test;

import com.google.common.hash.HashCode;
import com.google.common.hash.HashFunction;
import com.google.common.hash.Hashing;

public class HashTest {

  @Test
  public void testMD5() {
    HashFunction hashFunction = Hashing.md5();
    byte[] bytes= {1, 2, 3};

    HashCode hashCode = hashFunction.hashBytes(bytes);
    System.out.println("md5: " + hashCode.toString());
    assertEquals(hashCode.asBytes().length, 16);

    hashCode= hashFunction.hashString("hello world blah blah blah blah");
    System.out.println("md5: " + hashCode.toString());
    assertEquals(16, hashCode.asBytes().length);
    assertEquals("668e62e1dc6128ab8cd8c2a3c3f3f94b", hashCode.toString());
  }

  @Test
  public void testSha256() {
    HashFunction hashFunction = Hashing.sha256();
    byte[] bytes= {1, 2, 3};

    HashCode hashCode = hashFunction.hashBytes(bytes);
    System.out.println("sha256: " + hashCode.toString());
    assertEquals(32, hashCode.asBytes().length);

    hashCode= hashFunction.hashString("hello world blah blah blah blah");
    System.out.println("sha256: " +hashCode.toString());
    assertEquals(32, hashCode.asBytes().length);
    assertEquals("7e36e57f702bac0427ab4aeb06211a485134199b8c1e7c2b28a15331aeea1b09", hashCode.toString());
  }

  @Test
  public void testGoodFastHash() {
    int minimumBits=8;
    HashFunction hashFunction = Hashing.goodFastHash(minimumBits);
    byte[] bytes= {1, 2, 3};

    HashCode hashCode1 = hashFunction.hashBytes(bytes);
    HashCode hashCode2 = hashFunction.hashBytes(bytes);
    System.out.println("gfh: " + hashCode1.toString());
    assertEquals(4, hashCode1.asBytes().length);

    hashCode1= hashFunction.hashString("hello world blah blah blah blah");
    hashCode2= hashFunction.hashString("hello world blah blah blah blah");
    System.out.println("gfh: " + hashCode1.toString());
    assertEquals(4, hashCode1.asBytes().length);
    assertEquals(hashCode1.toString(), hashCode2.toString());

    // assertEquals("3c943000", hashCode.toString()); code changes per run !!
  }

}
