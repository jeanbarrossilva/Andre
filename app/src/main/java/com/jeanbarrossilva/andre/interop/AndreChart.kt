package com.jeanbarrossilva.andre.interop

import android.view.View

interface AndreChart<OE, V: View> {
	val view: V
	var entries
		get() = listOf<AndreChartEntry<OE>>()
		set(value) {
		}
	
	interface OnSelectEntryListener<O> {
		fun onSelectEntry(entry: AndreChartEntry<O>)
		
		companion object {
			operator fun <O> invoke(block: (AndreChartEntry<O>) -> Unit) =
				object: OnSelectEntryListener<O> {
					override fun onSelectEntry(entry: AndreChartEntry<O>) = block(entry)
				}
		}
	}
	
	fun setShowEntryLabels(showsEntryLabels: Boolean)
	
	fun setShowEntryValues(showsEntryValues: Boolean)
	
	fun add(entry: AndreChartEntry<OE>)
	
	fun add(entries: List<AndreChartEntry<OE>>) = entries.forEach { entry -> add(entry) }
	
	fun setOnSelectEntryListener(listener: OnSelectEntryListener<OE>)
	
	fun setOnSelectEntryListener(listener: (AndreChartEntry<OE>) -> Unit) =
		setOnSelectEntryListener(OnSelectEntryListener { listener(it) })
}