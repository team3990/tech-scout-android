package com.team3990.techscout.ui;

import android.os.AsyncTask;

import androidx.lifecycle.ViewModel;

import com.team3990.techscout.database.dao.DataSheetDao;
import com.team3990.techscout.repository.DataSheetRepository;

public final class DataSheetListViewModel extends ViewModel {

    /** Properties */

    private final DataSheetDao mDataSheetDao;
    private final DataSheetRepository mDataSheetRepository;

    /**
     * Constructor
     *
     * Creates a new DataSheetListViewModel instance
     * */
    public DataSheetListViewModel(DataSheetDao dataSheetDao, DataSheetRepository dataSheetRepository) {
        mDataSheetDao = dataSheetDao;
        mDataSheetRepository = dataSheetRepository;
    }

    /** Methods */

    public void uploadDataSheetsToDatabase() {
        AsyncTask.execute(new Runnable() {
            @Override
            public void run() {
                mDataSheetRepository.mergeDataSheets(mDataSheetDao.getAllGameDataSheetsOnce());
            }
        });
    }

}
