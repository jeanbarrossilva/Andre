package com.jeanbarrossilva.andre.extension

import android.widget.FrameLayout
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

object BottomSheetDialogFragmentX {
    val BottomSheetDialogFragment.behavior get() = sheet?.let { BottomSheetBehavior.from(it) }
    val BottomSheetDialogFragment.sheet
        get() = dialog?.findViewById<FrameLayout>(com.google.android.material.R.id.design_bottom_sheet)
}