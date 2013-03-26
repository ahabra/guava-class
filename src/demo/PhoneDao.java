package demo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.google.common.base.Function;
import com.google.common.collect.Lists;

public class PhoneDao {


  private static class PhoneSaver implements Function<Connection, Integer> {
    private Phone phone;

    PhoneSaver(Phone phone) {
      this.phone= phone;
    }

    @Override
    public Integer apply(Connection con) {
      String sql= "insert into phone values(" + phone.toString() + ")";
      try {
        return con.createStatement().executeUpdate(sql);
      } catch (SQLException e) {
        // error handling
      }
      return -1;
    }
  }

  public int save(Phone phone) {
    PhoneSaver phoneSaver= new PhoneSaver(phone);
    return WithConnection.execute(phoneSaver);
  }


  private static class PhoneReader implements Function<Connection, List<Phone>> {

    @Override
    public List<Phone> apply(Connection con) {
      String sql= "select * from phone";
      List<Phone> list= Lists.newArrayList();
      try {
        ResultSet rs = con.createStatement().executeQuery(sql);
        while(rs.next()) {
          list.add( new Phone(rs.getString(0)) );
        }
      } catch (SQLException e) {
        e.printStackTrace();
      }
      return list;
    }

  }

  public List<Phone> readAll() {
    PhoneReader reader= new PhoneReader();
    return WithConnection.execute(reader);
  }


}
