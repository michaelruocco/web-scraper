package uk.co.mruoc.format;

import org.json.JSONArray;
import org.json.JSONObject;
import uk.co.mruoc.dto.Result;
import uk.co.mruoc.dto.Results;

import java.text.DecimalFormat;

public class JsonFormatter {

    private Results results;

    public JsonFormatter(Results results) {
        this.results = results;
    }

    public String toJsonString() {
        JSONObject json = toJson();
        return json.toString(4);
    }

    private JSONObject toJson() {
        JSONObject target = new JSONObject();
        target.put("results", toJSonArray());
        target.put("total", formatTotal());
        return target;
    }

    private JSONArray toJSonArray() {
        JSONArray array = new JSONArray();
        for(Result result : results.toList())
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

    private String formatTotal() {
        return formatUnitPrice(results.getTotal());
    }

    private String formatUnitPrice(double unitPrice) {
        DecimalFormat decimalFormat = new DecimalFormat("#.00");
        return decimalFormat.format(unitPrice);
    }

}
