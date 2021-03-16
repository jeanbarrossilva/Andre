package com.jeanbarrossilva.andre.extension

import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import androidx.core.content.getSystemService

object EditTextX {
    fun EditText.focusWithInput() {
        requestFocus()
        context.getSystemService<InputMethodManager>()
            ?.showSoftInput(this, InputMethodManager.SHOW_FORCED)
    }

    fun EditText.placeCursorAtEnd() = setSelection(text.length)
}