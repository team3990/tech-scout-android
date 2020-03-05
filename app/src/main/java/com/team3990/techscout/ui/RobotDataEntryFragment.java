package com.team3990.techscout.ui;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

import com.team3990.techscout.R;
import com.team3990.techscout.databinding.FragmentRobotDataEntryBinding;
import com.team3990.techscout.factory.RobotDataEntryVMFactory;

public class RobotDataEntryFragment extends Fragment {

    /** Properties */

    private RobotDataEntryViewModel mViewModel;

    /** Fragment's lifecycle */

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Get an instance of the each dependency of the fragment's
        // view model
        final ViewModelStore store = getViewModelStore();
        final RobotDataEntryVMFactory factory = new RobotDataEntryVMFactory();

        // Initialize the fragment's view model instance
        mViewModel = new ViewModelProvider(store, factory).get(RobotDataEntryViewModel.class);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final FragmentRobotDataEntryBinding binding = DataBindingUtil.inflate(inflater, R.layout.fragment_robot_data_entry, container, false);

        // Initialize the binding's properties
        binding.setLifecycleOwner(this);
        binding.setViewmodel(mViewModel);

        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Set up the AutoCompleteTextView instances displayed by the view.
        setupAutoCompleteTextViews(view);
    }

    /** Methods */

    private void setupAutoCompleteTextViews(View parent) {
        setupIntakeAutoCompleteTextView(parent);
        setupDrivetrainAutoCompleteTextView(parent);
        setupShooterTypeAutoCompleteTextView(parent);
        setupShooterReachAutoCompleteTextView(parent);
        setupClimbDurationAutoCompleteTextView(parent);
        setupShooterPrecisionAutoCompleteTextView(parent);
        setupBuddyClimbCapacityAutoCompleteTextView(parent);
        setupPowerCellsCapacityAutoCompleteTextView(parent);
    }

    private void setupIntakeAutoCompleteTextView(View parent) {
        final AutoCompleteTextView intakeTypeAutoCompleteTextView = parent.findViewById(R.id.fragment_robot_data_entry_intakeTypeAutoCompleteTextView);
        final ArrayAdapter intakeTypeAutoCompleteTextViewAdapter = new ArrayAdapter<>(requireContext(), R.layout.dropdown_menu_popup_item, getResources().getStringArray(R.array.intake_types));

        // Set the auto complete's adapter
        intakeTypeAutoCompleteTextView.setAdapter(intakeTypeAutoCompleteTextViewAdapter);
    }

    private void setupDrivetrainAutoCompleteTextView(View parent) {
        final AutoCompleteTextView drivetrainAutoCompleteTextView = parent.findViewById(R.id.fragment_robot_data_entry_drivetrainTypeAutoCompleteTextView);
        final ArrayAdapter drivetrainTypeAutoCompleteTextViewAdapter = new ArrayAdapter<>(requireContext(), R.layout.dropdown_menu_popup_item, getResources().getStringArray(R.array.drivetrain_types));

        // Set the auto complete's adapter
        drivetrainAutoCompleteTextView.setAdapter(drivetrainTypeAutoCompleteTextViewAdapter);
    }

    private void setupShooterTypeAutoCompleteTextView(View parent) {
        final AutoCompleteTextView shooterTypeAutoCompleteTextView = parent.findViewById(R.id.fragment_robot_data_entry_shooterTypeAutoCompleteTextView);
        final ArrayAdapter shooterTypeAutoCompleteTextViewAdapter = new ArrayAdapter<>(requireContext(), R.layout.dropdown_menu_popup_item, getResources().getStringArray(R.array.shooter_types));

        // Set the auto complete's adapter
        shooterTypeAutoCompleteTextView.setAdapter(shooterTypeAutoCompleteTextViewAdapter);
    }

    private void setupShooterReachAutoCompleteTextView(View parent) {
        final AutoCompleteTextView shooterReachAutoCompleteTextView = parent.findViewById(R.id.fragment_robot_data_entry_shooterReachAutoCompleteTextView);
        final ArrayAdapter shooterReachAutoCompleteTextViewAdapter = new ArrayAdapter<>(requireContext(), R.layout.dropdown_menu_popup_item, getResources().getStringArray(R.array.power_ports));

        // Set the auto shooterReachAutoCompleteTextView's adapter
        shooterReachAutoCompleteTextView.setAdapter(shooterReachAutoCompleteTextViewAdapter);
    }

    private void setupClimbDurationAutoCompleteTextView(View parent) {
        final AutoCompleteTextView climbDurationAutoCompleteTextView = parent.findViewById(R.id.fragment_robot_data_entry_climbDurationAutoCompleteTextView);
        final ArrayAdapter climbDurationAutoCompleteTextViewAdapter = new ArrayAdapter<>(requireContext(), R.layout.dropdown_menu_popup_item, getResources().getStringArray(R.array.climb_durations));

        // Set the auto shooterReachAutoCompleteTextView's adapter
        climbDurationAutoCompleteTextView.setAdapter(climbDurationAutoCompleteTextViewAdapter);
    }

    private void setupShooterPrecisionAutoCompleteTextView(View parent) {
        final AutoCompleteTextView shooterPrecisionAutoCompleteTextView = parent.findViewById(R.id.fragment_robot_data_entry_shooterPrecisionAutoCompleteTextView);
        final ArrayAdapter shooterPrecisionAutoCompleteTextViewAdapter = new ArrayAdapter<>(requireContext(), R.layout.dropdown_menu_popup_item, getResources().getStringArray(R.array.shooter_precision));

        // Set the auto shooterReachAutoCompleteTextView's adapter
        shooterPrecisionAutoCompleteTextView.setAdapter(shooterPrecisionAutoCompleteTextViewAdapter);
    }

    private void setupBuddyClimbCapacityAutoCompleteTextView(View parent) {
        final AutoCompleteTextView buddyClimbCapacityAutoCompleteTextView = parent.findViewById(R.id.fragment_robot_data_entry_buddyClimbCapacityAutoCompleteTextView);
        final ArrayAdapter buddyClimbCapacityAutoCompleteTextViewAdapter = new ArrayAdapter<>(requireContext(), R.layout.dropdown_menu_popup_item, getResources().getStringArray(R.array.buddy_climb_capacity));

        // Set the auto shooterReachAutoCompleteTextView's adapter
        buddyClimbCapacityAutoCompleteTextView.setAdapter(buddyClimbCapacityAutoCompleteTextViewAdapter);
    }

    private void setupPowerCellsCapacityAutoCompleteTextView(View parent) {
        final AutoCompleteTextView powerCellsCapacityAutoCompleteTextView = parent.findViewById(R.id.fragment_robot_data_entry_powerCellsCapacityAutoCompleteTextView);
        final ArrayAdapter powerCellsCapacityAutoCompleteTextViewAdapter = new ArrayAdapter<>(requireContext(), R.layout.dropdown_menu_popup_item, getResources().getStringArray(R.array.power_cells_capacity));

        // Set the auto shooterReachAutoCompleteTextView's adapter
        powerCellsCapacityAutoCompleteTextView.setAdapter(powerCellsCapacityAutoCompleteTextViewAdapter);
    }

}
