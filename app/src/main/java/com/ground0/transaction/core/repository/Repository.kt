package com.ground0.transaction.core.repository

import android.arch.lifecycle.LiveData
import com.ground0.model.Customer
import com.ground0.model.Retailer
import com.ground0.model.RetailTransaction
import io.reactivex.Observable

/**
 * Created by 00-00-00 on 05/05/18.
 */

interface Repository {

  fun getTransactions(): LiveData<List<RetailTransaction>>
  fun getTransaction(id: Long): LiveData<RetailTransaction>
  fun postTransaction(retailTransaction: RetailTransaction): Observable<Void>

  fun getCustomers(): Observable<List<Customer>>
  fun getCustomer(id: Long): Observable<Customer>
  fun postTransaction(customer: Customer): Observable<Void>

  fun getRetailers(): Observable<List<Retailer>>
  fun getRetailer(id: Long): Observable<Retailer>
  fun postRetailer(retailer: Retailer): Observable<Void>
}