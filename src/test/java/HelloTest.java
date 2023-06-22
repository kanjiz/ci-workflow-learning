import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class HelloTest {
  @Test
  public void testMain() {
    Hello.main(null);
    assertTrue(true);
  }

  @Test
  public void testAdd() {
    int result = Hello.add(1, 2);
    assertEquals(3, result);
  }

  @Test
  public void testAddFail() {
    int result = Hello.add(1, 2);
    assertEquals(4, result);
  }
}
