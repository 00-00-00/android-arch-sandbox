package com.ground0.transaction

import android.arch.lifecycle.Observer
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.TextView
import butterknife.ButterKnife
import butterknife.OnClick
import com.ground0.model.RetailTransaction
import com.ground0.transaction.core.repository.db.LocalStore
import com.ground0.transaction.core.repository.network.CloudStore

class MainActivity : AppCompatActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)
    ButterKnife.bind(this)

    CloudStore.init()
    LocalStore.init(this)

    CloudStore.getTransactions()
        .observe(this,
            Observer<List<RetailTransaction>> {

              findViewById<TextView>(R.id.a_main_text).apply {
                text = it?.map { it.amount }
                    ?.joinToString()
              }
              it?.let { Thread(Runnable { LocalStore.writeTransactions(it) }).start() }

            })
  }

  @OnClick(R.id.a_main_button)
  fun onButtonClick() {
    startActivity(Intent(this, Main2Activity::class.java))
  }
}
