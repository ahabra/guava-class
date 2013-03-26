package demo;

import com.google.common.base.Objects;

public class Address {
  public String street;
  public String city;
  public String state;
  public String zip;
  
  
  @Override
  public String toString() {
    return Objects.toStringHelper(this)
      .add("street", street)
      .add("city", city)
      .add("state", state)
      .add("zip", zip)
      .toString();
  }
  
}
