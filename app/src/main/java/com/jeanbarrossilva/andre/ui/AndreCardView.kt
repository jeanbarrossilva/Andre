package com.jeanbarrossilva.andre.ui

import android.content.Context
import android.util.AttributeSet
import android.view.MotionEvent
import androidx.cardview.widget.CardView

class AndreCardView: CardView {
	constructor(context: Context): super(context)
	
	constructor(context: Context, attrs: AttributeSet?): super(context, attrs)
	
	constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int):
		super(context, attrs, defStyleAttr)
	
	override fun onInterceptTouchEvent(ev: MotionEvent?) = true
}