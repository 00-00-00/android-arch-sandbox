package com.ground0.transaction.core.repository

import com.ground0.model.Transaction
import com.ground0.transaction.BuildConfig
import io.reactivex.Observable
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by 00-00-00 on 05/05/18.
 */

object CloudStore {
  
  private val HOST = "${BuildConfig.HOST}${BuildConfig.API_VERSION}/"
  private lateinit var restImp: ApiStore

  fun init() {
    val retrofit = Retrofit.Builder()
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(HOST)
        .build()

    restImp = retrofit.create(ApiStore::class.java)
  }

  fun getTransactions(): Observable<List<Transaction>> =
    restImp.getTransactions()

}