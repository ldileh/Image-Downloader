package com.ldileh.imagedownloadmanager

import android.content.Context
import android.widget.ImageView
import androidx.annotation.NonNull

import com.bumptech.glide.Glide
import com.bumptech.glide.RequestManager
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions

import java.io.File

class ImageDownloader(private val context: Context) {
    private var imageView: ImageView? = null

    private var glide: RequestManager? = null
    private var isCircleCrop = false
    private var placeholder = -1
    private var errorImage = -1
    private var memoryManagement = false

    fun target(imageView: ImageView): ImageDownloader {
        this.imageView = imageView

        return this
    }

    fun customRequestOptions(requestOptions: RequestOptions): ImageDownloader {
        this.glide = configureGlide(requestOptions)

        return this
    }

    fun setCircleCrop(circleCrop: Boolean): ImageDownloader {
        this.isCircleCrop = circleCrop

        return this
    }

    fun setPlaceholder(placeholder: Int): ImageDownloader {
        this.placeholder = placeholder

        return this
    }

    fun setErrorImage(errorImage: Int): ImageDownloader {
        this.errorImage = errorImage

        return this
    }

    fun setMemoryManagement(isUse: Boolean): ImageDownloader {
        this.memoryManagement = isUse

        return this
    }

    fun start(url: String) = imageView?.let { getGlide().load(url).into(it) }

    fun start(file: File) = imageView?.let { getGlide().load(file).into(it) }

    @NonNull
    private fun getGlide() : RequestManager = glide ?: configureGlide()

    @NonNull
    private fun configureGlide(requestOptions: RequestOptions): RequestManager = Glide
        .with(context)
        .applyDefaultRequestOptions(requestOptions)

    @NonNull
    private fun configureGlide(): RequestManager = Glide
        .with(context)
        .applyDefaultRequestOptions(defaultTransform())

    private fun defaultTransform(): RequestOptions {
        var requestOptions = RequestOptions()

        if (isCircleCrop){
            requestOptions = requestOptions.centerCrop()
            requestOptions = requestOptions.circleCrop()
        }

        if (placeholder != -1)
            requestOptions = requestOptions.placeholder(placeholder)

        if (errorImage != -1)
            requestOptions = requestOptions.placeholder(errorImage)

        if (memoryManagement) {
            requestOptions = requestOptions.skipMemoryCache(true)
            requestOptions = requestOptions.diskCacheStrategy(DiskCacheStrategy.NONE)
        }

        return requestOptions
    }
}
