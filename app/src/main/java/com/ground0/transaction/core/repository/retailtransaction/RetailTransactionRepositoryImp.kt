package com.ground0.transaction.core.repository.retailtransaction

import com.ground0.model.RetailTransaction
import com.ground0.transaction.core.repository.Repository
import io.reactivex.Observable

/**
 * Created by 00-00-00 on 08/05/18.
 */

object RetailTransactionRepositoryImp : Repository<RetailTransaction> {

  override fun get(): Observable<List<RetailTransaction>> {
    RetailTransactionCloudStore.get().subscribe {
      RetailTransactionLocalStore.post(it)
    }
    return RetailTransactionCloudStore.get()
  }

  override fun get(id: Long): Observable<RetailTransaction> {
    TODO(
        "not implemented"
    ) //To change body of created functions use File | Settings | File Templates.
  }

  override fun post(retailTransactions: List<RetailTransaction>): Observable<Unit> {
    TODO(
        "not implemented"
    ) //To change body of created functions use File | Settings | File Templates.
  }

  override fun post(retailTransaction: RetailTransaction): Observable<Unit> {
    TODO(
        "not implemented"
    ) //To change body of created functions use File | Settings | File Templates.
  }
}
