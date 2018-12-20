package com.ground0.transaction.di.component

import android.arch.persistence.room.RoomDatabase
import com.ground0.transaction.Main2Activity
import com.ground0.transaction.MainActivity
import com.ground0.transaction.di.module.ApplicationModule
import com.ground0.transaction.di.module.RoomModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import javax.inject.Singleton

@Singleton
@Component(dependencies = [], modules = [ApplicationModule::class, RoomModule::class])
interface AppComponent {

  fun inject(activity: Main2Activity)
  fun inject(activity: MainActivity)

//  fun database(): RoomDatabase
}