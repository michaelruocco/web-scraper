package uk.co.mruoc.format;

import org.json.JSONObject;
import uk.co.mruoc.model.ProductPage;

import java.text.DecimalFormat;

public class ProductPageJsonFormatter {

    private UnitPriceFormatter unitPriceFormatter = new UnitPriceFormatter();

    public JSONObject toJson(ProductPage source) {
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
        return unitPriceFormatter.format(unitPrice);
    }

}
