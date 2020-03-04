package com.team3990.techscout.util;

import androidx.databinding.InverseMethod;

import com.team3990.techscout.enumeration.ClimbDuration;

public final class ClimbDurationConverter {

    @InverseMethod("stringToClimbDuration")
    public static String setClimbDurationToString(ClimbDuration value) {
        if (value == ClimbDuration.NONE) {
            return null;
        }
        return value.toString();
    }

    public static ClimbDuration stringToClimbDuration(String value) {
        if (value == null || value.length() == 0) {
            // Return zero if the string is empty or null
            return ClimbDuration.NONE;
        }
        return ClimbDuration.valueOf(value.toUpperCase());
    }

}
