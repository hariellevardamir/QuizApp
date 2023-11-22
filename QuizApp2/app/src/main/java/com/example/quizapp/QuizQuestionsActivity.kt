package com.example.quizapp

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_quiz_questions.*
import kotlinx.android.synthetic.main.activity_result.*
import java.net.CookieHandler

class QuizQuestionsActivity : AppCompatActivity(), View.OnClickListener {


    private var mCurrentPosition: Int = 1
    private var mQuestionList: ArrayList<Questions>? = null
    private var mSelectedOptionPosition: Int = 0

    private var mCorrectAnswers: Int = 0

    private var mUserName: String? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_questions)

        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN


        mUserName = intent.getStringExtra(Constants.USER_NAME)


        mQuestionList = Constants.getQuestions()
        Log.d("Questions", "${mQuestionList!!.size}")


        val question = mQuestionList!![mCurrentPosition - 1]

        tvQuestion.text = question.question

        ivImage.setImageResource(question.image)

        progressBar.progress = mCurrentPosition

        tvProgress.text = "$mCurrentPosition / ${progressBar.max}"

        tvOptionOne.text = question.optionOne
        tvOptionTwo.text = question.optionTwo
        tvOptionThree.text = question.optionThree
        tvOptionFour.text = question.optionFour

        setQuestion()


        tvOptionOne.setOnClickListener(this)
        tvOptionTwo.setOnClickListener(this)
        tvOptionThree.setOnClickListener(this)
        tvOptionFour.setOnClickListener(this)
        btnSubmit.setOnClickListener(this)


    }

    private fun setQuestion() {


        var question = mQuestionList!![mCurrentPosition - 1]

        defaultOptionView()

        if (mCurrentPosition == mQuestionList!!.size) {
            btnSubmit.text = "FINISH"
        } else {
            btnSubmit.text = "SUBMIT"
        }

        tvQuestion.text = question!!.question

        ivImage.setImageResource(question.image)

        progressBar.progress = mCurrentPosition

        tvProgress.text = "$mCurrentPosition / ${progressBar.max}"

        tvOptionOne.text = question.optionOne
        tvOptionTwo.text = question.optionTwo
        tvOptionThree.text = question.optionThree
        tvOptionFour.text = question.optionFour

    }


    private fun defaultOptionView() {

        val options = ArrayList<TextView>()

        options.add(0, tvOptionOne)
        options.add(1, tvOptionTwo)
        options.add(2, tvOptionThree)
        options.add(3, tvOptionFour)

        for (i in options) {
            i.setTextColor((Color.parseColor("grey")))
            i.typeface = Typeface.DEFAULT
            i.background = ContextCompat.getDrawable(this, R.drawable.default_option_border)
        }
    }

    override fun onClick(p0: View?) {

        when (p0?.id) {
            R.id.tvOptionOne -> {
                selectedOptionView(tvOptionOne, 1)
            }
            R.id.tvOptionTwo -> {
                selectedOptionView(tvOptionTwo, 2)
            }
            R.id.tvOptionThree -> {
                selectedOptionView(tvOptionThree, 3)
            }
            R.id.tvOptionFour -> {
                selectedOptionView(tvOptionFour, 4)
            }
            R.id.btnSubmit -> {
                if (mSelectedOptionPosition == 0) {
                    mCurrentPosition++


                    when {

                        mCurrentPosition <= mQuestionList!!.size -> {
                            setQuestion()
                        }
                        else -> {


                            val intent = Intent(this, ResultActivity::class.java)
                            intent.putExtra(Constants.USER_NAME, mUserName)
                            intent.putExtra(Constants.CORRECT_ANSWERS, mCorrectAnswers)
                            intent.putExtra(Constants.TOTAL_QUESTION, mQuestionList!!.size)
                            startActivity(intent)

                        }
                    }

                } else {
                    val question = mQuestionList?.get(mCurrentPosition - 1)
                    if (question!!.correct != mSelectedOptionPosition) {
                        answerView(mSelectedOptionPosition, R.drawable.wrong_option_border)
                    } else {
                        mCorrectAnswers++
                        Log.d("abc", "mCorrect")
                    }
                    answerView(question.correct, R.drawable.correct_option_border)
                    if (mCurrentPosition == mQuestionList!!.size) {
                        btnSubmit.text = "FINISH"
                    } else {
                        btnSubmit.text = "GO TO NEXT QUESTION"
                    }
                    mSelectedOptionPosition = 0

                }


            }
        }
    }

    private fun answerView(answer: Int, drawableView: Int) {

        when (answer) {
            1 -> {
                tvOptionOne.background = ContextCompat.getDrawable(this, drawableView)
                tvOptionFour.setTextColor((Color.parseColor("black")))
            }
            2 -> {
                tvOptionTwo.background = ContextCompat.getDrawable(this, drawableView)
                tvOptionFour.setTextColor((Color.parseColor("black")))
            }
            3 -> {
                tvOptionThree.background = ContextCompat.getDrawable(this, drawableView)
                tvOptionFour.setTextColor((Color.parseColor("black")))
            }
            4 -> {
                tvOptionFour.background = ContextCompat.getDrawable(this, drawableView)
                tvOptionFour.setTextColor((Color.parseColor("black")))
            }

        }

    }


    private fun selectedOptionView(tv: TextView, selectedOptionNumber: Int) {

        defaultOptionView()
        mSelectedOptionPosition = selectedOptionNumber

        tv.setTextColor((Color.parseColor("black")))
        tv.setTypeface(tv.typeface, Typeface.BOLD)
        tv.background = ContextCompat.getDrawable(this, R.drawable.selected_option_border)
    }
}