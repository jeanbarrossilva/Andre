package com.jeanbarrossilva.andre.core

import android.content.Context
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.jeanbarrossilva.andre.R

sealed class Subarea(
	@DrawableRes val iconRes: Int,
	val title: String,
	open var indicator: SubareaIndicator = SubareaIndicator.Unset
) {
	constructor(context: Context, @DrawableRes iconRes: Int, @StringRes titleRes: Int):
		this(iconRes, context.getString(titleRes))

	class Health(context: Context):
		Subarea(context, R.drawable.ic_health_and_safety, R.string.Subarea_name_health)

	class Lounge(context: Context):
		Subarea(context, R.drawable.ic_golf_course, R.string.Subarea_name_lounge)

	class Spirituality(context: Context):
		Subarea(context, R.drawable.ic_hiking, R.string.Subarea_name_spirituality)

	class Emotional(context: Context):
		Subarea(context, R.drawable.ic_mood_bad, R.string.Subarea_name_emotional)

	class Happiness(context: Context):
		Subarea(context, R.drawable.ic_mood, R.string.Subarea_name_happiness)

	class Intellect(context: Context):
		Subarea(context, R.drawable.ic_psychology, R.string.Subarea_name_intellect)

	class Career(context: Context):
		Subarea(context, R.drawable.ic_work, R.string.Subarea_name_career)

	class Contribution(context: Context):
		Subarea(context, R.drawable.ic_thumb_up, R.string.Subarea_name_contribution)

	class Finances(context: Context):
		Subarea(context, R.drawable.ic_savings, R.string.Subarea_name_finances)

	class Family(context: Context):
		Subarea(context, R.drawable.ic_family_restroom, R.string.Subarea_name_family)

	class Love(context: Context):
		Subarea(context, R.drawable.ic_favorite, R.string.Subarea_name_love)

	class Social(context: Context):
		Subarea(context, R.drawable.ic_groups, R.string.Subarea_name_social)

	companion object {
		/**
		 * Returns a list of [Subarea]s that doesn't have an [SubareaIndicator.Unset] [indicator].
		 **/
		val List<Subarea>.indicative
			get() = filter { subarea -> subarea.indicator !is SubareaIndicator.Unset }
	}
}