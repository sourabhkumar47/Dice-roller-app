package com.example.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView

/*
* This activity allow the user to roll a dice and view the result
* on the screen
 */
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Find Button in the layout
        val rollButton: Button = findViewById(R.id.button)

        //it will set the click listener on the button when the user tap the button
        rollButton.setOnClickListener { rollDice() }

        //Do a roll dice when app start
        rollDice()
    }

/*
* Roll the dice and update the result on the screen
*/
    private fun rollDice() {
        // Create  new dice object with 6 sides and roll it
        val dice = Dice(6)
        val diceRoll = dice.roll()
        
        //Find the image in the layout
        val diceImage: ImageView = findViewById(R.id.imageView1)

        //Determine the Resourse id of dice roll
        val drawableResource = when (diceRoll) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
    //Update the Imageview
    diceImage.setImageResource(drawableResource)

    //Updating the content Description
    diceImage.contentDescription = diceRoll.toString()

    }
}
//Dice with fixed no of sides
class Dice(val numSides: Int) {

    //Random dice roll
    fun roll(): Int {
        return (1..numSides).random()
    }
}