package com.team3990.techscout.model;

import androidx.annotation.NonNull;
import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.team3990.techscout.BR;
import com.team3990.techscout.enumeration.AllianceColor;
import com.team3990.techscout.enumeration.ClimbDuration;
import com.team3990.techscout.enumeration.Endgame;
import com.team3990.techscout.enumeration.Mobility;

import java.util.Date;
import java.util.UUID;

@Entity(
        tableName = "game_data_sheet"
)
public final class GameData extends BaseObservable {

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
     * An integer representing the number of the match
     * during which the data was collected
     * */
    private int matchNumber;

    /**
     * An integer representing the number of the team
     * the data belongs to
     * */
    private int teamNumber;

    /**
     * An integer representing the amount of Power Cells
     * the robot scored in the bottom port
     * */
    private int autoBottomPortPowerCells;

    /**
     * An integer representing the amount of Power Cells
     * the robot scored in the outer port
     * */
    private int autoOuterPortPowerCells;

    /**
     * An integer representing the amount of Power Cells
     * the robot scored in the inner port
     * */
    private int autoInnerPortPowerCells;

    /**
     * An integer representing the amount of Power Cells
     * the robot scored in the bottom port during the teleoperated period.
     * */
    private int teleBottomPortPowerCells;

    /**
     * An integer representing the amount of Power Cells
     * the robot scored in the outer port during the teleoperated period
     * */
    private int teleOuterPortPowerCells;

    /**
     * An integer representing the amount of Power Cells
     * the robot scored in the inner port during the teleoperated period
     * */
    private int teleInnerPortPowerCells;

    /**
     * A boolean representing whether or not the robot
     * used the rotation control during the match
     * */
    private boolean rotationControl;

    /**
     * A boolean representing whether or not the robot
     * used the position control during the match
     * */
    private boolean positionControl;

    /**
     * A boolean representing whether or not the robot
     * moves to the initiation line
     * */
    private boolean movesToInitiationLine;

    /**
     * An Endgame enum case representing the action the robot performs
     * at the end of the match
     * */
    private Endgame endgame = Endgame.UNKNOWN;

    /**
     * A Mobility enum case representing the mobility of the robot
     * during the match
     * */
    private Mobility mobility = Mobility.UNKNOWN;

    /**
     * A ClimbDuration enum case representing the amount of time
     * it took for the robot to climb, if applicable.
     * */
    private ClimbDuration climbDuration = ClimbDuration.NONE;

    /**
     * An Alliance Color enum case representing the alliance color
     * the team belongs to.
     * */
    private AllianceColor allianceColor = AllianceColor.UNKNOWN;

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
     * Creates a new Game Data instance
     * */
    public GameData() {
        this.id = UUID.randomUUID().toString();
        this.timestamp = new Date();
    }

    /** Getters */

    public String getId() { return id; }

    public Date getTimestamp() { return timestamp; }

    @Bindable
    public int getMatchNumber() { return matchNumber; }

    @Bindable
    public int getTeamNumber() { return teamNumber; }

    @Bindable
    public int getAutoBottomPortPowerCells() { return autoBottomPortPowerCells; }

    @Bindable
    public int getAutoOuterPortPowerCells() { return autoOuterPortPowerCells; }

    @Bindable
    public int getAutoInnerPortPowerCells() { return autoInnerPortPowerCells; }

    @Bindable
    public int getTeleBottomPortPowerCells() { return teleBottomPortPowerCells; }

    @Bindable
    public int getTeleOuterPortPowerCells() { return teleOuterPortPowerCells; }

    @Bindable
    public int getTeleInnerPortPowerCells() { return teleInnerPortPowerCells; }

    @Bindable
    public boolean isRotationControl() { return rotationControl; }

    @Bindable
    public boolean isPositionControl() { return positionControl; }

    @Bindable
    public boolean isMovesToInitiationLine() { return movesToInitiationLine; }

    @Bindable
    public String getComments() { return comments; }

    @Bindable
    public Endgame getEndgame() { return endgame; }

    @Bindable
    public Mobility getMobility() { return mobility; }

    @Bindable
    public ClimbDuration getClimbDuration() { return climbDuration; }

    @Bindable
    public AllianceColor getAllianceColor() { return allianceColor; }

    @Bindable
    public String getScouterName() { return scouterName; }

    @Bindable
    public String getRegionalName() { return regionalName; }

    public String getFileName() { return fileName; }

    /** Setters */

    public void setId(@NonNull String id) { this.id = id; }

    public void setTimestamp(Date timestamp) { this.timestamp = timestamp; }

    public void setMatchNumber(int matchNumber) {
        // Avoids infinite loops
        if (matchNumber != this.matchNumber) {
            this.matchNumber = matchNumber;

            // Notify observers of a new value
            this.notifyPropertyChanged(BR.matchNumber);
        }
    }

