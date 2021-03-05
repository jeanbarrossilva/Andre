package com.jeanbarrossilva.andre.ui

import android.content.Context
import android.util.AttributeSet
import android.widget.LinearLayout
import com.jeanbarrossilva.andre.R
import com.jeanbarrossilva.andre.extension.ContextX.withStyledAttributes
import top.defaults.drawabletoolbox.DrawableBuilder

@Suppress("MemberVisibilityCanBePrivate")
open class AndreLinearLayout : LinearLayout {
    var horizontalSpacing = 0f
        set(value) {
            field = value
            setHorizontalSpacingOf(value)
        }
    var verticalSpacing = 0f
        set(value) {
            field = value
            setVerticalSpacingOf(value)
        }

    private val drawableBuilder =
        DrawableBuilder().width(horizontalSpacing.toInt()).width(verticalSpacing.toInt())

    constructor(context: Context) : super(context)

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {
        getAttributes(attrs, 0)
    }

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) :
        super(context, attrs, defStyleAttr) {
            getAttributes(attrs, defStyleAttr)
        }

    private fun setHorizontalSpacingOf(spacing: Float) {
        dividerDrawable = drawableBuilder.width(spacing.toInt()).build()
    }

    private fun setVerticalSpacingOf(spacing: Float) {
        dividerDrawable = drawableBuilder.height(spacing.toInt()).build()
    }

    private fun getAttributes(attrs: AttributeSet?, defStyleAttr: Int) {
        context?.withStyledAttributes(attrs, defStyleAttr, R.styleable.AndreLinearLayout) {
            when (it) {
                R.styleable.AndreLinearLayout_android_horizontalSpacing ->
                    horizontalSpacing = getDimension(it, horizontalSpacing)
                R.styleable.AndreLinearLayout_android_verticalSpacing ->
                    verticalSpacing = getDimension(it, verticalSpacing)
            }
        }
    }

    init {
        showDividers = SHOW_DIVIDER_MIDDLE
    }
}