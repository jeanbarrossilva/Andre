package com.jeanbarrossilva.andre.extension

import android.animation.ValueAnimator

object ValueAnimatorX {
    @Suppress("UNCHECKED_CAST")
    fun <T> ValueAnimator.addUpdateListener(listener: (T) -> Unit): ValueAnimator {
        addUpdateListener { animator -> listener(animator.animatedValue as T) }
        return this
    }

    fun ValueAnimator.alongside(
        vararg animators: ValueAnimator,
        startsAutomatically: Boolean = true,
        duration: Long = 300
    ) = animators.asList().plus(this).forEach { animator ->
        animator.duration = duration
        if (startsAutomatically)
            animator.start()
    }
}