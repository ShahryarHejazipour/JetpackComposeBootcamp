package com.example.jetpackcomposebootcamp.triviaProject.components

import android.util.Log
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.text.ParagraphStyle
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextIndent
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetpackcomposebootcamp.triviaProject.model.QuestionItem
import com.example.jetpackcomposebootcamp.triviaProject.screens.QuestionViewModel
import com.example.jetpackcomposebootcamp.triviaProject.util.AppColors


@Composable
fun Questions(viewModel: QuestionViewModel) {



    /**
     * Important note: since, Question class returns an
     * ArrayList, we must convert the values of that type
     * into a MutableList() in order to get the size(), and
     * any other methods... if we don't convert to MutableList
     * we receive a nasty "NonSuchMethod" exception.
     *
     */

    val questions = viewModel.data.value.data?.toMutableList()
    val questionIndex = remember {
        mutableStateOf(0)
    }


    if (viewModel.data.value.loading == true){
        CircularProgressIndicator()
    }else{
        Log.d("Loading", "Questions: Loading Stopped ...")

        questions?.forEach { questionItem ->

           if (questions != null){
               QuestionsDisplay(question = questionItem)

           }

        }

    }


}

//@Preview
@Composable
fun QuestionsDisplay(
    question:QuestionItem ,
   // questionIndex:MutableState<Int>,
    // viewModel: QuestionViewModel,
    onNextClicked:()->Unit ={}
) {

    //this state is for holding the choices
    val choicesState = remember(question){
        question.choices.toMutableList()
       // mutableListOf(question.choices)
    }

    //this state is for holding the answer of question:QuestionItem
    val answerState = remember(question){
       // mutableStateOf(question.answer)
        mutableStateOf<Int?>(null)
    }
    val correctAnswerState = remember(question) {
        mutableStateOf<Boolean?>(null)

    }

    val updateAnswer : (Int)->Unit = remember(question){
        {
            answerState.value = it
            correctAnswerState.value = choicesState[it] == question.answer
        }
    }

    val pathEffect = PathEffect.dashPathEffect(floatArrayOf(10f,10f),0f)
    Surface(modifier = Modifier
        .fillMaxWidth()
        .fillMaxHeight(),
    color = AppColors.mDarkPurple) {
        Column(modifier = Modifier.padding(12.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.Start) {
            QuestionTracker()
            DrawDottedLine(pathEffect = pathEffect)
            Column {
                Text(text = question.question,
                    modifier = Modifier
                        .padding(6.dp)
                        .fillMaxHeight(0.3f)
                        .align(alignment = Alignment.Start),
                fontSize = 17.sp,
                fontWeight = FontWeight.Bold,
                lineHeight = 22.sp,
                color = AppColors.mOffWhite)

                //Choices

                choicesState.forEachIndexed { index, answerText ->
                    Row(modifier = Modifier
                        .padding(3.dp)
                        .height(45.dp)
                        .fillMaxWidth()
                        .border(
                            width = 4.dp, brush = Brush.linearGradient(
                                colors = listOf(
                                    AppColors.mOffDarkPurple,
                                    AppColors.mOffDarkPurple
                                )
                            ), shape = RoundedCornerShape(15.dp)
                        )
                        .clip(
                            RoundedCornerShape(
                                topStartPercent = 50,
                                topEndPercent = 50,
                                bottomEndPercent = 50,
                                bottomStartPercent = 50
                            )
                        )
                        .background(Color.Transparent),
                            verticalAlignment = Alignment.CenterVertically) {
                        RadioButton(
                            selected = (answerState.value == index),
                            onClick = {
                                updateAnswer(index)
                            }, modifier = Modifier.padding(start = 16.dp),
                        colors = RadioButtonDefaults.colors(
                            selectedColor = if (correctAnswerState.value == true && index == answerState.value) {
                                Color.Green.copy(alpha = 0.2f)
                            }
                            else {
                                Color.Red.copy(alpha = 0.2f)
                            })) // End Og RadioButton

                        Text(text = answerText)

                    }
                }


                
            }

        }

    }
}

@Composable
fun DrawDottedLine(pathEffect:PathEffect) {
    Canvas(modifier = Modifier
        .fillMaxWidth()
        .height(1.dp)){
        drawLine(color = AppColors.mLightGray, start = Offset(0f,0f),
            end = Offset(size.width,0f)
            ,pathEffect=pathEffect)

    }

}


//@Preview
@Composable
fun QuestionTracker(counter:Int=10, outOf:Int=100) {
    Text(text = buildAnnotatedString {
        withStyle(style = ParagraphStyle(textIndent = TextIndent.None))
        {
            withStyle(style = SpanStyle(color = AppColors.mLightGray, fontWeight = FontWeight.Bold,
            fontSize = 27.sp)){
                append("Question $counter/")
                withStyle(style = SpanStyle(color = AppColors.mLightGray, fontWeight = FontWeight.Light,
                    fontSize = 14.sp)){
                    append("$outOf")
                }
            }


        }
    }, modifier = Modifier.padding(20.dp))

}