package com.yuzhouwan.common.util;

import java.math.BigInteger;
import java.text.DecimalFormat;

/**
 * Copyright @ 2016 yuzhouwan.com
 * All right reserved.
 * Function: Decimal Utils
 *
 * @author Benedict Jin
 * @since 2016/5/9 0030
 */
public class DecimalUtils {

    private static final DecimalFormat decimalFormat = new DecimalFormat("0");

    public static int convert(int n) {
        return Integer.valueOf(String.valueOf(n), 16);
    }

    public static BigInteger double2BigInt(double d) {
        return new BigInteger(decimalFormat.format(d));
    }

    public static String saveTwoPoint(double d) {
        return String.format("%.2f", d);
    }
}
