package uk.co.mruoc.format;

public class SizeConverter {

    private static final double BYTES_IN_KILOBYTE = 1024;

    public double bytesToKiloBytes(double bytes) {
        return bytes / BYTES_IN_KILOBYTE;
    }

}
