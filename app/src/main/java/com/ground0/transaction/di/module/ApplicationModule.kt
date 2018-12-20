package com.ground0.transaction.di.module

import android.content.Context
import dagger.Module
import dagger.Provides
import javax.inject.Named
import javax.inject.Singleton


@Module
class ApplicationModule(val context: Context) {
    
    @Provides
    @Singleton
    fun providesApplicationContext(): Context {
        return context;
    }
}