package pl.poznan.put.fc.tutorial01

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlin.random.Random
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        number.text = RandomGenerator.nextInt(1,60).toString()
    }

    fun onClickBack(view: View?){
        finish()
    }

    companion object{
        val RandomGenerator = Random(23)
    }
}
