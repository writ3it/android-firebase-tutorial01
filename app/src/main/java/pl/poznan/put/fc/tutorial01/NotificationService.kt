package pl.poznan.put.fc.tutorial01

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
        val builder = getNotificationBuilder(message,sound)
        runNotification(builder)
    }

    private fun runNotification(builder: NotificationCompat.Builder) {
        with(NotificationManagerCompat.from(this)){
            notify(NOTIFICATION_ID,builder.build())
        }
    }

    private fun getNotificationBuilder(message: RemoteMessage, sound: Uri):NotificationCompat.Builder{
        val notification = message.notification!!
        return NotificationCompat.Builder(this, getString(R.string.ChannelId))
            .setSmallIcon(R.drawable.ic_launcher_foreground)
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
