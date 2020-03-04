package com.team3990.techscout.factory;

import com.team3990.techscout.service.DataSheetService;

import retrofit2.Retrofit;

public final class ServiceFactory {

    /** Property */

    private final Retrofit mRetrofit;

    /**
     * Constructor
     *
     * Creates a new ServiceFactory instance
     * */
    public ServiceFactory(Retrofit mRetrofit) {
        this.mRetrofit = mRetrofit;
    }

    /** Methods */

    public DataSheetService providerDataSheetService() {
        return mRetrofit.create(DataSheetService.class);
    }

}
