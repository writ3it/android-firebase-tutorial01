package pl.poznan.put.fc.tutorial01

import android.media.RingtoneManager
import android.net.Uri
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
        val sound: Uri = getDefaultNotificationSound()
        // TODO: budowanie powiadomienia
        // TODO: uruchomienie menadżera powiadomień
    }

    private fun getDefaultNotificationSound(): Uri {
        return RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION)
    }

    companion object{
        const val TAG:String = "NotificationService"
    }
}
