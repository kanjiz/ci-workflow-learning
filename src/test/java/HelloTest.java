import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

public class HelloTest {
  @Test
  public void testMain() {
    Hello.main(null);
    assertTrue(true);
  }

  @Test
  public void testFail() {
    fail();
  }
}
