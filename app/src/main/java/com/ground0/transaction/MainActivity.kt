package com.ground0.transaction

import android.arch.lifecycle.Observer
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.TextView
import com.ground0.model.Transaction
import com.ground0.transaction.core.repository.CloudStore

class MainActivity : AppCompatActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)

    CloudStore.init()
    CloudStore.getTransactions()
        .observe(this,
            Observer<List<Transaction>> {

              findViewById<TextView>(R.id.a_main_text).apply {
                text = it?.map { it.amount }
                    ?.joinToString()
              }

            })
  }
}
