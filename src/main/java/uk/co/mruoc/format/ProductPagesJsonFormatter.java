package uk.co.mruoc.format;

import org.json.JSONArray;
import org.json.JSONObject;
import uk.co.mruoc.model.ProductPage;
import uk.co.mruoc.model.ProductPages;

public class ProductPagesJsonFormatter {

    private static final int INDENTATION = 4;

    private final ProductPageJsonFormatter resultFormatter = new ProductPageJsonFormatter();
    private final UnitPriceFormatter unitPriceFormatter = new UnitPriceFormatter();

    private final ProductPages productPages;

    public ProductPagesJsonFormatter(ProductPages productPages) {
        this.productPages = productPages;
    }

    public String toJsonString() {
        JSONObject json = toJson();
        return json.toString(INDENTATION);
    }

    private JSONObject toJson() {
        JSONObject target = new JSONObject();
        target.put("results", toJSonArray());
        target.put("total", formatTotal());
        return target;
    }

    private JSONArray toJSonArray() {
        JSONArray array = new JSONArray();
        for(ProductPage productPage : productPages.toList())
            array.put(toJson(productPage));
        return array;
    }

    private JSONObject toJson(ProductPage productPage) {
        return resultFormatter.toJson(productPage);
    }

    private String formatTotal() {
        return formatUnitPrice(productPages.getTotal());
    }

    private String formatUnitPrice(double unitPrice) {
        return unitPriceFormatter.format(unitPrice);
    }

}
