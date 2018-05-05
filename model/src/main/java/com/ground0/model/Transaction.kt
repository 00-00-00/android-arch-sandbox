package com.ground0.model

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import java.util.Date

@Entity
class Transaction {

  @PrimaryKey
  var id: Long? = null

  @ColumnInfo(name = "amount")
  @SerializedName("amount_cents")
  val amount: Long? = null

  @ColumnInfo(name = "currency")
  @SerializedName("amount_currency")
  lateinit var currency: String

  @ColumnInfo(name = "created_at")
  @SerializedName("created_at")
  lateinit var createdAt: Date

  @ColumnInfo(name = "updated_at")
  @SerializedName("updated_at")
  lateinit var updatedAt: Date

  @ColumnInfo(name = "customer_id")
  @SerializedName("customer_id")
  val customerId: Long? = null

  @ColumnInfo(name = "retailer_id")
  @SerializedName("retailer_id")
  val retailerId: Long? = null
}
