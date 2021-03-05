package com.jeanbarrossilva.andre.ui

import android.content.Context
import android.graphics.Typeface.BOLD
import android.util.AttributeSet
import android.view.Gravity
import android.widget.LinearLayout
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.view.setPadding
import com.jeanbarrossilva.andre.R
import com.jeanbarrossilva.andre.extension.ContextX.colorOf
import com.jeanbarrossilva.andre.extension.ContextX.drawableOf
import com.jeanbarrossilva.andre.extension.ContextX.withStyledAttributes
import com.jeanbarrossilva.andre.extension.NumberX.dp
import java.text.NumberFormat

class GenerosityBoxButton: CardView {
	private lateinit var layout: AndreLinearLayout
	private lateinit var emojiHeadlineLayout: AndreLinearLayout
	private lateinit var emojiView: TextView
	private lateinit var headlineLayout: AndreLinearLayout
	private lateinit var titleView: TextView
	private lateinit var priceView: TextView
	
	var emoji = ""
		set(value) {
			field = value
			emojiView.text = value
		}
	var title = ""
		set(value) {
			field = value
			titleView.text = value
		}
	var price = 0f
		set(value) {
			field = value
			priceView.text = NumberFormat.getCurrencyInstance().format(value)
		}
	
	constructor(context: Context): super(context) {
		init()
	}
	
	constructor(context: Context, attrs: AttributeSet?): super(context, attrs) {
		init(attrs)
	}
	
	constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int):
		super(context, attrs, defStyleAttr) {
			init(attrs, defStyleAttr)
		}
	
	private fun initViews(attrs: AttributeSet?, defStyleAttr: Int) {
		layout =
			AndreLinearLayout(context, attrs, defStyleAttr).apply {
				isClickable = true
				background = context drawableOf android.R.attr.selectableItemBackground
				setPadding(25.dp(context))
			}
		emojiHeadlineLayout =
			AndreLinearLayout(context, attrs, defStyleAttr).apply {
				gravity = Gravity.CENTER_VERTICAL
				horizontalSpacing = 30.dp(context).toFloat()
			}
		emojiView = TextView(context, attrs, defStyleAttr).apply { textSize = 20f }
		headlineLayout =
			AndreLinearLayout(context, attrs, defStyleAttr).apply {
				orientation = LinearLayout.VERTICAL
				verticalSpacing = 2.dp(context).toFloat()
			}
		titleView =
			TextView(context, attrs, defStyleAttr).apply {
				textSize = 17f
				setTypeface(typeface, BOLD)
			}
		priceView = TextView(context, attrs, defStyleAttr).apply {
			setTextColor(context colorOf android.R.attr.colorControlNormal)
		}
	}
	
	private fun getAttrs(attrs: AttributeSet?, defStyleAttr: Int) =
		context.withStyledAttributes(attrs, defStyleAttr, R.styleable.GenerosityBoxButton) {
			when (it) {
				R.styleable.GenerosityBoxButton_emoji -> emoji = getString(it).toString()
				R.styleable.GenerosityBoxButton_android_title -> title = getString(it).toString()
				R.styleable.GenerosityBoxButton_price -> price = getFloat(it, price)
			}
		}
	
	private fun addViews() {
		addView(layout)
		layout.addView(emojiHeadlineLayout)
		emojiHeadlineLayout.addView(emojiView)
		emojiHeadlineLayout.addView(headlineLayout)
		headlineLayout.addView(titleView)
		headlineLayout.addView(priceView)
	}
	
	private fun init(attrs: AttributeSet? = null, defStyleAttr: Int = 0) {
		initViews(attrs, defStyleAttr)
		getAttrs(attrs, defStyleAttr)
		addViews()
	}
	
	init {
		radius = 20.dp(context).toFloat()
	}
}