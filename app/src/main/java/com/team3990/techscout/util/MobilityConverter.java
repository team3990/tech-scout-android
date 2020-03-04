package com.team3990.techscout.util;

import androidx.databinding.InverseMethod;

import com.team3990.techscout.enumeration.Mobility;

public final class MobilityConverter {

    @InverseMethod("stringToMobility")
    public static String setMobilityToString(Mobility value) {
        if (value == Mobility.UNKNOWN) {
            return null;
        }
        return value.toString();
    }

    public static Mobility stringToMobility(String value) {
        if (value == null || value.length() == 0) {
            // Return zero if the string is empty or null
            return Mobility.UNKNOWN;
        }
        return Mobility.valueOf(value.toUpperCase().replace(" ", "_"));
    }

}
