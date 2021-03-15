package com.jeanbarrossilva.andre.extension

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import kotlin.reflect.full.primaryConstructor

object FragmentTransactionX {
	inline fun <reified F: Fragment> FragmentTransaction.add(tag: String? = F::class.simpleName) =
		add(F::class.primaryConstructor!!.call(), tag)
}