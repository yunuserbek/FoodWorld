package com.food.foodworld.utility

import android.content.Context
import android.graphics.PorterDuff
import android.graphics.drawable.Drawable
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.food.foodworld.R

fun ImageView.glideImage(url: String?) {
    Glide.with(this.rootView.context).load(url)
        .diskCacheStrategy(DiskCacheStrategy.DATA)
        .placeholder(this.context.circularProgressDrawable()).error(R.drawable.error).into(this)


}
fun Context.circularProgressDrawable(): Drawable {
    return CircularProgressDrawable(this).apply {
        strokeWidth = 5f
        centerRadius = 30f
        start()
    }
}
fun String.titleCaseFirstChar() = replaceFirstChar(Char::titlecase)
fun Context.showToast(message: String, duration: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(this, message, duration).show()
}
fun View.gone() {
    visibility = View.GONE
}

fun View.visible() {
    visibility = View.VISIBLE
}
//imageview render color
fun ImageView.setColor(colorResId: Int) {
    setColorFilter(ContextCompat.getColor(context, colorResId), PorterDuff.Mode.SRC_IN)
}
fun TextView.ColorText(colorResId: Int) {
    setTextColor(ContextCompat.getColor(context, colorResId))
}

fun View.visibleOrGone(boolean: Boolean) {
    if (boolean) {
        this.visible()
    } else {
        this.gone()
    }
}


