package com.team3990.techscout.service;

import com.team3990.techscout.model.MergeDataSheetsRequestBody;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.PUT;

public interface DataSheetService {

    @PUT("/mergeDataSheets")
    Call<ResponseBody> mergeDataSheets(@Body MergeDataSheetsRequestBody matchDataSheets);

}
