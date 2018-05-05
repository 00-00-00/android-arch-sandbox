package com.ground0.transaction.core.repository

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.Room
import android.content.Context
import com.ground0.model.Customer
import com.ground0.model.Retailer
import com.ground0.model.Transaction
import io.reactivex.Observable

/**
 * Created by 00-00-00 on 05/05/18.
 */

object LocalStore : Repository {

  private lateinit var databaseImp: RoomDatabase

  fun init(context: Context) {
    databaseImp = Room.databaseBuilder(context, RoomDatabase::class.java, "transaction_db")
        .build()
  }

  override fun getTransactions(): LiveData<List<Transaction>> {
    return databaseImp.transactionDao().getTransactions()
  }

  override fun getTransaction(id: Long): LiveData<Transaction> {
    return databaseImp.transactionDao().getTransaction(id)
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