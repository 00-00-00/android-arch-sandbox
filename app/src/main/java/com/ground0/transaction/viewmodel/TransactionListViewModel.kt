package com.ground0.transaction.viewmodel

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.util.Log
import com.ground0.model.RetailTransaction
import com.ground0.transaction.core.livedata.SingleLiveEvent
import com.ground0.transaction.core.repository.db.LocalStore
import com.ground0.transaction.core.repository.network.CloudStore
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * Created by 00-00-00 on 05/05/18.
 */

class TransactionListViewModel : ViewModel() {

  val transactions: MutableLiveData<List<RetailTransaction>> by lazy {
    loadTransactions()
    MutableLiveData<List<RetailTransaction>>()
  }
  val snackBarEvent = SingleLiveEvent<String>()

  private fun loadTransactions() {
    Log.d(this::class.java.name, "Loading transactions: ${System.currentTimeMillis()}")
    CloudStore.getTransactions()
        .subscribeOn(Schedulers.computation())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe({ it ->
          Log.d(
              this@TransactionListViewModel.javaClass.canonicalName,
              "Rx observable triggered ${System.currentTimeMillis()}"
          )
          LocalStore.writeTransactions(it)
              .observeOn(AndroidSchedulers.mainThread())
              .subscribe(
                  { snackBarEvent.value = "Saved to db" },
                  { snackBarEvent.value = "Failed to save to db" }
              )
          transactions.value = it
          snackBarEvent.value = "Yo, Shits done ${System.currentTimeMillis()}"
        }, {
          snackBarEvent.value = "Oh oh, dum dum ${it.message}"
        })
  }
}