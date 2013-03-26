package demo;

import static org.junit.Assert.*;

import org.junit.Test;

public class PhoneTest {

  @Test
  public void willCleanParams() {
    Phone phone= new Phone(null, "7654321", " X12 ");
    assertEquals("", phone.areaCode);
    assertEquals("7654321", phone.local);
    assertEquals("x12", phone.ext);
  }

  @Test
  public void constructorWillSplit() {
    assertEquals("513.7654321 ext 99", new Phone("513.7654321.99").toString());
    assertEquals("513.7654321", new Phone("513.7654321").toString());
    assertEquals("7654321", new Phone("7654321").toString());
    assertEquals("", new Phone(null).toString());
    assertEquals("", new Phone("  ").toString());
  }
  
  @Test
  public void testToString() {
    assertEquals("513.7654321 ext 99", new Phone("513", "7654321", "99").toString());
  }

  @Test
  public void testEquals() {
    Phone phone1 = new Phone("513", "7654321", "99");
    Phone phone2 = new Phone("513", "7654321", "99");
    assertEquals(phone1, phone2);
  }
  
  @Test
  public void testHashCode() {
    Phone phone1 = new Phone("513", "7654321", "99");
    Phone phone2 = new Phone("513", "7654321", "99");
    Phone phone3 = new Phone("513", "7654321", "");
    assertEquals(phone1.hashCode(), phone1.hashCode());
    assertEquals(phone1.hashCode(), phone2.hashCode());
    assertFalse(phone1.hashCode() == phone3.hashCode() );
  }
  
  
}
