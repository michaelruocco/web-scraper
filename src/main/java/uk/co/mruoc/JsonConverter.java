package uk.co.mruoc;

import org.json.JSONArray;
import org.json.JSONObject;

import java.text.DecimalFormat;
import java.util.List;

public class JsonConverter {

    public String toJsonString(Results results) {
        JSONObject json = toJson(results);
        return json.toString(4);
    }

    private JSONObject toJson(Results results) {
        JSONObject target = new JSONObject();
        target.put("results", toJSonArray(results.getResults()));
        target.put("total", formatUnitPrice(results.getTotal()));
        return target;
    }

    private JSONArray toJSonArray(List<Result> results) {
        JSONArray array = new JSONArray();
        for(Result result: results)
            array.put(toJson(result));
        return array;
    }

    private JSONObject toJson(Result source) {
        JSONObject target = new JSONObject();
        target.put("title", source.getTitle());
        target.put("size", formatSize(source.getSize()));
        target.put("unit_price", formatUnitPrice(source.getUnitPrice()));
        target.put("description", source.getDescription());
        return target;
    }

    private String formatSize(double size) {
        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        return decimalFormat.format(size) + "kb";
    }

    private String formatUnitPrice(double unitPrice) {
        DecimalFormat decimalFormat = new DecimalFormat("#.00");
        return decimalFormat.format(unitPrice);
    }

}
