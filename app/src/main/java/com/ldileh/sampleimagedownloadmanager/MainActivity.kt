package com.ldileh.sampleimagedownloadmanager

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ldileh.imagedownloadmanager.ImageDownloader

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        ImageDownloader(this).setPlaceholder(1).start("")
    }
}
