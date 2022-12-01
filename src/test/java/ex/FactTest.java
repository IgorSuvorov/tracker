package ex;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class FactTest {
    @Test
    public void whenNIsThreeThenSix() {
        assertThat(new Fact().calc(3)).isEqualTo(6);
    }

    @Test
    public void whenNIsLessThanZeroThenException() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> {
                    new Fact().calc(-1);
                });
        assertThat(exception.getMessage()).isEqualTo("N could not be less than 0");
    }
}
