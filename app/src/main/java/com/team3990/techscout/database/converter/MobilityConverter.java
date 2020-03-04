package com.team3990.techscout.database.converter;

import androidx.room.TypeConverter;

import com.team3990.techscout.enumeration.Mobility;

public final class MobilityConverter {

    @TypeConverter
    public String fromMobility(Mobility mobility) {
        return mobility.toString();
    }

    @TypeConverter
    public Mobility toMobility(String mobilityString) {
        return Mobility.valueOf(mobilityString);
    }

}
