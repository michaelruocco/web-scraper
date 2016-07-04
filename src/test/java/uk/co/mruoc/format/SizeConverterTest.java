package uk.co.mruoc.format;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SizeConverterTest {

    private final SizeConverter converter = new SizeConverter();

    @Test
    public void shouldConvertBytesToKilobytes() {
        double sizeInBytes = 1024;
        assertThat(converter.bytesToKiloBytes(sizeInBytes)).isEqualTo(1);
    }

    @Test
    public void shouldRoundSingleDecimalValue() {
        double sizeInBytes = 2560;
        assertThat(converter.bytesToKiloBytes(sizeInBytes)).isEqualTo(2.5);
    }

    @Test
    public void shouldRoundDoubleDecimalValue() {
        double sizeInBytes = 2816;
        assertThat(converter.bytesToKiloBytes(sizeInBytes)).isEqualTo(2.75);
    }

    @Test
    public void shouldRoundMoreThanTwoDecimalValuesToTwoDecimalPlaces() {
        double sizeInBytes = 12333;
        assertThat(converter.bytesToKiloBytes(sizeInBytes)).isEqualTo(12.0439453125);
    }

}
