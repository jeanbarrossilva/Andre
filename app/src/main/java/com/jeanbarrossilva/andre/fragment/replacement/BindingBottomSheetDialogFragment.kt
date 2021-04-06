package com.jeanbarrossilva.andre.fragment.replacement

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewbinding.ViewBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

open class BindingBottomSheetDialogFragment<VB : ViewBinding>(
    open val bindingBlock: (inflater: LayoutInflater, container: ViewGroup?) -> VB
) : BottomSheetDialogFragment() {
    lateinit var binding: VB
        private set

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = bindingBlock(inflater, container)
        return binding.root
    }
}