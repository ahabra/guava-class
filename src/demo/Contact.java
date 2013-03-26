package demo;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.ListMultimap;

public class Contact {

  public ListMultimap<PhoneTypeEnum, Phone> phones= ArrayListMultimap.create();
  
  public void addPhone(PhoneTypeEnum type, Phone phone) {
    phones.put(type, phone);
  }
  
  public void addPhone(PhoneTypeEnum type, String phone) {
    addPhone(type,  new Phone(phone) );
  }
  
  public void addPhone(String phone) {
    addPhone(PhoneTypeEnum.HOME,  new Phone(phone) );
  }
  
  public void addPhones(Tuple2<PhoneTypeEnum, Phone>... phones) {
    for (Tuple2<PhoneTypeEnum, Phone> tuple : phones) {
      addPhone(tuple.e1, tuple.e2);
    }
  }
  
}
