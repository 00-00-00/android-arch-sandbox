package com.ground0.transaction.viewmodel

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.ground0.model.RetailTransaction
import com.ground0.transaction.core.livedata.SingleLiveEvent
import com.ground0.transaction.core.repository.network.CloudStore
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * Created by 00-00-00 on 05/05/18.
 */

class TransactionListViewModel : ViewModel() {

  var transactions: MutableLiveData<List<RetailTransaction>> =
    MutableLiveData()
    get() {
      loadTransactions()
      return field
    }

  val snackBarEvent = SingleLiveEvent<String>()

  private fun loadTransactions() {
    CloudStore.getTransactions()
        .subscribeOn(Schedulers.newThread())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe({ it ->
          transactions.value = it
          snackBarEvent.value = "Yo, Shits done ${System.currentTimeMillis()}"
        }, {
          snackBarEvent.value = "Oh oh, dum dum ${it.message}"
        })
  }
}