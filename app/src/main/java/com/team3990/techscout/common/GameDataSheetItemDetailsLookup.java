package com.team3990.techscout.common;

import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.selection.ItemDetailsLookup;
import androidx.recyclerview.widget.RecyclerView;

import com.team3990.techscout.view.GameDataSheetHolder;

public final class GameDataSheetItemDetailsLookup extends ItemDetailsLookup<Long> {

    /** Properties */

    private final RecyclerView mRecyclerView;

    /**
     * Constructor
     *
     * Creates a new MatchDataSheetItemDetailsLookup instance
     * */
    public GameDataSheetItemDetailsLookup(RecyclerView recyclerView) {
        mRecyclerView = recyclerView;
    }

    /** Methods */

    @Nullable
    @Override
    public ItemDetails<Long> getItemDetails(@NonNull MotionEvent e) {
        final View view = mRecyclerView.findChildViewUnder(e.getX(), e.getY());
        // Return the details of the recycler view item corresponding to the
        // selected view, if applicable
        if (view != null) {
            final RecyclerView.ViewHolder holder = mRecyclerView.getChildViewHolder(view);
            if (holder instanceof GameDataSheetHolder) {
                return ((GameDataSheetHolder) holder).getItemDetails();
            }
        }
        return null;
    }

}
