package com.shu.base.common

import android.app.Application
import android.content.Context
import com.shu.base.injection.component.AppComponent
import com.shu.base.injection.component.DaggerAppComponent
import com.shu.base.injection.module.AppModule

/**
 * Created by wangshufu on 2018/3/22.
 */
class BaseApplication : Application() {

    lateinit var appComponent: AppComponent

    companion object {
        lateinit var context:Context
    }

    override fun onCreate() {
        super.onCreate()

        initAppInjection()

        context = this
    }

    private fun initAppInjection() {
        appComponent = DaggerAppComponent.builder().appModule(AppModule(this)).build()
    }
}