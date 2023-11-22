package com.example.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN

        btnStart.setOnClickListener {
            if (etName.text.toString().isEmpty()) {

                Toast.makeText(this, "Please enter your name...", Toast.LENGTH_SHORT).show()


            } else {


                Toast.makeText(
                    this,
                    "${etName.text} started the quiz.Good luck ",
                    Toast.LENGTH_SHORT
                ).show()

                Log.d("bcd", "${etName.text}")

                val intent = Intent(this, QuizQuestionsActivity::class.java)
                intent.putExtra(Constants.USER_NAME, etName.text.toString())
                startActivity(intent)
                finish()

            }
        }
    }


}