package com.ground0.transaction.core.repository.db

import android.arch.persistence.room.Room
import android.content.Context
import com.ground0.model.RetailTransaction
import io.reactivex.Flowable
import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers

/**
 * Created by 00-00-00 on 05/05/18.
 */

object LocalStore {

  private lateinit var databaseImp: RoomDatabase

  fun init(context: Context) {
    databaseImp = Room.databaseBuilder(context, RoomDatabase::class.java, "transaction_db")
        .build()
  }

  fun readTransactions(): Flowable<List<RetailTransaction>> {
    return databaseImp.transactionDao()
        .getTransactions()
  }

  fun readTransaction(id: Long): Flowable<RetailTransaction> {
    return databaseImp.transactionDao()
        .getTransaction(id)
  }

  fun writeTransactions(retailTransactions: List<RetailTransaction>): Observable<Unit> {
    return Observable.fromCallable {
      databaseImp.transactionDao()
          .insert(retailTransactions)
    }
        .subscribeOn(Schedulers.io())
  }

  fun writeTransaction(retailTransaction: RetailTransaction) {
    return databaseImp.transactionDao()
        .insert(retailTransaction)
  }
}