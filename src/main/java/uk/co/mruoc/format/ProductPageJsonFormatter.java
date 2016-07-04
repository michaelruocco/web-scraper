package uk.co.mruoc.format;

import org.json.JSONException;
import org.json.JSONObject;
import uk.co.mruoc.ScraperException;
import uk.co.mruoc.model.ProductPage;

public class ProductPageJsonFormatter {

    private UnitPriceFormatter unitPriceFormatter = new UnitPriceFormatter();
    private SizeConverter sizeConverter = new SizeConverter();
    private SizeFormatter sizeFormatter = new SizeFormatter();

    public JSONObject toJson(ProductPage source) {
        try {
            JSONObject target = new JSONObject();
            target.put("title", source.getTitle());
            target.put("size", formatSize(source));
            target.put("unit_price", formatUnitPrice(source));
            target.put("description", source.getDescription());
            return target;
        } catch (JSONException e) {
            throw new ScraperException(e);
        }
    }

    private String formatSize(ProductPage productPage) {
        double size = sizeConverter.bytesToKiloBytes(productPage.getSize());
        return sizeFormatter.format(size);
    }

    private String formatUnitPrice(ProductPage productPage) {
        return unitPriceFormatter.format(productPage.getUnitPrice());
    }

}
