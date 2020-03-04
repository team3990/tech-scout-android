package com.team3990.techscout.util;

import androidx.databinding.InverseMethod;

public final class DecimalConverters {

    @InverseMethod("stringToDecimal")
    public static String setDecimalToString(float value) {
        if (value == 0) {
            // Return an empty string if the integer is zero
            return null;
        }
        return String.valueOf(value);
    }

    public static float stringToDecimal(String value) {
        if (value == null || value.length() == 0) {
            // Return zero if the string is empty or null
            return 0;
        }
        return Float.parseFloat(value);
    }

}
