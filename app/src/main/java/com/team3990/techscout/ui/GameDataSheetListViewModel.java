package com.team3990.techscout.ui;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.team3990.techscout.database.dao.DataSheetDao;
import com.team3990.techscout.model.GameData;

import java.util.List;

public final class GameDataSheetListViewModel extends ViewModel {

    /** Properties */

    private final DataSheetDao mSheetDao;

    /**
     * Constructor
     *
     * Creates a new GameDataSheetViewModel instance
     * */
    public GameDataSheetListViewModel(DataSheetDao sheetDao) {
        mSheetDao = sheetDao;
    }

    /** Getters */

    public LiveData<List<GameData>> getDataSheets() { return mSheetDao.getAllGameDataSheets(); }

}
