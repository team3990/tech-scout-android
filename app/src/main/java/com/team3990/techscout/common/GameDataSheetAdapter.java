package com.team3990.techscout.common;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.team3990.techscout.R;
import com.team3990.techscout.databinding.HolderMatchDataSheetBinding;
import com.team3990.techscout.model.GameData;
import com.team3990.techscout.view.GameDataSheetHolder;

import java.util.ArrayList;
import java.util.List;

public final class GameDataSheetAdapter extends RecyclerView.Adapter<GameDataSheetHolder> {

    /** Properties */

    private List<GameData> mDataSheets = new ArrayList<>();

    /** Setters */

    public void setDataSheets(List<GameData> dataSheets) {
        mDataSheets = dataSheets;
        notifyDataSetChanged();
    }

    /** Methods */

    @Override
    public int getItemCount() {
        return mDataSheets.size();
    }

    @NonNull
    @Override
    public GameDataSheetHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        final LayoutInflater inflater = LayoutInflater.from(parent.getContext());

        // Get an instance of the holder's binding
        final HolderMatchDataSheetBinding binding = DataBindingUtil.inflate(inflater, R.layout.holder_match_data_sheet, parent, false);

        return new GameDataSheetHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull GameDataSheetHolder holder, int position) {
        final GameData dataSheet = mDataSheets.get(position);

        // Set the data sheet displayed by the item
        holder.getBinding().setDatasheet(dataSheet);
    }

}
