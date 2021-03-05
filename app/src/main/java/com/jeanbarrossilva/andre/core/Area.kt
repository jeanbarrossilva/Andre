package com.jeanbarrossilva.andre.core

import android.content.Context
import android.graphics.Color
import android.graphics.drawable.Icon
import androidx.annotation.ColorInt
import androidx.annotation.DrawableRes
import androidx.annotation.IntRange
import androidx.annotation.StringRes
import com.jeanbarrossilva.andre.R
import java.io.Serializable

data class Area(
    var icon: Icon,
    var name: String,
    var description: String,
    @ColorInt var color: Int,
    @IntRange(from = 0, to = 100) var attentionLevel: Int
) : Serializable {
    var isDefault = false
        private set

    /**
     * [Area]s built with this constructor are considered default.
     *
     * @see [isDefault]
     **/
    private constructor(
        context: Context,
        @DrawableRes icon: Int,
        @StringRes name: Int,
        @StringRes description: Int,
        @ColorInt color: Int,
        attentionLevel: Int
    ) : this(
        Icon.createWithResource(context, icon),
        context.getString(name),
        context.getString(description),
        color,
        attentionLevel
    ) {
        isDefault = true
    }

    init {
        icon.setTint(color)
    }

    companion object {
        fun getDefaultIcon(context: Context): Icon? =
            Icon.createWithResource(context, R.drawable.ic_help)
        
        fun getDefault(context: Context): List<Area> {
            val family =
                Area(
                    context,
                    icon = R.drawable.ic_family_restroom,
                    name = R.string.Area_name_family,
                    description = R.string.Area_description_family,
                    color = context.getColor(R.color.familyArea),
                    attentionLevel = 50
                )
            val health =
                Area(
                    context,
                    icon = R.drawable.ic_favorite,
                    name = R.string.Area_name_health,
                    description = R.string.Area_description_health,
                    color = Color.parseColor("#EF233C"),
                    attentionLevel = 25
                )
            val knowledge =
                Area(
                    context,
                    icon = R.drawable.ic_book,
                    name = R.string.Area_name_knowledge,
                    description = R.string.Area_description_knowledge,
                    color = Color.parseColor("#4895EF"),
                    attentionLevel = 5
                )
            val work =
                Area(
                    context,
                    icon = R.drawable.ic_work,
                    name = R.string.Area_name_work,
                    description = R.string.Area_description_work,
                    color = Color.parseColor("#74C69D"),
                    attentionLevel = 80
                )

            return listOf(family, health, knowledge, work)
        }
    }
}