package com.ground0.transaction.core.repository

import com.ground0.model.Customer
import com.ground0.model.RetailTransaction
import com.ground0.model.Retailer
import io.reactivex.Observable

/**
 * Created by 00-00-00 on 05/05/18.
 */

interface Repository<T> {

  fun get(): Observable<List<T>>
  fun get(id: Long): Observable<T>
  fun post(retailTransactions: List<T>): Observable<Unit>
  fun post(retailTransaction: T): Observable<Unit>
}