package uk.co.mruoc;

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

}
