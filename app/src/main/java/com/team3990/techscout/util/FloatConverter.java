package com.team3990.techscout.util;

import androidx.databinding.InverseMethod;

public final class FloatConverter {

    @InverseMethod("stringToFloat")
    public static String setFloatToString(float value) {
        if (value == 0) {
            // Return an empty string if the integer is zero
            return null;
        }
        return String.valueOf(value);
    }

    public static float stringToFloat(String value) {
        if (value == null || value.length() == 0) {
            // Return zero if the string is empty or null
            return 0;
        }
        return Float.parseFloat(value);
    }

}
