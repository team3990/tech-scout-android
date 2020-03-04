package com.team3990.techscout.binding;

import androidx.databinding.BindingMethod;
import androidx.databinding.BindingMethods;
import androidx.annotation.RestrictTo;
import android.widget.AutoCompleteTextView;

/**
 * @hide
 */
@RestrictTo(RestrictTo.Scope.LIBRARY)
@BindingMethods({
        @BindingMethod(type = AutoCompleteTextView.class, attribute = "onItemClick", method = "setOnItemClickListener"),
})
public class AutoCompleteTextViewBindingAdapter { /** Empty class body */ }
