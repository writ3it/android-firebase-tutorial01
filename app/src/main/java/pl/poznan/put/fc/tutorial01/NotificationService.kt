package pl.poznan.put.fc.tutorial01

import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage

class NotificationService : FirebaseMessagingService() {

    override fun onMessageReceived(message: RemoteMessage?) {
        // TODO: miejsce na wygenerowanie powiadomienia
        super.onMessageReceived(message)
    }
}
