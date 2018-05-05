package com.ground0.transaction.viewmodel

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.ground0.model.RetailTransaction
import com.ground0.transaction.core.repository.network.CloudStore

/**
 * Created by 00-00-00 on 05/05/18.
 */

class TransactionListViewModel : ViewModel() {

  var transactions: LiveData<List<RetailTransaction>> = MutableLiveData<List<RetailTransaction>>()
    get() {
      loadTransactions()
      return field
    }

  private fun loadTransactions() {
    transactions = CloudStore.getTransactions()
  }
}