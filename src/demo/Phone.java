package demo;

import java.util.List;

import com.google.common.base.Objects;
import com.google.common.base.Splitter;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;

public class Phone {
  public final String areaCode;
  public final String local;
  public final String ext;
  
  public Phone(String areaCode, String local, String ext) {
    this.areaCode= clean(areaCode);
    this.local= clean(local);
    this.ext= clean(ext);
  }
  
  public Phone(String all) {
    all= Strings.nullToEmpty(all).trim();
    Iterable<String> split = Splitter.on('.').trimResults().omitEmptyStrings().split(all);
    List<String> list = ImmutableList.copyOf(split);
    int size= list.size();
    int index=0;
    areaCode= size>1? list.get(index++) : "";
    local= size>0? list.get(index++) : "";
    ext= size>2? list.get(index) : "";
  }
  
  private String clean(String number) {
    return Strings.nullToEmpty(number).trim().toLowerCase();
  }
  
  @Override
  public String toString() {
    StringBuilder sb= new StringBuilder();
    if (!areaCode.isEmpty()) {
      sb.append(areaCode).append(".");
    }
    sb.append(local);
    
    if (!ext.isEmpty()) {
      sb.append(" ext ").append(ext);
    }
    
    return sb.toString();
  }
  
  @Override
  public boolean equals(Object obj) {
    if (obj instanceof Phone) {
      Phone that= (Phone) obj;
      return Objects.equal(this.areaCode, that.areaCode)
          && Objects.equal(this.local, that.local)
          && Objects.equal(this.ext, that.ext);
    }
    return false;
  }
  
  @Override
  public int hashCode() {
    return Objects.hashCode(areaCode, local, ext);
  }
  
  
  
}
