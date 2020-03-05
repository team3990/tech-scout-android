package com.team3990.techscout.ui;

import android.util.Log;
import android.view.View;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.team3990.techscout.enumeration.DrivetrainType;
import com.team3990.techscout.enumeration.IntakeType;
import com.team3990.techscout.enumeration.PowerCellsCapacity;
import com.team3990.techscout.enumeration.ShooterPrecision;
import com.team3990.techscout.enumeration.ShooterReach;
import com.team3990.techscout.enumeration.ShooterType;
import com.team3990.techscout.model.RobotData;

public final class RobotDataEntryViewModel extends ViewModel {

    /** Properties */

    private final MutableLiveData<RobotData> mRobotData;;

    private final MutableLiveData<Integer> mShooterDataDropdownVisibility;
    private final MutableLiveData<Integer> mPowerCellsCapacityDropdownVisibility;
    private final MutableLiveData<Integer> mHasVisionAssistedAimingCheckboxVisibility;

    /**
     * Constructor
     *
     * Creates a new RobotDataEntryViewModel instance
     * */
    public RobotDataEntryViewModel() {
        mRobotData = new MutableLiveData<>(
                new RobotData()
        );
        mShooterDataDropdownVisibility = new MutableLiveData<>(View.GONE);
        mPowerCellsCapacityDropdownVisibility = new MutableLiveData<>(View.GONE);
        mHasVisionAssistedAimingCheckboxVisibility = new MutableLiveData<>(View.GONE);
    }

    /** Getters */

    public MutableLiveData<RobotData> getRobotData() {
        return mRobotData;
    }

    public LiveData<Integer> getShooterDataDropdownVisibility() {
        return mShooterDataDropdownVisibility;
    }

    public LiveData<Integer> getPowerCellsCapacityDropdownVisibility() {
        return mPowerCellsCapacityDropdownVisibility;
    }

    public LiveData<Integer> getHasVisionAssistedAimingCheckboxVisibility() {
        return mHasVisionAssistedAimingCheckboxVisibility;
    }

    /** Methods */

    public void intakeTypeClicked(long position) {
        if (mRobotData.getValue() == null) return;

        // React to the changes
        if (position == 0) { // WIDE
            mRobotData.getValue().setIntakeType(IntakeType.WIDE);
            mPowerCellsCapacityDropdownVisibility.setValue(View.VISIBLE);
        } else if (position == 1) { // NARROW
            mRobotData.getValue().setIntakeType(IntakeType.NARROW);
            mPowerCellsCapacityDropdownVisibility.setValue(View.VISIBLE);
        } else if (position == 2) { // NONE
            mRobotData.getValue().setIntakeType(IntakeType.NONE);
            mRobotData.getValue().setPowerCellsCapacity(PowerCellsCapacity.NONE);
            mPowerCellsCapacityDropdownVisibility.setValue(View.GONE);
        }
    }

    public void shooterTypeClicked(long position) {
        if (mRobotData.getValue() == null) return;

        // React to the changes
        if (position == 0) { // TURRET
            mRobotData.getValue().setShooterType(ShooterType.TURRET);
        } else if (position == 1) { // CATAPULT
            mRobotData.getValue().setShooterType(ShooterType.CATAPULT);
        } else if (position == 2) { // ARC
            mRobotData.getValue().setShooterType(ShooterType.ARC);
        } else if (position == 3) { // LINEAR
            mRobotData.getValue().setShooterType(ShooterType.LINEAR);
        }
    }

    public void shooterReachClicked(long position) {
        if (mRobotData.getValue() == null) return;

        // React to the change
        if (position == 0) { // OUTER / INNER PORT
            mRobotData.getValue().setShooterReach(ShooterReach.HIGH_GOAL);
            mShooterDataDropdownVisibility.setValue(View.VISIBLE);
            mHasVisionAssistedAimingCheckboxVisibility.setValue(View.VISIBLE);
        } else if (position == 1) { // BOTTOM PORT
            mRobotData.getValue().setShooterReach(ShooterReach.LOW_GOAL);
            mRobotData.getValue().setShooterType(ShooterType.NONE);
            mRobotData.getValue().setShooterPrecision(ShooterPrecision.NONE);
            mShooterDataDropdownVisibility.setValue(View.GONE);
            mHasVisionAssistedAimingCheckboxVisibility.setValue(View.VISIBLE);
        } else if (position == 2) { // BOTH
            mRobotData.getValue().setShooterReach(ShooterReach.BOTH);
            mShooterDataDropdownVisibility.setValue(View.VISIBLE);
            mHasVisionAssistedAimingCheckboxVisibility.setValue(View.VISIBLE);
        } else if (position == 3) { // NONE
            mRobotData.getValue().setShooterReach(ShooterReach.NONE);
            mRobotData.getValue().setShooterType(ShooterType.NONE);
            mRobotData.getValue().setHasVisionAssistedAiming(false);
            mRobotData.getValue().setShooterPrecision(ShooterPrecision.NONE);
            mShooterDataDropdownVisibility.setValue(View.GONE);
            mHasVisionAssistedAimingCheckboxVisibility.setValue(View.GONE);
        }
    }

    public void drivetrainTypeClicked(long position) {
        if (mRobotData.getValue() == null) return;

        // React to the changes
        if (position == 0) { // TANK
            mRobotData.getValue().setDrivetrainType(DrivetrainType.TANK);
        } else if (position == 1) { // OMNI
            mRobotData.getValue().setDrivetrainType(DrivetrainType.OMNI);
        } else if (position == 2) { // SWERVE
            mRobotData.getValue().setDrivetrainType(DrivetrainType.SWERVE);
        } else if (position == 3) { // MECANUM
            mRobotData.getValue().setDrivetrainType(DrivetrainType.MECANUM);
        }
    }

    public void shooterPrecisionClicked(long position) {
        if (mRobotData.getValue() == null) return;

        // React to the changes
        if (position == 0) { // MEDIOCRE
            mRobotData.getValue().setShooterPrecision(ShooterPrecision.MEDIOCRE);
        } else if (position == 1) { // GOOD
            mRobotData.getValue().setShooterPrecision(ShooterPrecision.GOOD);
        } else if (position == 2) { // EXCELLENT
            mRobotData.getValue().setShooterPrecision(ShooterPrecision.EXCELLENT);
        }
    }

    public void powerCellsCapacityClicked(long position) {
        if (mRobotData.getValue() == null) return;

        // React to the changes
        if (position == 0) { // EXTRA_SMALL
            mRobotData.getValue().setPowerCellsCapacity(PowerCellsCapacity.EXTRA_SMALL);
        } else if (position == 1) { // SMALL
            mRobotData.getValue().setPowerCellsCapacity(PowerCellsCapacity.SMALL);
        } else if (position == 2) { // MEDIUM
            mRobotData.getValue().setPowerCellsCapacity(PowerCellsCapacity.MEDIUM);
        } else if (position == 3) { // LARGE
            mRobotData.getValue().setPowerCellsCapacity(PowerCellsCapacity.LARGE);
        } else if (position == 4) { // EXTRA_LARGE
            mRobotData.getValue().setPowerCellsCapacity(PowerCellsCapacity.EXTRA_LARGE);
        }
    }

}
