package com.example.supershop

import android.app.Application

class SuperShopApplication:Application() {
    override fun onCreate() {
        super.onCreate()
        Graph.provide(this)
    }
}