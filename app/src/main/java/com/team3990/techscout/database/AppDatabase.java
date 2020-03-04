package com.team3990.techscout.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import com.team3990.techscout.database.converter.AllianceColorConverter;
import com.team3990.techscout.database.converter.ClimbDurationConverter;
import com.team3990.techscout.database.converter.DateConverter;
import com.team3990.techscout.database.converter.EndgameConverter;
import com.team3990.techscout.database.converter.MobilityConverter;
import com.team3990.techscout.database.dao.DataSheetDao;
import com.team3990.techscout.model.GameData;

@Database(entities = {GameData.class}, version = 1)
@TypeConverters(value = {DateConverter.class, EndgameConverter.class, MobilityConverter.class, AllianceColorConverter.class, ClimbDurationConverter.class})
public abstract class AppDatabase extends RoomDatabase {

    public abstract DataSheetDao gameDataSheetDao();

}
