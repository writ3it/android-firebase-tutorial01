package pl.poznan.put.fc.tutorial01.Tracking

import android.content.Context
import android.os.Bundle
import com.google.firebase.analytics.FirebaseAnalytics

object Track {

    private lateinit var FA: FirebaseAnalytics

    fun initialize(context: Context){
        FA = FirebaseAnalytics.getInstance(context)
    }

    fun buttonClicked(name:String){
        val bundle = Bundle()
        bundle.putString(Params.P_BTN_NAME,name)
        FA.logEvent(Events.E_BUTTON_CLICKED,bundle)
    }

    fun drawnNumber(number:Int){
        val bundle = Bundle()
        bundle.putInt(Params.P_NUMBER, number)
        FA.logEvent(Events.E_NUMBER,bundle)
    }

    val Events = pl.poznan.put.fc.tutorial01.Tracking.Events
    val Params = pl.poznan.put.fc.tutorial01.Tracking.Params
}