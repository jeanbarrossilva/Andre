package com.jeanbarrossilva.andre.extension

import android.text.Editable
import android.text.TextWatcher
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import androidx.core.content.getSystemService
import androidx.core.widget.doOnTextChanged

object EditTextX {
    fun EditText.doOnTextChanged(block: EditText.(String) -> Unit) =
        doOnTextChanged { text, _, _, _ ->
            if (text != null)
                block(this, text.toString())
        }
    
    fun EditText.doSilentlyOnTextChanged(block: EditText.(String) -> Unit) {
        val watcher =
            object: TextWatcher {
                override fun beforeTextChanged(
                    s: CharSequence?,
                    start: Int,
                    count: Int,
                    after: Int
                ) {
                }
    
                override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                    removeTextChangedListener(this)
                    s?.toString()?.let { text -> block(this@doSilentlyOnTextChanged, text) }
                    addTextChangedListener(this)
                }
    
                override fun afterTextChanged(s: Editable?) {
                }
            }
        addTextChangedListener(watcher)
    }
    
    fun EditText.focusWithInput() {
        requestFocus()
        context.getSystemService<InputMethodManager>()
            ?.showSoftInput(this, InputMethodManager.SHOW_FORCED)
    }

    fun EditText.placeCursorAtEnd() = setSelection(text.length)
}