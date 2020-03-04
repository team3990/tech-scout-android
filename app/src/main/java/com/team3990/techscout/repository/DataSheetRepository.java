package com.team3990.techscout.repository;

import android.util.Log;

import com.team3990.techscout.model.MergeDataSheetsRequestBody;
import com.team3990.techscout.service.DataSheetService;
import com.team3990.techscout.model.GameData;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public final class DataSheetRepository {

    /** Properties */

    private final DataSheetService mDataSheetService;

    /**
     * Constructor
     *
     * Creates a new DataSheetRepository instance
     * */
    public DataSheetRepository(DataSheetService mDataSheetService) {
        this.mDataSheetService = mDataSheetService;
    }

    /** Methods */

    public void mergeDataSheets(List<GameData> gameDataSheets) {
        final MergeDataSheetsRequestBody requestBody = new MergeDataSheetsRequestBody(gameDataSheets);

        // Attempt to merge the data sheets persisted on the device's local storage with the ones persisted
        // on Cloud Firestore
        mDataSheetService.mergeDataSheets(requestBody).enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                Log.i("DATA SHEET", "The data sheets were successfully merged.");
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Log.e("DATA SHEET", "An error occurred while trying to merge the data sheets");
            }
        });
    }

}
