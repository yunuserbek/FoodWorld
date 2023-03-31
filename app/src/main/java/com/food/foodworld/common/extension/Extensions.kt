package com.food.foodworld.common.extension

import android.content.Context
import android.graphics.drawable.Drawable
import android.view.View
import android.widget.ImageView
import androidx.datastore.preferences.preferencesDataStore
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.food.foodworld.R

fun ImageView.glideImage(url: String?) {
    Glide.with(this.context).load(url)
        .diskCacheStrategy(DiskCacheStrategy.DATA)
        .placeholder(this.context.circularProgressDrawable()).error(R.drawable.exclamation).into(this)


}
fun Context.circularProgressDrawable(): Drawable {
    return CircularProgressDrawable(this).apply {
        strokeWidth = 5f
        centerRadius = 30f
        start()
    }
}
fun String.titleCaseFirstChar() = replaceFirstChar(Char::titlecase)

fun View.gone() {
    visibility = View.GONE
}

fun View.visible() {
    visibility = View.VISIBLE
}


