package com.ldileh.sampleimagedownloadmanager

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ldileh.imagedownloadmanager.ImageDownloader
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        ImageDownloader(this)
            .target(iv_image)
            .start("https://banner2.cleanpng.com/20180419/evq/kisspng-google-logo-google-search-google-account-redes-5ad81f9d785f93.4350404715241133094931.jpg")
    }
}
