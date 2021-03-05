package com.jeanbarrossilva.andre.viewmodel.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import kotlin.reflect.KClass
import kotlin.reflect.full.primaryConstructor

@Suppress("UNCHECKED_CAST")
class AndreViewModelFactory<VM : ViewModel>(
	private val viewModelClass: KClass<VM>,
	private val args: Array<Any?>
): ViewModelProvider.Factory {
	override fun <T: ViewModel?> create(modelClass: Class<T>): T =
		viewModelClass.primaryConstructor?.call(*args) as T
	
	companion object {
		inline fun <reified VM : ViewModel> factoryOf(vararg args: Any?) =
			AndreViewModelFactory(VM::class, args.toList().toTypedArray())
	}
}