package com.team3990.techscout;

import android.app.Application;

import androidx.room.Room;

import com.team3990.techscout.database.AppDatabase;
import com.team3990.techscout.factory.NetworkFactory;
import com.team3990.techscout.factory.RepositoryFactory;
import com.team3990.techscout.factory.ServiceFactory;

public final class App extends Application {

    public static AppDatabase appDatabase;
    public static ServiceFactory serviceFactory;
    public static RepositoryFactory repositoryFactory;

    /** Activity's lifecycle */

    @Override
    public void onCreate() {
        super.onCreate();

        // Initialize the application's database
        appDatabase = Room.databaseBuilder(this, AppDatabase.class, "tech-scouting-database")
                .fallbackToDestructiveMigration()
                .build();

        // Initialize the service factory
        serviceFactory = new ServiceFactory(
                NetworkFactory.provideRetrofit(
                        NetworkFactory.providerOkHttpClient(this),
                        NetworkFactory.provideDeserializer()
                )
        );

        // Initialize the repository factory
        repositoryFactory = new RepositoryFactory();
    }
}
