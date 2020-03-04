package com.team3990.techscout.ui;

import android.content.DialogInterface;
import android.os.AsyncTask;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.team3990.techscout.App;
import com.team3990.techscout.R;
import com.team3990.techscout.databinding.FragmentGameDataEntryBinding;
import com.team3990.techscout.factory.GameDataEntryVMFactory;
import com.team3990.techscout.util.Event;

public class GameDataEntryFragment extends Fragment implements View.OnClickListener {

    /** Properties */

    private GameDataEntryViewModel mViewModel;

    /** Fragment's lifecycle */

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Get an instance of the each dependency of the fragment's
        // view model
        final ViewModelStore store = getViewModelStore();
        final GameDataEntryVMFactory factory = new GameDataEntryVMFactory(
                App.appDatabase.gameDataSheetDao()
        );

        // Initialize the fragment's view model instance
        mViewModel = new ViewModelProvider(store, factory).get(GameDataEntryViewModel.class);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final FragmentGameDataEntryBinding binding = DataBindingUtil.inflate(inflater, R.layout.fragment_game_data_entry, container, false);

        // Initialize the binding's properties
        binding.setViewmodel(mViewModel);

        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Setup the alliance color dropdown menu
        setupDropdownMenus();

        // Assign the click listeners
        final FloatingActionButton saveFab = view.findViewById(R.id.fragment_game_data_entry_saveFloatingActionButton);
        saveFab.setOnClickListener(this);

        // Observe for success toast display requests
        mViewModel.getDisplaySuccessSnackbar().observe(getViewLifecycleOwner(), new Observer<Event<String>>() {
            @Override
            public void onChanged(Event<String> event) {
                if (event.getContentIfNotHandled() == null) { return; }
                Snackbar.make(requireView(), getResources().getString(R.string.data_sheet_saved, event.getContent()), Snackbar.LENGTH_LONG).show();
            }
        });
    }

    /** Methods */

    private void setupDropdownMenus() {
        final String[] mobility = getResources().getStringArray(R.array.mobility);
        final String[] allianceColors = getResources().getStringArray(R.array.alliance_colors);
        final String[] endgameActions = getResources().getStringArray(R.array.endgame_actions);
        final String[] climbDurations = getResources().getStringArray(R.array.climb_durations);

        // Configure the array adapters used bu the dropdown menus
        final ArrayAdapter<String> mobilityAdapter = new ArrayAdapter<>(requireContext(), R.layout.dropdown_menu_popup_item, mobility);
        final ArrayAdapter<String> allianceColorsAdapter = new ArrayAdapter<>(requireContext(), R.layout.dropdown_menu_popup_item, allianceColors);
        final ArrayAdapter<String> endgameActionsAdapter = new ArrayAdapter<>(requireContext(), R.layout.dropdown_menu_popup_item, endgameActions);
        final ArrayAdapter<String> climbDurationsAdapter = new ArrayAdapter<>(requireContext(), R.layout.dropdown_menu_popup_item, climbDurations);

        // Get the appropriate dropdown instances
        final AutoCompleteTextView mobilityDropdown = getView().findViewById(R.id.fragment_game_data_mobilityDropdown);
        final AutoCompleteTextView allianceColorsDropdown = getView().findViewById(R.id.fragment_game_data_allianceColorDropdown);
        final AutoCompleteTextView endgameActionsDropdown = getView().findViewById(R.id.fragment_game_data_endgameActionDropdown);
        final AutoCompleteTextView climbDurationsDropdown = getView().findViewById(R.id.fragment_game_data_climbDurationDropdown);

        // Set the dropdowns' respective adapters
        mobilityDropdown.setAdapter(mobilityAdapter);
        allianceColorsDropdown.setAdapter(allianceColorsAdapter);
        endgameActionsDropdown.setAdapter(endgameActionsAdapter);
        climbDurationsDropdown.setAdapter(climbDurationsAdapter);
    }

    @Override
    public void onClick(View v) {
        AlertDialog.Builder builder = new AlertDialog.Builder(requireActivity())
                .setTitle(R.string.save_data_sheet)
                .setMessage(R.string.save_data_sheet_description);

        // Get the layout inflater
        final LayoutInflater inflater = requireActivity().getLayoutInflater();

        // Get the dialog's layout
        final View dialogLayout = inflater.inflate(R.layout.dialog_save_data_sheet, null);
        final EditText sheetNameEditText = dialogLayout.findViewById(R.id.dialog_save_data_sheet_dataSheetNameEditText);

        // Populate the sheet name EditText with a default file name
        sheetNameEditText.setText(mViewModel.getAutoGeneratedMatchDataSheetFileName());

        // Inflate and set the layout for the dialog
        builder.setView(dialogLayout);

        // Add the appropriate buttons
        builder.setPositiveButton(R.string.save, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                // User clicked SAVE button
                mViewModel.saveAsDataSheet(sheetNameEditText.getText().toString());
            }
        });
        builder.setNegativeButton(R.string.cancel, null);

        // Create the AlertDialog
        final AlertDialog dialog = builder.create();

        // Display the AlertDialog
        dialog.show();
    }

}
