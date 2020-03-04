package com.team3990.techscout.ui;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.team3990.techscout.App;
import com.team3990.techscout.R;
import com.team3990.techscout.factory.DataSheetListVMFactory;

public class DataSheetListFragment extends Fragment {

    private static final int NUM_PAGES = 2;
    private static final int[] TITLE_PAGES = {R.string.game_scouting, R.string.pit_scouting};

    /** Properties */

    private PagerAdapter mPagerAdapter;
    private DataSheetListViewModel mViewModel;

    /** Fragment's lifecycle */

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);

        // Get an instance of the each dependency of the fragment's
        // view model
        final ViewModelStore store = getViewModelStore();
        final DataSheetListVMFactory factory = new DataSheetListVMFactory(
                App.appDatabase.gameDataSheetDao(),
                App.repositoryFactory.providerDataSheetRepository(
                        App.serviceFactory.providerDataSheetService()
                )
        );

        // Initialize the fragment's view model instance
        mViewModel = new ViewModelProvider(store, factory).get(DataSheetListViewModel.class);

        // Initialize the PagerAdapter
        mPagerAdapter = new PagerAdapter(getChildFragmentManager());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_data_sheet_list, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Initialize the ViewPager
        final ViewPager pager = view.findViewById(R.id.fragment_data_sheet_list_viewPager);
        pager.setAdapter(mPagerAdapter);
    }

    /** Methods */

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        inflater.inflate(R.menu.menu_data_sheet_sync, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.menu_item_upload_to_database) {
            mViewModel.uploadDataSheetsToDatabase();
            return true;
        }
        return false;
    }

    /**
     * A simple pager adapter that represents both a GameDataShitListFragment and a PitDataShitListFragment,
     * in sequence
     */
    private class PagerAdapter extends FragmentStatePagerAdapter {

        /**
         * Constructor
         *
         * Creates a new PagerAdapter instance
         * */
        public PagerAdapter(FragmentManager fm) {
            super(fm);
        }

        /** Methods */

        @Override
        public int getCount() {
            return NUM_PAGES;
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            final int title = TITLE_PAGES[position];
            return getResources().getString(title);
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            return new GameDataSheetListFragment();
        }


    }

}
