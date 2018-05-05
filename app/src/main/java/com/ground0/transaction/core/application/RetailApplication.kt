package com.ground0.transaction.core.application

import android.app.Application
import com.jakewharton.threetenabp.AndroidThreeTen

/**
 * Created by 00-00-00 on 05/05/18.
 */


class RetailApplication: Application() {
  override fun onCreate() {
    super.onCreate()
    AndroidThreeTen.init(this)
  }
}