package uk.co.mruoc.format;

import org.json.JSONObject;
import uk.co.mruoc.model.ProductPage;

import java.text.DecimalFormat;

public class ProductPageJsonFormatter {

    private static final double BYTES_IN_KILOBYTE = 1024;

    private UnitPriceFormatter unitPriceFormatter = new UnitPriceFormatter();

    public JSONObject toJson(ProductPage source) {
        JSONObject target = new JSONObject();
        target.put("title", source.getTitle());
        target.put("size", formatSize(source));
        target.put("unit_price", formatUnitPrice(source));
        target.put("description", source.getDescription());
        return target;
    }

    private String formatSize(ProductPage productPage) {
        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        double size = productPage.getSize() / BYTES_IN_KILOBYTE;
        return decimalFormat.format(size) + "kb";
    }

    private String formatUnitPrice(ProductPage productPage) {
        return unitPriceFormatter.format(productPage.getUnitPrice());
    }

}
