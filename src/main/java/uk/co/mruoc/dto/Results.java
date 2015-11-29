package uk.co.mruoc.dto;

import java.util.ArrayList;
import java.util.List;

public class Results {

    private List<Result> results = new ArrayList<>();

    public void add(Result result) {
        results.add(result);
    }

    public List<Result> getResults() {
        return results;
    }

    public double getTotal() {
        double total = 0;
        for(Result result : results)
            total += result.getUnitPrice();
        return total;
    }

}
