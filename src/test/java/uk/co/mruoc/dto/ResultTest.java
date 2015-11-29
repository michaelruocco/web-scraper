package uk.co.mruoc.dto;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static uk.co.mruoc.dto.Result.ResultBuilder;

public class ResultTest {

    private static final String TITLE = "TITLE";
    private static final String DESCRIPTION = "DESCRIPTION";
    private static final double UNIT_PRICE = 9.99;
    private static final double SIZE = 33;

    private final Result result = new ResultBuilder()
            .setTitle(TITLE)
            .setDescription(DESCRIPTION)
            .setUnitPrice(UNIT_PRICE)
            .setSize(SIZE)
            .build();

    @Test
    public void shouldReturnValues() {
        assertThat(result.getTitle()).isEqualTo(TITLE);
        assertThat(result.getDescription()).isEqualTo(DESCRIPTION);
        assertThat(result.getUnitPrice()).isEqualTo(UNIT_PRICE);
        assertThat(result.getSize()).isEqualTo(SIZE);
    }

}
