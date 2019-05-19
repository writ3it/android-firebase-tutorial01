package pl.poznan.put.fc.tutorial01

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlin.random.Random
import kotlinx.android.synthetic.main.activity_second.*
import pl.poznan.put.fc.tutorial01.Tracking.Track

class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        val drawnNum = RandomGenerator.nextInt(1,60)
        number.text = drawnNum.toString()
        Track.drawnNumber(drawnNum)
    }

    fun onClickBack(view: View?){
        Track.buttonClicked("Back")
        finish()
    }

    companion object{
        val RandomGenerator = Random(23)
    }
}
