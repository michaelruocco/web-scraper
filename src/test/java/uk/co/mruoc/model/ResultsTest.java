package uk.co.mruoc.model;

import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static uk.co.mruoc.model.Result.ResultBuilder;

public class ResultsTest {

    private final Results results = new Results();

    @Test
    public void shouldReturnResults() {
        Result result1 = createResult();
        Result result2 = createResult();

        results.add(result1);
        results.add(result2);
        List<Result> resultList = results.toList();

        assertThat(resultList.size()).isEqualTo(2);
        assertThat(resultList.contains(result1)).isTrue();
        assertThat(resultList.contains(result2)).isTrue();
    }

    @Test
    public void shouldCalculateTotal() {
        results.add(createResultWithPrice(10.50));
        results.add(createResultWithPrice(5));

        assertThat(results.getTotal()).isEqualTo(15.50);
    }

    private Result createResult() {
        return new ResultBuilder().build();
    }

    private Result createResultWithPrice(double unitPrice) {
        return new ResultBuilder().setUnitPrice(unitPrice).build();
    }

}
