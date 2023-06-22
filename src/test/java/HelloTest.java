import org.junit.jupiter.api.Test;
import static com.google.common.truth.Truth.assertThat;

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
    assertThat(result).isEqualTo(4);
  }
}