package com.jeanbarrossilva.andre.ui

import android.animation.ObjectAnimator
import android.content.Context
import android.content.res.ColorStateList
import android.os.Build
import android.util.AttributeSet
import android.view.Gravity
import android.view.View
import android.widget.ImageView
import androidx.annotation.ColorInt
import androidx.appcompat.widget.AppCompatEditText
import com.jeanbarrossilva.andre.R
import com.jeanbarrossilva.andre.extension.ContextX.colorOf
import com.jeanbarrossilva.andre.extension.ContextX.withStyledAttributes
import com.jeanbarrossilva.andre.extension.EditTextX.focusWithInput
import com.jeanbarrossilva.andre.extension.EditTextX.placeCursorAtEnd
import com.jeanbarrossilva.andre.extension.NumberX.dp
import com.jeanbarrossilva.andre.extension.ValueAnimatorX.addUpdateListener
import com.jeanbarrossilva.andre.extension.ValueAnimatorX.alongside

class AndreEditTextLayout : AndreLinearLayout {
    private lateinit var iconView: ImageView
    private val iconRes = R.drawable.ic_edit
    private var preferredXmlDefinedTextSize = 16f
    private var preferredXmlDefinedTextColor = context colorOf android.R.attr.colorControlNormal

    lateinit var field: AndreEditText
        private set

    constructor(context: Context) : super(context) {
        init()
    }

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {
        init(attrs)
    }

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) :
        super(context, attrs, defStyleAttr) {
        init(attrs, defStyleAttr)
    }

    inner class AndreEditText internal constructor(
        context: Context,
        attrs: AttributeSet?,
        defStyleAttr: Int
    ) : AppCompatEditText(context, attrs, defStyleAttr) {
        override fun setEnabled(enabled: Boolean) {
            val elevation = if (enabled) 2f else 0f
            val horizontalPadding = if (enabled) 20.dp(context) else 0
            val verticalPadding = if (enabled) 10.dp(context) else 0

            super.setEnabled(enabled)
            this.elevation = elevation
            updateHorizontalPaddingAnimating(horizontalPadding)
            updateVerticalPaddingAnimating(verticalPadding)
            if (enabled) {
                isFocusableInTouchMode = true
            } else {
                setTextColor(preferredXmlDefinedTextColor)
                isFocusable = false
            }
        }

        private fun updatePaddingAnimating(left: Int, top: Int, right: Int, bottom: Int) {
            ObjectAnimator
                .ofInt(paddingLeft, left)
                .addUpdateListener<Int> { setPadding(it, paddingTop, paddingRight, paddingBottom) }
                .alongside(
                    ObjectAnimator
                        .ofInt(paddingTop, top)
                        .addUpdateListener<Int> {
                            setPadding(paddingLeft, it, paddingRight, paddingBottom)
                        },
                    ObjectAnimator
                        .ofInt(paddingRight, right)
                        .addUpdateListener<Int> {
                            setPadding(paddingLeft, paddingTop, it, paddingBottom)
                        },
                    ObjectAnimator
                        .ofInt(paddingBottom, bottom)
                        .addUpdateListener<Int> {
                            setPadding(paddingLeft, paddingTop, paddingRight, it)
                        },
                    duration = 150
                )
        }

        private fun updateHorizontalPaddingAnimating(horizontal: Int) =
            updatePaddingAnimating(horizontal, paddingTop, horizontal, paddingBottom)

        private fun updateVerticalPaddingAnimating(vertical: Int) =
            updatePaddingAnimating(paddingLeft, vertical, paddingRight, vertical)

        init {
            textSize = preferredXmlDefinedTextSize
            setTextColor(preferredXmlDefinedTextColor)
        }
    }

    override fun setEnabled(enabled: Boolean) {
        val iconVisibility = if (enabled) View.VISIBLE else View.GONE
        field.isEnabled = enabled
        iconView.visibility = iconVisibility
    }

    private fun initViews(attrs: AttributeSet?, defStyleAttr: Int) {
        iconView =
            ImageView(context, attrs, defStyleAttr).apply {
                setImageResource(iconRes)
                layoutParams = LayoutParams(15.dp(context), 15.dp(context))
            }
        field = AndreEditText(context, attrs, defStyleAttr)
    }

    private fun getAttributes(attrs: AttributeSet?, defStyleAttr: Int) =
        context.withStyledAttributes(attrs, defStyleAttr, R.styleable.AndreEditText) {
            when (it) {
                R.styleable.AndreEditText_android_textSize ->
                    preferredXmlDefinedTextSize = getDimension(it, preferredXmlDefinedTextSize)
                R.styleable.AndreEditText_android_textColor ->
                    preferredXmlDefinedTextColor = getColor(it, preferredXmlDefinedTextColor)
            }
        }

    private fun addViews() {
        addView(iconView)
        addView(field)
    }

    private fun init(attrs: AttributeSet? = null, defStyleAttr: Int = 0) {
        gravity = Gravity.CENTER_VERTICAL
        horizontalSpacing = 15.dp(context).toFloat()
        setOnClickListener {
            field.focusWithInput()
            field.placeCursorAtEnd()
        }
        initViews(attrs, defStyleAttr)
        isEnabled = false
        getAttributes(attrs, defStyleAttr)
        addViews()

    }

    fun setTint(@ColorInt color: Int) {
        iconView.imageTintList = ColorStateList.valueOf(color)
        field.highlightColor = color
        if (Build.VERSION.SDK_INT >= 29) {
            field.textCursorDrawable?.setTint(color)
            field.textSelectHandle?.setTint(color)
        }
    }
}