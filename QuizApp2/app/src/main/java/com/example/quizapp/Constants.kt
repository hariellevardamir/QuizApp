package com.example.quizapp

object Constants {

    const val USER_NAME: String = "user_name"
    const val TOTAL_QUESTION: String = "total_question"
    const val CORRECT_ANSWERS: String = "correct_answers"

    fun getQuestions(): ArrayList<Questions> {

        val questionsList = ArrayList<Questions>()


        val que1 = Questions(
            1,
            "What country does this flag belong to ? ",
            R.drawable.argentina,
            "TURKEY",
            "ABD",
            "BELGIUM",
            "ARGENTINA",
            4
        )

        questionsList.add(que1)


        val que2 = Questions(
            1,
            "What country does this flag belong to ? ",
            R.drawable.australia,
            "TURKEY",
            "ABD",
            "BELGIUM",
            "AUSTRALIA",
            4
        )

        questionsList.add(que2)

        val que3 = Questions(
            1,
            "What country does this flag belong to ? ",
            R.drawable.belgium,
            "TURKEY",
            "ABD",
            "BELGIUM",
            "BELGIUM",
            4
        )

        questionsList.add(que3)

        val que4 = Questions(
            1,
            "What country does this flag belong to ? ",
            R.drawable.brazil,
            "TURKEY",
            "ABD",
            "BELGIUM",
            "BRAZIL",
            4
        )

        questionsList.add(que4)

        val que5 = Questions(
            1,
            "What country does this flag belong to ? ",
            R.drawable.denmark,
            "TURKEY",
            "ABD",
            "BELGIUM",
            "DENMARK",
            4
        )

        questionsList.add(que5)

        val que6 = Questions(
            1,
            "What country does this flag belong to ? ",
            R.drawable.fiji,
            "TURKEY",
            "ABD",
            "BELGIUM",
            "FIJI",
            4
        )

        questionsList.add(que6)

        val que7 = Questions(
            1,
            "What country does this flag belong to ? ",
            R.drawable.germany,
            "TURKEY",
            "ABD",
            "BELGIUM",
            "GERMANY",
            4
        )

        questionsList.add(que7)

        val que8 = Questions(
            1,
            "What country does this flag belong to ? ",
            R.drawable.india,
            "TURKEY",
            "ABD",
            "BELGIUM",
            "INDIA",
            4
        )

        questionsList.add(que8)

        val que9 = Questions(
            1,
            "What country does this flag belong to ? ",
            R.drawable.kuwait,
            "TURKEY",
            "ABD",
            "BELGIUM",
            "KUWAIT",
            4
        )

        questionsList.add(que9)

        val que10 = Questions(
            1,
            "What country does this flag belong to ? ",
            R.drawable.new_zelland,
            "TURKEY",
            "ABD",
            "BELGIUM",
            "NEW ZEALAND",
            4
        )

        questionsList.add(que10)

        val que11 = Questions(
            1,
            "What country does this flag belong to ? ",
            R.drawable.turkey,
            "TURKEY",
            "ABD",
            "BELGIUM",
            "NEW ZEALAND",
            1
        )

        questionsList.add(que11)




        return questionsList
    }

}