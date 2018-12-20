package com.ground0.transaction

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import com.ground0.transaction.core.repository.db.LocalStore
import com.ground0.transaction.core.repository.db.RoomDatabase
import com.ground0.transaction.di.component.DaggerAppComponent
import com.ground0.transaction.di.module.ApplicationModule
import com.ground0.transaction.di.module.RoomModule
import io.reactivex.android.schedulers.AndroidSchedulers
import kotlinx.android.synthetic.main.activity_main2.toolbar
import javax.inject.Inject

class Main2Activity : AppCompatActivity() {

  @Inject lateinit var database: RoomDatabase

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main2)
    setSupportActionBar(toolbar)

//    DaggerAppComponent.builder()
//        .applicationModule(ApplicationModule(applicationContext))
//        .roomModule(RoomModule(applicationContext))
//        .build()
//        .inject(this)

    database.transactionDao().getTransactions()
        .subscribe({
          Log.d(this@Main2Activity.localClassName, it.joinToString { it.currency })
        })

    LocalStore.getTransactions()
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe({
          findViewById<TextView>(R.id.a_main2_text).apply {
            text = it?.map { it.amount }
                ?.joinToString()
          }
        }, {
          Toast.makeText(this, "Error", Toast.LENGTH_SHORT)
              .show()
        })
  }

}
