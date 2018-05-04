package com.ground0.transaction

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.TextView
import com.ground0.transaction.core.repository.CloudStore
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class MainActivity : AppCompatActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)

    CloudStore.init()
    CloudStore.getTransactions()
        .subscribeOn(Schedulers.newThread())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe({ transactions ->
          findViewById<TextView>(R.id.a_main_text).apply {
            text = transactions.map { it.amount }
                .joinToString()
          }
        })
  }
}
