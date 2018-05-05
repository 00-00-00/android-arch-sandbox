package com.ground0.transaction.core.repository.dao

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import com.ground0.model.Transaction

/**
 * Created by 00-00-00 on 05/05/18.
 */

@Dao
interface TransactionDao {

  @Insert(onConflict = OnConflictStrategy.REPLACE)
  fun insert(transaction: Transaction)

  @Query("SELECT * FROM transaction WHERE id = :id LIMIT 1")
  fun getTransaction(id: Int): LiveData<Transaction>

  @Query("SELECT * FROM transaction")
  fun getTransactions(): LiveData<List<Transaction>>

}