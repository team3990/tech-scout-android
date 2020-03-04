package com.team3990.techscout.view;

import androidx.recyclerview.selection.ItemDetailsLookup;
import androidx.recyclerview.widget.RecyclerView;

import com.team3990.techscout.databinding.HolderMatchDataSheetBinding;

public final class GameDataSheetHolder extends RecyclerView.ViewHolder {

    /** Properties */

    private HolderMatchDataSheetBinding mBinding;

    /**
     * Constructor
     *
     * Creates a new GameDataSheetHolder instance.
     * */
    public GameDataSheetHolder(HolderMatchDataSheetBinding binding) {
        super(binding.getRoot());
        mBinding = binding;
    }

    /** Methods */

    public HolderMatchDataSheetBinding getBinding() { return mBinding; }

    public ItemDetailsLookup.ItemDetails<Long> getItemDetails() {
        return new ItemDetailsLookup.ItemDetails<Long>() {
            @Override
            public int getPosition() { return getAdapterPosition(); }

            @Override
            public Long getSelectionKey() { return getItemId(); }
        };
    }

}
