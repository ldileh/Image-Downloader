# Image-Downloader

how to using this library on kotlin :

**1. apply plugin kotlin-kapt**
```
apply plugin: 'kotlin-kapt'
```
**2. add this lines to build.gradle module app**
```
dependencies {
...
	/* start image downloader */
	implementation 'com.github.ldileh:Image-Downloader:0.02'
	// glide
	implementation 'com.github.bumptech.glide:glide:4.11.0'
	kapt 'com.github.bumptech.glide:compiler:4.11.0'
	// okhttp
	implementation 'com.squareup.okhttp3:okhttp:3.12.0'
	/* end main library */
...
}
```
**3. add this line to build.gradle on current project**
```
maven { url 'https://jitpack.io' }
```
