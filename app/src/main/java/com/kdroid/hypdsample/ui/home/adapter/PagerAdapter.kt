package com.kdroid.hypdsample.ui.home.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.viewpager.widget.PagerAdapter
import com.kdroid.hypdsample.R
import com.nostra13.universalimageloader.cache.disc.naming.HashCodeFileNameGenerator
import com.nostra13.universalimageloader.core.DisplayImageOptions.Builder
import com.nostra13.universalimageloader.core.ImageLoader
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration
import com.nostra13.universalimageloader.core.display.RoundedBitmapDisplayer
import com.squareup.picasso.Picasso


class PagerAdapter(
    private val context: Context,
    private val list: ArrayList<String>,
) : PagerAdapter() {
    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val view: View = LayoutInflater.from(context).inflate(
            R.layout.item_view_home_banner,
            null
        )

        var imageView: ImageView? = null
        imageView = view.findViewById(R.id.iv)
//        val config =
//            ImageLoaderConfiguration.Builder(context) // You can pass your own memory cache implementation
//                .discCacheFileNameGenerator(HashCodeFileNameGenerator())
//                .build()
//
//        val options = Builder()
//            .displayer(RoundedBitmapDisplayer(30)) //rounded corner bitmap
//            .cacheInMemory(true)
//            .cacheOnDisc(true)
//            .build()
//
//        val imageLoader = ImageLoader.getInstance()
//        imageLoader.init(config)
//        imageLoader.displayImage(list[position], imageView, options)

        Picasso.get().load(list.get(position)).into(imageView)
        return view
    }

    override fun destroyItem(container: ViewGroup, position: Int, view: Any) {
        container.removeView(view as View)
    }

    override fun getCount(): Int {
        return list.size
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return `object` === view
    }
}