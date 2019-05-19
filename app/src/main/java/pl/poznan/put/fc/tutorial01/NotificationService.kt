package pl.poznan.put.fc.tutorial01

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Color
import android.media.RingtoneManager
import android.net.Uri
import android.support.v4.app.NotificationCompat
import android.support.v4.app.NotificationManagerCompat
import android.util.Log
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage

class NotificationService : FirebaseMessagingService() {

    override fun onMessageReceived(message: RemoteMessage?) {
        val rMessage = message!!
        Log.i(TAG, "Message from: ${rMessage.from}")
        createNotification(message)
        super.onMessageReceived(message)
    }

    private fun createNotification(message: RemoteMessage) {
        val sound = getDefaultNotificationSound()
        val icon = getLargeIcon()
        val builder = getNotificationBuilder(message,sound,icon)
        runNotification(builder)
    }

    private fun getLargeIcon(): Bitmap {
        return BitmapFactory.decodeResource(applicationContext.resources,
        R.mipmap.ic_launcher_round)
    }

    private fun runNotification(builder: NotificationCompat.Builder) {
        with(NotificationManagerCompat.from(this)){
            notify(NOTIFICATION_ID,builder.build())
        }
    }

    private fun getNotificationBuilder(message: RemoteMessage, sound: Uri, icon:Bitmap):NotificationCompat.Builder{
        val notification = message.notification!!
        return NotificationCompat.Builder(this, getString(R.string.ChannelId))
            .setLargeIcon(icon)
            .setSmallIcon(R.mipmap.ic_launcher_round)
            .setColor(Color.rgb(0,255,0))
            .setContentTitle(notification.title)
            .setContentText(notification.body)
            .setSound(sound)
        // TODO: aby dodać akcję dodaj wywołanie metody .setContentIntent(<PendingIntent>)
    }

    private fun getDefaultNotificationSound(): Uri {
        return RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION)
    }

    companion object{
        const val TAG:String = "NotificationService"
        const val NOTIFICATION_ID:Int = 23
    }
}
