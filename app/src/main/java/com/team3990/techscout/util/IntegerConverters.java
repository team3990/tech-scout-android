package com.team3990.techscout.util;

import androidx.databinding.InverseMethod;

public final class IntegerConverters {

    @InverseMethod("stringToInteger")
    public static String setIntegerToString(int value) {
        if (value == 0) {
            // Return an empty string if the integer is zero
            return null;
        }
        return String.valueOf(value);
    }

   public static int stringToInteger(String value) {
        if (value == null || value.length() == 0) {
            // Return zero if the string is empty or null
            return 0;
        }
       return Integer.parseInt(value);
   }

}
