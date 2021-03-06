package com.jeanbarrossilva.andre.core.database.area

import android.content.Context
import android.graphics.Color
import androidx.annotation.ColorInt
import androidx.annotation.DrawableRes
import androidx.annotation.IntRange
import androidx.annotation.StringRes
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import com.jeanbarrossilva.andre.R
import java.io.Serializable

@Entity(tableName = "areas")
data class Area(
    var iconRes: Int = DEFAULT_ICON_RES,
    var name: String,
    var description: String,
    @ColorInt var color: Int,
    @IntRange(from = 0, to = 100) var attentionLevel: Int
) : Serializable {
    @PrimaryKey(autoGenerate = true)
    var id = 0L
    
    @Ignore
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
        iconRes = icon,
        name = context.getString(name),
        description = context.getString(description),
        color = color,
        attentionLevel = attentionLevel
    ) {
        isDefault = true
    }

    companion object {
        const val DEFAULT_ICON_RES = R.drawable.ic_help
        
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