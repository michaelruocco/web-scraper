package uk.co.mruoc.format;

import java.text.DecimalFormat;

public class SizeFormatter {

    public String format(double size) {
        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        return decimalFormat.format(size).concat("kb");
    }

}
