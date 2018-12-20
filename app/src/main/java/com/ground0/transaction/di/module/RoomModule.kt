package com.ground0.transaction.di.module

import android.arch.persistence.room.Room
import android.content.Context
import com.ground0.transaction.core.repository.db.RoomDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Inject
import javax.inject.Singleton

@Module
class RoomModule {

  @Inject lateinit var context: Context

  private var databaseImp: RoomDatabase =
    Room.databaseBuilder(context, RoomDatabase::class.java, "transaction_db")
        .build()

  @Provides
  @Singleton
  fun providesDatabase(): RoomDatabase {
    return databaseImp
  }

}