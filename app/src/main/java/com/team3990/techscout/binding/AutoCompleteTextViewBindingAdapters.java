package com.team3990.techscout.binding;

import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.TextView;

import androidx.databinding.BindingAdapter;
import androidx.databinding.InverseBindingAdapter;
import androidx.databinding.InverseBindingListener;

public final class AutoCompleteTextViewBindingAdapters {

    @BindingAdapter("enum")
    public static void setTextValue(AutoCompleteTextView view, String value) {
        final String text = view.getText().toString();
        // Break potential infinite loops
        if (!text.equals(value)) {
            view.setText(value);
        }
    }

    @BindingAdapter("enumAttrChanged")
    public static void setListener(AutoCompleteTextView view, final InverseBindingListener listener) {
        view.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                final TextView textView = (TextView) v;
                if (hasFocus) {
                    // Delete contents of the EditText if the focus entered.
                    textView.setText("");
                } else {
                    // If the focus left, update the listener
                    listener.onChange();
                }
            }
        });
    }

    @InverseBindingAdapter(attribute = "enum")
    public static String getTextValue(AutoCompleteTextView autoCompleteTextView) {
        return autoCompleteTextView.getText().toString();
    }

}
