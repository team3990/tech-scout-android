package com.team3990.techscout.database.converter;

import androidx.room.TypeConverter;

import java.util.Date;

public final class DateConverter {

    @TypeConverter
    public Date fromTimestamp(long value) {
        return new Date(value);
    }

    @TypeConverter
    public long toTimestamp(Date date) {
        return date.getTime();
    }

}
