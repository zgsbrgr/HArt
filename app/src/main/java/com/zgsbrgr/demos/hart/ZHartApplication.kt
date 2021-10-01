package com.zgsbrgr.demos.hart

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class ZHartApplication: Application() {

    override fun onCreate() {
        super.onCreate()
    }
}