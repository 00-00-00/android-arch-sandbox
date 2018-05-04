package com.ground0.model

import com.google.gson.annotations.SerializedName
import java.util.Date

class Transaction {
  var id: Long? = null

  @SerializedName("amount_cents")
  val amount: Long? = null

  @SerializedName("amount_currency")
  lateinit var currency: String

  @SerializedName("created_at")
  lateinit var createdAt: Date

  @SerializedName("updated_at")
  lateinit var updatedAt: Date

  @SerializedName("customer_id")
  val customerId: Long? = null

  @SerializedName("retailer_id")
  val retailerId: Long? = null
}
