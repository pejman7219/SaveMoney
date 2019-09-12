package com.example.savemoney.SMSListener

import android.app.NotificationManager
import android.R
import android.app.NotificationChannel
import android.app.PendingIntent
import android.media.RingtoneManager
import android.provider.Telephony
import android.content.Intent
import android.content.BroadcastReceiver
import android.content.Context
import android.os.Build
import androidx.core.app.NotificationCompat
import com.example.savemoney.UI.MainActivity
import java.text.SimpleDateFormat
import java.util.*


class SMSListener : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {

        if (intent.action == SMS_RECEIVED) {
            val bundle = intent.extras

            var senderNumber = ""
            var messageBody = ""
            var date: String? = ""

            if (bundle != null) {

                val messages = Telephony.Sms.Intents.getMessagesFromIntent(intent)

                for (i in messages.indices) {
                    val message = messages[i]
                    senderNumber = message.displayOriginatingAddress
                    messageBody = message.displayMessageBody
                    date = getDate(message.timestampMillis)
                }

                if (isBankNumber(senderNumber,messageBody))
                {
                    val intent = Intent(context,MainActivity::class.java)
                    intent.putExtra("message",messageBody)

                    val pendingIntent = PendingIntent.getActivity(context,0,intent,PendingIntent.FLAG_ONE_SHOT)


                    val mBuilder = NotificationCompat.Builder(context)
                        .setSmallIcon(R.drawable.ic_dialog_email)
                        .setContentTitle("پیام بانکی از$senderNumber")
                        .setContentText(messageBody)
                        .setAutoCancel(true)
                        .setSound(RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION))
                        .setContentIntent(pendingIntent)
                        .setSubText(date)

                    val notifi =  context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O)
                    {
                        var chanelId = "bank_default_chanel"
                        var nutifichanel = NotificationChannel(chanelId,"اطلاعیه بانکی",NotificationManager.IMPORTANCE_DEFAULT)
                        nutifichanel.description = messageBody

                        notifi.createNotificationChannel(nutifichanel)
                        mBuilder.setChannelId(chanelId)

                    }



                    //var id = System.currentTimeMillis() as Int

                    val notificationManager = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
                    notificationManager.notify(2, mBuilder.build())
                }

            }
        }
    }

    private fun getDate(time: Long): String? {
        try {
            val sdf = SimpleDateFormat("dd-mm-yyyy hh:mm a")
            val date = Date(time)
            return sdf.format(date)
        } catch (e: Exception) {
            e.printStackTrace()
            return null
        }

    }

    companion object {

        private val SMS_RECEIVED = "android.provider.Telephony.SMS_RECEIVED"
    }

    fun isBankNumber(senderNumber:String,messageBody:String):Boolean
    {

        var listBankName= arrayOf("بانك پاسارگاد","بانك سامان","بانك سپه","بانك ملت","بانك سينا",
            "بانك اقتصاد نوين","بانك صادرات","بانك تجارت","بانك كشاورزي","بانک پارسيان","بانک رفاه",
            "بانک سرمايه","بانک مسکن","بانک ملی")

        if (senderNumber.length<13)
        {
            if(!senderNumber[4].equals("9"))
            {
                var listString=messageBody.split(" ")

                for (bankName in listBankName)
                {
                    messageBody.contentEquals(bankName)

                    return true
                }
            }
            else
            {
                return false
            }
        }
        else
        {
            return false
        }

        return false
    }
}