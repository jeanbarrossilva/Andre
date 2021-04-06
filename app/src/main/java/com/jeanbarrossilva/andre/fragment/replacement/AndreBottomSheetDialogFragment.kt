package com.jeanbarrossilva.andre.fragment.replacement

import android.content.DialogInterface
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewGroup.LayoutParams.MATCH_PARENT
import android.view.ViewGroup.LayoutParams.WRAP_CONTENT
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.FragmentManager
import androidx.viewbinding.ViewBinding
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.jeanbarrossilva.andre.R
import com.jeanbarrossilva.andre.databinding.FragmentAndreBottomSheetDialogBinding
import com.jeanbarrossilva.andre.extension.BottomSheetDialogFragmentX.behavior
import com.jeanbarrossilva.andre.extension.BottomSheetDialogFragmentX.sheet
import com.jeanbarrossilva.andre.extension.ViewX.setOnSoftInputListener

open class  AndreBottomSheetDialogFragment<VB : ViewBinding>(
    override val bindingBlock: (inflater: LayoutInflater, container: ViewGroup?) -> VB
) : BindingBottomSheetDialogFragment<VB>(bindingBlock) {
    private lateinit var bottomSheetBinding: FragmentAndreBottomSheetDialogBinding
    private val onShowListeners = mutableListOf<DialogInterface.OnShowListener>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStyle(DialogFragment.STYLE_NORMAL, R.style.Theme_Andre_BottomSheet)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        super.onCreateView(inflater, container, savedInstanceState)
        bottomSheetBinding =
            FragmentAndreBottomSheetDialogBinding.inflate(inflater, container, false)
        bottomSheetBinding.content.addView(binding.root)
        binding.root.layoutParams = ConstraintLayout.LayoutParams(MATCH_PARENT, WRAP_CONTENT)
        return bottomSheetBinding.root
    }
    
    override fun onCreateDialog(savedInstanceState: Bundle?) =
        super.onCreateDialog(savedInstanceState).apply {
            setCanceledOnTouchOutside(true)
            setOnShowListener { sheet?.setBackgroundColor(Color.TRANSPARENT) }
            window?.setWindowAnimations(R.style.Theme_Andre_BottomSheet_Animations)
            window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            window?.decorView?.setOnSoftInputListener { isVisible -> if (isVisible) expand() }
            expand()
        }

    override fun show(manager: FragmentManager, tag: String?) {
        super.show(manager, tag)
        triggerOnShowListeners()
    }

    override fun showNow(manager: FragmentManager, tag: String?) {
        super.showNow(manager, tag)
        triggerOnShowListeners()
    }

    private fun triggerOnShowListeners() = onShowListeners.forEach { it.onShow(dialog) }

    private fun expand() {
        behavior?.state = BottomSheetBehavior.STATE_EXPANDED
    }

    fun setOnShowListener(listener: DialogInterface.OnShowListener) {
        onShowListeners.add(listener)
    }
}