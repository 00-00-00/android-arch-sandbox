package com.ground0.transaction.core.repository.retailtransaction

import com.ground0.model.RetailTransaction
import io.reactivex.Flowable
import io.reactivex.Observable
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

/**
 * Created by 00-00-00 on 05/05/18.
 */

interface RetailTransactionApiStore {

  @GET("transactions")
  fun getTransactions(): Observable<Response<List<RetailTransaction>>>

  @GET("transaction/{transactionId}")
  fun getTransaction(@Query("transactionId") id: Long): Observable<Response<RetailTransaction>>

}