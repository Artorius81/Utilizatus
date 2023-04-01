package com.example.utilizatus.notification

import android.app.NotificationManager
import android.content.ContentResolver
import android.content.Context
import android.provider.Settings.Global.getString
import androidx.annotation.StringRes
import androidx.core.app.NotificationCompat
import com.example.utilizatus.R

class NotificationService(
    private val context: Context
) {
    private val notificationManager = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

    fun showNotification(otp: Int) {
        val notification = NotificationCompat.Builder(context, OTP_CHANNEL_ID)
            .setSmallIcon(R.drawable.util_logo)
            .setContentText("Your code: $otp")
            .build()

        notificationManager.notify(NOTIFICATION_ID, notification)

    }
    companion object {
        const val NOTIFICATION_ID = 101
        const val OTP_CHANNEL_ID = "otp_channel"
    }
}