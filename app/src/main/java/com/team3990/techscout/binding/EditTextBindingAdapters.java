package com.team3990.techscout.binding;

import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.databinding.BindingAdapter;
import androidx.databinding.InverseBindingAdapter;
import androidx.databinding.InverseBindingListener;

public final class EditTextBindingAdapters {

    /**
     * Needs to be used with [IntegerConverters.setIntegerToString].
     */
    @BindingAdapter("integer")
    public static void setIntegerTextValue(EditText view, String value) {
        final String text = view.getText().toString();
        // Break potential infinite loops
        if (!text.equals(value)) {
            view.setText(value);
        }
    }

    /**
     * Needs to be used with [DecimalConverters.setDecimalToString].
     */
    @BindingAdapter("decimal")
    public static void setDecimalTextValue(EditText view, String value) {
        final String text = view.getText().toString();
        // Break potential infinite loops
        if (!text.equals(value)) {
            view.setText(value);
        }
    }

    /**
     * This Binding Adapter is not defined in the XML. "AttrChanged" is a special
     * suffix that lets us manage changes in the value, using two-way Data Binding.
     * */
    @BindingAdapter("integerAttrChanged")
    public static void setIntegerListener(EditText view, final InverseBindingListener listener) {
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

    /**
     * This Binding Adapter is not defined in the XML. "AttrChanged" is a special
     * suffix that lets us manage changes in the value, using two-way Data Binding.
     * */
    @BindingAdapter("decimalAttrChanged")
    public static void setDecimalListener(EditText view, final InverseBindingListener listener) {
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

    /**
     * Used with the inverse method of [IntegerConverters.setIntegerToString], which is
     * [IntegerConverters.stringToInteger].
     */
    @InverseBindingAdapter(attribute = "integer")
    public static String getIntegerTextValue(EditText editText) {
        return editText.getText().toString();
    }

    /**
     * Used with the inverse method of [DecimalConverters.setDecimalToString], which is
     * [DecimalConverters.setDecimalToString.stringToDecimal].
     */
    @InverseBindingAdapter(attribute = "decimal")
    public static String getDecimalTextValue(EditText editText) {
        return editText.getText().toString();
    }

}
