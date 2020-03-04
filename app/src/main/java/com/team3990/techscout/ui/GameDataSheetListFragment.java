package com.team3990.techscout.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.team3990.techscout.App;
import com.team3990.techscout.R;
import com.team3990.techscout.common.GameDataSheetAdapter;
import com.team3990.techscout.factory.GameDataEntryVMFactory;
import com.team3990.techscout.factory.GameDataSheetListVMFactory;
import com.team3990.techscout.model.GameData;

import java.util.List;

public class GameDataSheetListFragment extends Fragment {

    private static final String SELECTION_ID = "fragment_game_data_sheet_list_selection";

    /** Properties */

    private ProgressBar mProgressBar;
    private RecyclerView mRecyclerView;
    private GameDataSheetAdapter mAdapter;
    private GameDataSheetListViewModel mViewModel;

    /** Fragment's lifecycle */

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Get an instance of the each dependency of the fragment's
        // view model
        final ViewModelStore store = getViewModelStore();
        final GameDataSheetListVMFactory factory = new GameDataSheetListVMFactory(
                App.appDatabase.gameDataSheetDao()
        );

        // Initialize the fragment's view model instance
        mViewModel = new ViewModelProvider(store, factory).get(GameDataSheetListViewModel.class);

        // Initialize the adapter instance.
        mAdapter = new GameDataSheetAdapter();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_game_data_sheet_list, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Initialize the views
        mProgressBar = view.findViewById(R.id.fragment_game_data_sheet_list_progressBar);
        mRecyclerView = view.findViewById(R.id.fragment_game_data_sheet_list_recyclerView);

        // Set up the recycler view
        setupRecyclerView();

        // Observe for data sheets
        mViewModel.getDataSheets().observe(getViewLifecycleOwner(), new Observer<List<GameData>>() {
            @Override
            public void onChanged(List<GameData> gameData) {
                exitLoadingState();
                mAdapter.setDataSheets(gameData);
            }
        });
    }

    /** Methods */

    private void exitLoadingState() {
        mProgressBar.setVisibility(View.INVISIBLE);
        mRecyclerView.setVisibility(View.VISIBLE);
    }

    private void setupRecyclerView() {
        final LinearLayoutManager layoutManager = new LinearLayoutManager(requireContext());
        final DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(mRecyclerView.getContext(), layoutManager.getOrientation());

        // Initialize the recycler view's properties
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.addItemDecoration(dividerItemDecoration);
    }

}
