package pl.poznan.put.fc.tutorial01

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import pl.poznan.put.fc.tutorial01.Tracking.Track

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Track.initialize(applicationContext)
        setContentView(R.layout.activity_main)
    }

    fun onClickMeBtn(view: View?){
        Track.buttonClicked("Click Me!")
        val intent = Intent(this, SecondActivity::class.java)
        startActivity(intent)
    }
}
