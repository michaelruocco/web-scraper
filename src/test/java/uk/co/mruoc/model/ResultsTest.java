package uk.co.mruoc.model;

import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static uk.co.mruoc.model.Result.ResultBuilder;

public class ResultsTest {

    private final Result resultPriceTenFifty = createResultWithPrice(10.50);
    private final Result resultPriceFive = createResultWithPrice(5);

    private final Results results = new Results();

    @Test
    public void shouldReturnResults() {
        results.add(resultPriceTenFifty);
        results.add(resultPriceFive);

        List<Result> resultList = results.toList();
        assertThat(resultList.size()).isEqualTo(2);
        assertThat(resultList.contains(resultPriceTenFifty)).isTrue();
        assertThat(resultList.contains(resultPriceFive)).isTrue();
    }

    @Test
    public void shouldCalculateTotal() {
        results.add(resultPriceTenFifty);
        results.add(resultPriceFive);

        assertThat(results.getTotal()).isEqualTo(15.50);
    }

    private Result createResultWithPrice(double unitPrice) {
        return new ResultBuilder().setUnitPrice(unitPrice).build();
    }

}
