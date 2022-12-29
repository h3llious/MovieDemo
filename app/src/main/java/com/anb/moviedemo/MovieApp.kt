package com.anb.moviedemo

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class MovieApp: Application() {
    override fun onCreate() {
        super.onCreate()
    }
}
