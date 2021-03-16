package com.jeanbarrossilva.andre.core

import android.content.Context
import android.graphics.Color
import androidx.annotation.ColorInt
import androidx.annotation.DrawableRes
import com.jeanbarrossilva.andre.R
import java.io.Serializable

@Suppress("Unused")
sealed class Area(
	@DrawableRes val iconRes: Int,
	val title: String,
	@ColorInt val color: Int,
	val subareas: List<Subarea>
): Serializable {
	class LifeQuality(context: Context):
		Area(
			R.drawable.ic_multiline_chart,
			title = context.getString(R.string.Area_name_life_quality),
			Color.parseColor("#F57C00"),
			listOf(
				Subarea.Health(context),
				Subarea.Lounge(context),
				Subarea.Spirituality(context)
			)
		)
	
	class Personal(context: Context):
		Area(
			R.drawable.ic_person,
			title = context.getString(R.string.Area_name_personal),
			Color.parseColor("#EF233C"),
			listOf(
				Subarea.Emotional(context),
				Subarea.Happiness(context),
				Subarea.Intellect(context),
			)
		)
	
	class Professional(context: Context):
		Area(
			R.drawable.ic_architecture,
			title = context.getString(R.string.Area_name_professional),
			Color.parseColor("#4895EF"),
			listOf(
				Subarea.Career(context),
				Subarea.Contribution(context),
				Subarea.Finances(context)
			)
		)
	
	class Relationships(context: Context):
		Area(
			R.drawable.ic_escalator_warning,
			title = context.getString(R.string.Area_name_relationships),
			Color.parseColor("#74C69D"),
			listOf(
				Subarea.Family(context),
				Subarea.Love(context),
				Subarea.Social(context)
			)
		)
	
	companion object {
		fun values(context: Context?) =
			context
				?.let {
					listOf(
						LifeQuality(context),
						Personal(context),
						Professional(context),
						Relationships(context)
					)
				}
				.orEmpty()
	}
}