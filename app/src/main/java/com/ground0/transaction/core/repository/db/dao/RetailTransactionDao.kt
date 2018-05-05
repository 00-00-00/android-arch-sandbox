package com.ground0.transaction.core.repository.db.dao

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import com.ground0.model.RetailTransaction

/**
 * Created by 00-00-00 on 05/05/18.
 */

@Dao
interface RetailTransactionDao {

  @Insert(onConflict = OnConflictStrategy.REPLACE)
  fun insert(retailTransaction: RetailTransaction)

  @Query("SELECT * FROM retail_transactions WHERE id = :id LIMIT 1")
  fun getTransaction(id: Long): LiveData<RetailTransaction>

  @Query("SELECT * FROM retail_transactions")
  fun getTransactions(): LiveData<List<RetailTransaction>>

}