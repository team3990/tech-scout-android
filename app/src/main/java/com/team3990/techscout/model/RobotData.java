package com.team3990.techscout.model;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.team3990.techscout.enumeration.DrivetrainType;
import com.team3990.techscout.enumeration.IntakeType;
import com.team3990.techscout.enumeration.PowerCellsCapacity;
import com.team3990.techscout.enumeration.ShooterPrecision;
import com.team3990.techscout.enumeration.ShooterReach;
import com.team3990.techscout.enumeration.ShooterType;

import java.util.Date;
import java.util.UUID;

@Entity(
        tableName = "robot_data_sheet"
)
public final class RobotData {

    /** Properties */
    @NonNull
    @PrimaryKey
    private String id;

    /**
     * A date representing the day and time during which the
     * data was collected.
     * */
    private Date timestamp;

    /**
     * An integer representing the number of the team
     * the data belongs to
     * */
    private int teamNumber;

    /**
     * An floating-point number representing the weight of the
     * robot
     * */
    private float weight;

    /**
     * An floating-point number representing the height of the
     * robot
     * */
    private float height;

    /**
     * An IntakeType enum case representing the intake mechanism used
     * by the robot to collect Power Cells
     * */
    private IntakeType intakeType = IntakeType.NONE;

    /**
     * A ShooterType enum case representing the shooting mechanism used
     * by the robot to score Power Cells
     * */
    private ShooterType shooterType = ShooterType.NONE;

    /**
     * A ShooterReach enum case representing the ports in which
     * the robot can score Power Cells
     * */
    private ShooterReach shooterReach = ShooterReach.NONE;

    /**
     * A ShooterPrecision enum case representing the precision of
     * the shooting mechanism
     * */
    private ShooterPrecision shooterPrecision = ShooterPrecision.NONE;

    /**
     * A PowerCellsCapacity enum case representing the amount of Power Cells
     * the robot can accumulate at the same time
     * */
    private PowerCellsCapacity powerCellsCapacity = PowerCellsCapacity.NONE;

    /**
     * A DrivetrainType enum case representing the drive train used
     * by the robot to move around
     * */
    private DrivetrainType drivetrainType = DrivetrainType.UNKNOWN;

    /**
     * A string representing additional comments provided
     * by the scouter
     * */
    private String comments;

    /**
     * A string representing the file name of the data sheet
     * containing the match data.
     * */
    private String fileName;

    /**
     * A string representing the name of the scouter who collected
     * the data
     * */
    private String scouterName;

    /**
     * A string representing the name of the regional during which
     * the data was collected
     * */
    private String regionalName;

    /**
     * Constructor
     *
     * Creates a new RobotData instance
     * */
    public RobotData() {
        this.id = UUID.randomUUID().toString();
        this.timestamp = new Date();
    }

    /** Getters */

    public int getTeamNumber() {
        return teamNumber;
    }

    public float getWeight() {
        return weight;
    }

    public float getHeight() {
        return height;
    }

    public String getComments() {
        return comments;
    }

    public String getScouterName() {
        return scouterName;
    }

    public String getRegionalName() {
        return regionalName;
    }

    /** Setters */

    public void setTeamNumber(int teamNumber) {
        this.teamNumber = teamNumber;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public void setIntakeType(IntakeType intakeType) {
        this.intakeType = intakeType;
    }

    public void setShooterType(ShooterType shooterType) {
        this.shooterType = shooterType;
    }

    public void setShooterReach(ShooterReach shooterReach) {
        this.shooterReach = shooterReach;
    }

    public void setShooterPrecision(ShooterPrecision shooterPrecision) {
        this.shooterPrecision = shooterPrecision;
    }

    public void setPowerCellsCapacity(PowerCellsCapacity powerCellsCapacity) {
        this.powerCellsCapacity = powerCellsCapacity;
    }

    public void setDrivetrainType(DrivetrainType drivetrainType) {
        this.drivetrainType = drivetrainType;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public void setScouterName(String scouterName) {
        this.scouterName = scouterName;
    }

    public void setRegionalName(String regionalName) {
        this.regionalName = regionalName;
    }

}
