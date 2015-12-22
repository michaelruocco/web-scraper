package uk.co.mruoc;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ScraperExceptionTest {

    private static final String MESSAGE = "MESSAGE";
    private final Exception cause = new Exception();

    @Test
    public void shouldReturnMessage() {
        Exception exception = new ScraperException(MESSAGE);

        assertThat(exception.getMessage()).isEqualTo(MESSAGE);
    }

    @Test
    public void shouldReturnCause() {
        Exception exception = new ScraperException(cause);

        assertThat(exception.getCause()).isEqualTo(cause);
    }

    @Test
    public void shouldReturnMessageAndCause() {
        Exception exception = new ScraperException(MESSAGE, cause);

        assertThat(exception.getMessage()).isEqualTo(MESSAGE);
        assertThat(exception.getCause()).isEqualTo(cause);
    }

}
