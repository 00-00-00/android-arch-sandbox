package com.ground0.transaction.core.repository.retailtransaction

import com.google.gson.GsonBuilder
import com.ground0.model.RetailTransaction
import com.ground0.transaction.BuildConfig
import com.ground0.transaction.core.repository.Repository
import com.ground0.transaction.core.repository.db.util.LocalDateTimeConverter
import com.ground0.transaction.core.repository.network.util.HttpStatusOperator
import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers
import org.threeten.bp.LocalDateTime
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by 00-00-00 on 05/05/18.
 */

object RetailTransactionCloudStore: Repository<RetailTransaction> {

  private const val HOST = "${BuildConfig.HOST}${BuildConfig.API_VERSION}/"
  private lateinit var restImp: RetailTransactionApiStore

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
        .baseUrl(
            HOST
        )
        .build()

    restImp = retrofit.create(
        RetailTransactionApiStore::class.java
    )
  }

  override fun get(): Observable<List<RetailTransaction>> =
    restImp.getTransactions().adapt()

  override fun get(id: Long): Observable<RetailTransaction> =
    restImp.getTransaction(id).adapt()

  override fun post(retailTransactions: List<RetailTransaction>): Observable<Unit> {
    TODO(
        "not implemented"
    ) //To change body of created functions use File | Settings | File Templates.
  }

  override fun post(retailTransaction: RetailTransaction): Observable<Unit> {
    TODO(
        "not implemented"
    ) //To change body of created functions use File | Settings | File Templates.
  }

  private fun <T> Observable<Response<T>>.adapt(): Observable<T> =
    switchMapSingle(HttpStatusOperator()).subscribeOn(Schedulers.io())

}
