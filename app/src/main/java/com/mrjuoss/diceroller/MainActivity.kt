package com.mrjuoss.diceroller

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.mrjuoss.diceroller.pages.AboutMeActivity
import com.mrjuoss.diceroller.pages.MaterialDialogExampleActivity
import com.mrjuoss.diceroller.pages.RecyclerViewExampleActivity
import com.mrjuoss.diceroller.pages.TimeFighterActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.random.Random

import com.microsoft.appcenter.AppCenter
import com.microsoft.appcenter.analytics.Analytics
import com.microsoft.appcenter.crashes.Crashes


class MainActivity : AppCompatActivity() {

    lateinit var diceImage: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        AppCenter.start(
            application, "4ce43c34-5b3e-41fd-a0da-383a51292e78",
            Analytics::class.java, Crashes::class.java
        )

        roll_button.text = getString(R.string.lets_roll)
        roll_button.setOnClickListener {
            //Toast.makeText(this, "Clicked", Toast.LENGTH_SHORT).show()
            diceRoll()
        }

        diceImage = findViewById(R.id.dice_image)

        about_me_button.setOnClickListener {
            intent = Intent(this, AboutMeActivity::class.java)
            startActivity(intent)
        }

        recycler_view_button.setOnClickListener {
            intent = Intent(this, RecyclerViewExampleActivity::class.java)
            startActivity(intent)
        }

        material_dialog_button.setOnClickListener {
            intent = Intent(this, MaterialDialogExampleActivity::class.java)
            startActivity(intent)
        }

        time_fighter_button.setOnClickListener {
            intent = Intent(this, TimeFighterActivity::class.java)
            startActivity(intent)
        }
    }

    private fun diceRoll() {
        //result_text.text = "Dice Rolled"
        val randomInt = Random.nextInt(6) + 1
        val drawableResource = when (randomInt) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            6 -> R.drawable.dice_6
            else -> R.drawable.empty_dice
        }
        //result_text.text = "$randomInt"
        //result_text.text = randomInt.toString()
        dice_image.setImageResource(drawableResource)
    }
}