    public void setTeamNumber(int teamNumber) {
        // Avoids infinite loops
        if (teamNumber != this.teamNumber) {
            this.teamNumber = teamNumber;

            // Notify observers of a new value
            this.notifyPropertyChanged(BR.matchNumber);
        }
    }

    public void setAutoBottomPortPowerCells(int autoBottomPortPowerCells) {
        // Avoids infinite loops
        if (autoBottomPortPowerCells != this.autoBottomPortPowerCells) {
            this.autoBottomPortPowerCells = autoBottomPortPowerCells;

            // Notify observers of a new value
            this.notifyPropertyChanged(BR.autoBottomPortPowerCells);
        }
    }

    public void setAutoOuterPortPowerCells(int autoOuterPortPowerCells) {
        // Avoids infinite loops
        if (autoOuterPortPowerCells != this.autoOuterPortPowerCells) {
            this.autoOuterPortPowerCells = autoOuterPortPowerCells;

            // Notify observers of a new value
            this.notifyPropertyChanged(BR.autoOuterPortPowerCells);
        }
    }

    public void setAutoInnerPortPowerCells(int autoInnerPortPowerCells) {
        // Avoids infinite loops
        if (autoInnerPortPowerCells != this.autoInnerPortPowerCells) {
            this.autoInnerPortPowerCells = autoInnerPortPowerCells;

            // Notify observers of a new value
            this.notifyPropertyChanged(BR.autoInnerPortPowerCells);
        }
    }

    public void setTeleBottomPortPowerCells(int teleBottomPortPowerCells) {
        // Avoids infinite loops
        if (teleBottomPortPowerCells != this.teleBottomPortPowerCells) {
            this.teleBottomPortPowerCells = teleBottomPortPowerCells;

            // Notify observers of a new value
            this.notifyPropertyChanged(BR.teleBottomPortPowerCells);
        }
    }

    public void setTeleOuterPortPowerCells(int teleOuterPortPowerCells) {
        // Avoids infinite loops
        if (teleOuterPortPowerCells != this.teleOuterPortPowerCells) {
            this.teleOuterPortPowerCells = teleOuterPortPowerCells;

            // Notify observers of a new value
            this.notifyPropertyChanged(BR.teleOuterPortPowerCells);
        }
    }

    public void setTeleInnerPortPowerCells(int teleInnerPortPowerCells) {
        // Avoids infinite loops
        if (teleInnerPortPowerCells != this.teleInnerPortPowerCells) {
            this.teleInnerPortPowerCells = teleInnerPortPowerCells;

            // Notify observers of a new value
            this.notifyPropertyChanged(BR.teleInnerPortPowerCells);
        }
    }

    public void setRotationControl(boolean rotationControl) {
        this.rotationControl = rotationControl;
        this.notifyPropertyChanged(BR.rotationControl);
    }

    public void setPositionControl(boolean positionControl) {
        this.positionControl = positionControl;
        this.notifyPropertyChanged(BR.positionControl);
    }

    public void setMovesToInitiationLine(boolean movesToInitiationLine) {
        this.movesToInitiationLine = movesToInitiationLine;
        this.notifyPropertyChanged(BR.movesToInitiationLine);
    }

    public void setEndgame(Endgame endgame) {
        // Avoids infinite loops
        if (endgame != this.endgame) {
            this.endgame = endgame;

            // Notify observers of a new value
            this.notifyPropertyChanged(BR.endgame);
        }
    }

    public void setMobility(Mobility mobility) {
        // Avoids infinite loops
        if (mobility != this.mobility) {
            this.mobility = mobility;

            // Notify observers of a new value
            this.notifyPropertyChanged(BR.mobility);
        }
    }

    public void setClimbDuration(ClimbDuration climbDuration) {
        // Avoids infinite loops
        if (climbDuration != this.climbDuration) {
            this.climbDuration = climbDuration;

            // Notify observers of a new value
            this.notifyPropertyChanged(BR.climbDuration);
        }
    }

    public void setAllianceColor(AllianceColor allianceColor) {
        // Avoids infinite loops
        if (allianceColor != this.allianceColor) {
            this.allianceColor = allianceColor;

            // Notify observers of a new value
            this.notifyPropertyChanged(BR.allianceColor);
        }
    }

    public void setComments(String comments) {
        // Avoids infinite loops
        if (!comments.equals(this.comments)) {
            this.comments = comments;

            // Notify observers of a new value
            this.notifyPropertyChanged(BR.comments);
        }
    }

    public void setScouterName(String scouterName) {
        // Avoids infinite loops
        if (!scouterName.equals(this.scouterName)) {
            this.scouterName = scouterName;

            // Notify observers of a new value
            this.notifyPropertyChanged(BR.scouterName);
        }
    }

    public void setRegionalName(String regionalName) {
        // Avoids infinite loops
        if (!regionalName.equals(this.regionalName)) {
            this.regionalName = regionalName;

            // Notify observers of a new value
            this.notifyPropertyChanged(BR.regionalName);
        }
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

}
