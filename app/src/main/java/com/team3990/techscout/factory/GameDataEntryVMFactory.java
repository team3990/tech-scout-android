package com.team3990.techscout.factory;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.team3990.techscout.database.dao.DataSheetDao;

import java.lang.reflect.InvocationTargetException;

public final class GameDataEntryVMFactory implements ViewModelProvider.Factory {

    /** Properties */

    private final DataSheetDao mDataSheetDao;

    /**
     * Constructor
     *
     * Creates a new Game Data Entry VM Factory.
     * */
    public GameDataEntryVMFactory(DataSheetDao dataSheetDao) {
        mDataSheetDao = dataSheetDao;
    }

    /** Methods */

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        T viewModel = null;
        try {
            viewModel = modelClass.getConstructor(DataSheetDao.class).newInstance(mDataSheetDao);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return viewModel;
    }

}
