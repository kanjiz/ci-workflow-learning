import org.junit.jupiter.api.Test;
import static com.google.common.truth.Truth.assertThat;
import static com.google.common.truth.Truth.assertWithMessage;

public class HelloTest {
  @Test
  public void testMain() {
    Hello.main(null);
    assertThat(true).isTrue();
  }

  @Test
  public void testAdd() {
    int result = Hello.add(1, 2);
    assertThat(result).isEqualTo(3);
  }

  @Test
  public void testAddFail() {
    int result = Hello.add(1, 2);
    assertWithMessage("Expected the result to be 4 but was %s", result).that(result).isEqualTo(4);
  }
}
