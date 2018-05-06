package com.ground0.transaction.core.repository.network

import android.arch.lifecycle.MutableLiveData
import com.google.gson.GsonBuilder
import com.ground0.model.RetailTransaction
import com.ground0.transaction.BuildConfig
import com.ground0.transaction.core.repository.db.util.LocalDateTimeConverter
import io.reactivex.Flowable
import io.reactivex.Observable
import io.reactivex.ObservableOperator
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import org.threeten.bp.LocalDateTime
import retrofit2.Response
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
        .addConverterFactory(
            GsonConverterFactory.create(
                GsonBuilder().registerTypeAdapter(
                    LocalDateTime::class.java, LocalDateTimeConverter()
                ).create()
            )
        )
        .baseUrl(HOST)
        .build()

    restImp = retrofit.create(
        ApiStore::class.java
    )
  }

  fun getTransactions(): Flowable<List<RetailTransaction>> =
    restImp.getTransactions()

  fun getTransaction(id: Long): Flowable<RetailTransaction> =
    restImp.getTransaction(id)

  private fun <T> getLiveData(observable: Observable<T>): MutableLiveData<T> {
    val mutableLiveData = MutableLiveData<T>()
    observable.subscribeOn(Schedulers.newThread())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe({ mutableLiveData.postValue(it) },
            { it.printStackTrace() })
    return mutableLiveData
  }
}