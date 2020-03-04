package com.team3990.techscout.database.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.team3990.techscout.model.GameData;
import com.team3990.techscout.model.RobotData;

import java.util.List;

@Dao
public interface DataSheetDao {

    @Query("SELECT * FROM game_data_sheet")
    List<GameData> getAllGameDataSheetsOnce();

    @Query("SELECT * FROM game_data_sheet")
    LiveData<List<GameData>> getAllGameDataSheets();

    @Insert
    void insertAll(GameData[] sheets);

}
