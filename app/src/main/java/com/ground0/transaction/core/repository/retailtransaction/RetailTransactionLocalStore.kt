package com.ground0.transaction.core.repository.retailtransaction

import android.arch.persistence.room.Room
import android.content.Context
import com.ground0.model.RetailTransaction
import com.ground0.transaction.core.repository.Repository
import com.ground0.transaction.core.repository.db.RoomDatabase
import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers

/**
 * Created by 00-00-00 on 05/05/18.
 */

object RetailTransactionLocalStore : Repository<RetailTransaction> {

  private lateinit var databaseImp: RoomDatabase

  fun init(context: Context) {
    databaseImp = Room.databaseBuilder(context, RoomDatabase::class.java, "transaction_db")
        .build()
  }

  override fun get(): Observable<List<RetailTransaction>> {
    return databaseImp.transactionDao()
        .getTransactions()
        .toObservable()
  }

  override fun get(id: Long): Observable<RetailTransaction> {
    return databaseImp.transactionDao()
        .getTransaction(id)
        .toObservable()
  }

  override fun post(retailTransactions: List<RetailTransaction>): Observable<Unit> {
    return Observable.fromCallable {
      databaseImp.transactionDao()
          .insert(retailTransactions)
    }
        .subscribeOn(Schedulers.io())
  }

  override fun post(retailTransaction: RetailTransaction): Observable<Unit> {
    return Observable.fromCallable {
      databaseImp.transactionDao()
          .insert(retailTransaction)
    }
        .subscribeOn(Schedulers.io())
  }
}
