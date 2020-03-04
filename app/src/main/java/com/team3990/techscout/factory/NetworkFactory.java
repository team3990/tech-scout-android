package com.team3990.techscout.factory;

import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public final class NetworkFactory {

    public static Gson provideDeserializer() {
        return new GsonBuilder()
                .setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
                .create();
    }

    public static OkHttpClient providerOkHttpClient(Context context) {
        return new OkHttpClient.Builder()
                .build();
    }

    public static Retrofit provideRetrofit(OkHttpClient client, Gson deserializer) {
        return new Retrofit.Builder()
                .client(client)
                .baseUrl("https://us-central1-tech-scout-production.cloudfunctions.net")
                .addConverterFactory(GsonConverterFactory.create(deserializer))
                .build();
    }

}
