package com.team3990.techscout.util;

import android.os.AsyncTask;

import com.team3990.techscout.database.dao.DataSheetDao;
import com.team3990.techscout.model.GameData;

public final class InsertDataSheetTask extends AsyncTask<GameData, Void, String> {

    public interface OnBackgroundComputationFinishesListener {
        void onInsertionCompleted(String s);
    }

    /** Properties */

    private final DataSheetDao mDataSheetDao;
    private final OnBackgroundComputationFinishesListener mListener;

    /**
     * Constructor
     *
     * Creates a new InsertDataSheetTask instance
     * */
    public InsertDataSheetTask(OnBackgroundComputationFinishesListener listener, DataSheetDao dataSheetDao) {
        mListener = listener;
        mDataSheetDao = dataSheetDao;
    }

    /** Methods */

    @Override
    protected String doInBackground(GameData... dataSheet) {
        if (dataSheet.length == 0) { return null; }

        // Loop through the passed data sheets and use Room Database to persist them
        // on the device's local storage.
        for (GameData sheet : dataSheet) {
            mDataSheetDao.insertAll(dataSheet);
        }

        return dataSheet[0].getFileName();
    }

    @Override
    protected void onPostExecute(String s) {
        mListener.onInsertionCompleted(s);
    }

}
