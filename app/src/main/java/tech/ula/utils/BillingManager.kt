package tech.ula.utils

import android.app.Activity
import android.util.Log
import java.util.* // ktlint-disable no-wildcard-imports
import kotlin.collections.HashMap

/**
 * When using this class:
 * - Call `queryPurchases()` in your Activity's onResume() method
 * - Call `query*SubscriptionSkuDetails()` when you want to show your in-app products
 * - Call `startPurchaseFlow()` when one of your in-app products is clicked on
 * - Call `destroy()` in your Activity's onDestroy() method
 */
class BillingManager(
    private val activity: Activity,
    private val onSubscriptionSupportedChecked: (Boolean) -> Unit
) {

    private var isBillingServiceConnected = false

    private fun handlePopulateSkuError(code: Int, message: String) {
        log("Error trying to populate skus.  code: $code message: $message")
    }

    init {
        startServiceConnection {
            onSubscriptionSupportedChecked(isSubscriptionPurchaseSupported())
        }
    }

    fun querySubPurchases() {
    }

    fun queryInAppPurchases() {
    }

    fun startPurchaseFlow(productId: String) {
    }

    fun destroy() {
        log("destroy()")
    }

    private fun startServiceConnection(task: () -> Unit) {
    }

    private fun isSubscriptionPurchaseSupported(): Boolean {
        return false
    }

    private fun log(message: String) {
        Log.d("BillingManager", message)
    }

    /** The format of SKUs must start with number or lowercase letter and can contain only numbers (0-9),
     * lowercase letters (a-z), underscores (_) & periods (.).*/
    object Sku {
        const val US1_ONETIME = "1us_onetime"
        const val US5_ONETIME = "5us_onetime"
        const val US10_ONETIME = "10us_onetime"
        const val US20_ONETIME = "20us_onetime"
        const val US1_MONTHLY = "1us_monthly"
        const val US5_MONTHLY = "5us_monthly"
        const val US10_MONTHLY = "10us_monthly"
        const val US20_MONTHLY = "20us_monthly"
        const val US1_YEARLY = "1us_yearly"
        const val US5_YEARLY = "5us_yearly"
        const val US10_YEARLY = "10us_yearly"
        const val US20_YEARLY = "20us_yearly"
        // Testing
        // const val TEST_PURCHASED = "android.test.purchased"
        // const val TEST_CANCELED = "android.test.canceled"
        // const val TEST_UNAVAILABLE = "android.test.item_unavailable"
    }
}
