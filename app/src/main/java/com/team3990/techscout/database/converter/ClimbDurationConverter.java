package com.team3990.techscout.database.converter;

import androidx.room.TypeConverter;

import com.team3990.techscout.enumeration.ClimbDuration;

public final class ClimbDurationConverter {

    @TypeConverter
    public String fromClimbDuration(ClimbDuration duration) {
        return duration.toString();
    }

    @TypeConverter
    public ClimbDuration toClimbDuration(String durationString) {
        return ClimbDuration.valueOf(durationString);
    }

}
