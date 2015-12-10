package uk.co.mruoc.format;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SizeFormatterTest {

    private final SizeFormatter formatter = new SizeFormatter();

    @Test
    public void shouldFormatIntegerValue() {
        double size = 1;
        assertThat(formatter.format(size)).isEqualTo("1kb");
    }

    @Test
    public void shouldFormatSingleDecimalValue() {
        double size = 2.5;
        assertThat(formatter.format(size)).isEqualTo("2.5kb");
    }

    @Test
    public void shouldFormatDoubleDecimalValue() {
        double size = 2.75;
        assertThat(formatter.format(size)).isEqualTo("2.75kb");
    }

    @Test
    public void shouldFormatMultipleDecimalValue() {
        double size = 12.043;
        assertThat(formatter.format(size)).isEqualTo("12.04kb");
    }

}
