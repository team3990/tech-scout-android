package com.team3990.techscout.util;

import androidx.databinding.InverseMethod;

import com.team3990.techscout.enumeration.AllianceColor;

public final class AllianceColorConverter {

    @InverseMethod("stringToColor")
    public static String setColorToString(AllianceColor value) {
        if (value == AllianceColor.UNKNOWN) {
            return null;
        }
        return value.toString();
    }

    public static AllianceColor stringToColor(String value) {
        if (value == null || value.length() == 0) {
            // Return zero if the string is empty or null
            return AllianceColor.UNKNOWN;
        }
        return AllianceColor.valueOf(value.toUpperCase());
    }

}
