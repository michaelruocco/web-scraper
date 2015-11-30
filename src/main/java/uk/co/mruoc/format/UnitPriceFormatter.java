package uk.co.mruoc.format;

import java.text.DecimalFormat;

public class UnitPriceFormatter {

    public String format(double unitPrice) {
        DecimalFormat decimalFormat = new DecimalFormat("#.00");
        return decimalFormat.format(unitPrice);
    }

}
