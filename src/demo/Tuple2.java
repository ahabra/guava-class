package demo;

import com.google.common.base.Objects;

public class Tuple2<E1, E2> {
  public final E1 e1;
  public final E2 e2;

  public Tuple2(E1 e1, E2 e2) {
      this.e1= e1;
      this.e2= e2;
  }
  
  public static <E1, E2> Tuple2<E1, E2> tuple2(E1 e1, E2 e2) {
      return new Tuple2<E1, E2>(e1, e2);
  }

  @Override
  public String toString() {
    return Objects.toStringHelper(this)
      .add("e1", e1)
      .add("e2", e2)
      .toString();
  }
  
}
