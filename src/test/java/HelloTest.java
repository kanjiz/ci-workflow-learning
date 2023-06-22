import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

public class HelloTest {
  @Test
  public void testMain() {
    Hello.main(null);
    assertTrue(true);
  }

//  @Test
//  public void testFail() {
//    fail();
//  }

  @Test
  public void testAdd() {
    int result = Hello.add(1, 2);
    assertTrue(result == 3);
  }

  @Test
  public void testAddFail() {
    int result = Hello.add(1, 2);
    assertTrue(result == 4);
  }
}
