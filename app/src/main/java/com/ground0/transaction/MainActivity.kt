package com.ground0.transaction

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.TextView
import butterknife.ButterKnife
import butterknife.OnClick
import com.ground0.model.RetailTransaction
import com.ground0.transaction.R.id
import com.ground0.transaction.viewmodel.TransactionListViewModel

class MainActivity : AppCompatActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)
    ButterKnife.bind(this)

    ViewModelProviders.of(this)
        .get(TransactionListViewModel::class.java)
        .apply {
          transactions.observe(
              this@MainActivity,
              Observer<List<RetailTransaction>> {

                findViewById<TextView>(id.a_main_text).apply {
                  text = it?.map { it.amount }
                      ?.joinToString()
                }
//                it?.let { Thread(Runnable { LocalStore.writeTransactions(it) }).start() }

              })
        }
  }

  @OnClick(R.id.a_main_button)
  fun onButtonClick() {
    startActivity(Intent(this, Main2Activity::class.java))
  }
}
