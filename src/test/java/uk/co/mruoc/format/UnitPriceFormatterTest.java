package uk.co.mruoc.format;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class UnitPriceFormatterTest {

    private final UnitPriceFormatter formatter = new UnitPriceFormatter();

    @Test
    public void shouldRoundDecimalToTwoDecimalPlaces() {
        double price = 1.234;
        assertThat(formatter.format(price)).isEqualTo("1.23");
    }

    @Test
    public void shouldRoundDecimalUpToTwoDecimalPlaces() {
        double price = 1.235;
        assertThat(formatter.format(price)).isEqualTo("1.24");
    }

    @Test
    public void shouldFormatIntegerToTwoDecimalPlaces() {
        double price = 1;
        assertThat(formatter.format(price)).isEqualTo("1.00");
    }

}
