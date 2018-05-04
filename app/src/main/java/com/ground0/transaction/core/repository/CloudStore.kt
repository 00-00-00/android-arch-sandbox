package com.ground0.transaction.core.repository

import com.ground0.model.Customer
import com.ground0.model.Retailer
import com.ground0.model.Transaction
import com.ground0.transaction.BuildConfig
import io.reactivex.Observable
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by 00-00-00 on 05/05/18.
 */

object CloudStore : Repository{

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

  override fun getTransactions(): Observable<List<Transaction>> =
    restImp.getTransactions()

  override fun getTransaction(id: Long): Observable<Transaction> {
    TODO(
        "not implemented"
    ) //To change body of created functions use File | Settings | File Templates.
  }

  override fun postTransaction(transaction: Transaction): Observable<Void> {
    TODO(
        "not implemented"
    ) //To change body of created functions use File | Settings | File Templates.
  }

  override fun getCustomers(): Observable<List<Customer>> {
    TODO(
        "not implemented"
    ) //To change body of created functions use File | Settings | File Templates.
  }

  override fun getCustomer(id: Long): Observable<Customer> {
    TODO(
        "not implemented"
    ) //To change body of created functions use File | Settings | File Templates.
  }

  override fun postTransaction(customer: Customer): Observable<Void> {
    TODO(
        "not implemented"
    ) //To change body of created functions use File | Settings | File Templates.
  }

  override fun getRetailers(): Observable<List<Retailer>> {
    TODO(
        "not implemented"
    ) //To change body of created functions use File | Settings | File Templates.
  }

  override fun getRetailer(id: Long): Observable<Retailer> {
    TODO(
        "not implemented"
    ) //To change body of created functions use File | Settings | File Templates.
  }

  override fun postRetailer(retailer: Retailer): Observable<Void> {
    TODO(
        "not implemented"
    ) //To change body of created functions use File | Settings | File Templates.
  }
}