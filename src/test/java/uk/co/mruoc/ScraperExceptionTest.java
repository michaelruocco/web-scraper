package uk.co.mruoc;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ScraperExceptionTest {

    @Test
    public void shouldReturnMessage() {
        String message = "message";

        Exception exception = new ScraperException(message);

        assertThat(exception.getMessage()).isEqualTo(message);
    }

    @Test
    public void shouldReturnCause() {
        Exception cause = new Exception();

        Exception exception = new ScraperException(cause);

        assertThat(exception.getCause()).isEqualTo(cause);
    }

}
