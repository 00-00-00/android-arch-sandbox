package com.ground0.transaction

import android.arch.lifecycle.Observer
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.TextView
import com.ground0.transaction.core.repository.db.LocalStore
import kotlinx.android.synthetic.main.activity_main2.toolbar

class Main2Activity : AppCompatActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main2)
    setSupportActionBar(toolbar)


    LocalStore.readTransactions()
        .observe(this, Observer {
          findViewById<TextView>(R.id.a_main2_text).apply {
            text = it?.map { it.amount }
                ?.joinToString()
          }
        })

  }

}
