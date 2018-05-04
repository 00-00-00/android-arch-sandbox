package com.ground0.transaction.core.repository

import com.ground0.model.Transaction
import io.reactivex.Observable
import retrofit2.http.GET

/**
 * Created by 00-00-00 on 05/05/18.
 */

interface ApiStore {

  @GET("transactions")
  fun getTransactions(): Observable<List<Transaction>>

}