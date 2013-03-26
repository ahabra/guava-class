package demo;

import static org.junit.Assert.*;

import org.junit.Test;
import static demo.PhoneTypeEnum.*;


public class ContactTest {

  @Test
  public void testAddPhone() {
    Contact contact= new Contact();
    contact.addPhone("7654321");
    assertEquals("7654321", contact.phones.get(HOME).get(0).toString());
  }

  @Test
  public void testAddPhones() {
    Contact contact= new Contact();
    contact.addPhone(HOME, "777-1111");
    contact.addPhone(MOBILE, "666-1111");
    contact.addPhone(MOBILE, "666-1112");
    
    assertEquals("777-1111", contact.phones.get(HOME).get(0).toString());
    assertEquals("666-1111", contact.phones.get(MOBILE).get(0).toString());
    assertEquals("666-1112", contact.phones.get(MOBILE).get(1).toString());
  }

}
