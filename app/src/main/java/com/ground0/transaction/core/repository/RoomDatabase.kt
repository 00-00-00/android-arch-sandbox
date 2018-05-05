package com.ground0.transaction.core.repository

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import com.ground0.model.Transaction
import com.ground0.transaction.core.repository.dao.TransactionDao

/**
 * Created by 00-00-00 on 05/05/18.
 */

@Database(entities = [(Transaction::class)], version = 1)
abstract class RoomDatabase : RoomDatabase() {
  abstract fun transactionDao(): TransactionDao
}