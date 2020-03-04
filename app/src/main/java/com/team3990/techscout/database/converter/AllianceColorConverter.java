package com.team3990.techscout.database.converter;

import androidx.room.TypeConverter;

import com.team3990.techscout.enumeration.AllianceColor;

public final class AllianceColorConverter {

    @TypeConverter
    public String fromAllianceColor(AllianceColor color) {
        return color.toString();
    }

    @TypeConverter
    public AllianceColor toAllianceColor(String colorString) {
        return AllianceColor.valueOf(colorString);
    }

}
