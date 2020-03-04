package com.team3990.techscout.database.converter;

import androidx.room.TypeConverter;

import com.team3990.techscout.enumeration.Endgame;

public final class EndgameConverter {

    @TypeConverter
    public String fromEndgame(Endgame endgame) {
        return endgame.toString();
    }

    @TypeConverter
    public Endgame toEndgame(String endgameString) {
        return Endgame.valueOf(endgameString);
    }

}
