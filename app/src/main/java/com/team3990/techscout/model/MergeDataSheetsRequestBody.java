package com.team3990.techscout.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public final class MergeDataSheetsRequestBody {

    /** Properties */

    @SerializedName("matchDataSheets")
    private final List<GameData> gameDataSheets;

    /**
     * Constructor
     *
     * Creates a new MergeDataSheetsRequestBody instance
     * */
    public MergeDataSheetsRequestBody(List<GameData> gameDataSheets) {
        this.gameDataSheets = gameDataSheets;
    }

}
