package com.team3990.techscout.util;

import androidx.databinding.InverseMethod;

import com.team3990.techscout.enumeration.Endgame;

public final class EndgameActionConverter {

    @InverseMethod("stringToEndgameAction")
    public static String setEndgameActionToString(Endgame value) {
        if (value == Endgame.UNKNOWN) {
            return null;
        }
        return value.toString();
    }

    public static Endgame stringToEndgameAction(String value) {
        if (value == null || value.length() == 0) {
            // Return zero if the string is empty or null
            return Endgame.UNKNOWN;
        }
        return Endgame.valueOf(value.toUpperCase());
    }

}
