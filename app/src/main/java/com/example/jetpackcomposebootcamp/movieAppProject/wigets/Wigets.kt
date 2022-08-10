package com.example.jetpackcomposebootcamp.movieAppProject.wigets

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import coil.compose.rememberImagePainter
import coil.transform.CircleCropTransformation
import com.example.jetpackcomposebootcamp.movieAppProject.model.Movie
import com.example.jetpackcomposebootcamp.movieAppProject.model.getMovies


//LazyColumn Item's View
@Preview
@Composable
fun MovieRow(movie: Movie = getMovies()[0], onItemClick:(String)->Unit = {}) {

    var expanded by remember{
        mutableStateOf(false)
    }

    Card(modifier = Modifier
        .padding(4.dp)
        .fillMaxWidth()
        .clickable { onItemClick(movie.id) }
        //.height(130.dp)
        ,shape = RoundedCornerShape(corner = CornerSize(16.dp)),
        elevation = 6.dp) {
        Row(verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start) {
            Surface(modifier = Modifier
                .padding(12.dp)
                .size(100.dp),
                shape = RectangleShape,
                elevation = 4.dp) {
                //Using Coil for fetching Images
                Image(painter = rememberImagePainter(data = movie.images[0],
                    builder={
                        //For create circle images
                        crossfade(true)
                        transformations(CircleCropTransformation())
                    })
                    , contentDescription = "Movie Poster" )
                //Icon(imageVector = Icons.Default.AccountBox, contentDescription = "Movie Image")

            }
            Column(modifier = Modifier.padding(4.dp)) {
                Text(text = movie.Title, style = MaterialTheme.typography.h6)
                Text(text = "Director : ${movie.Director}", style = MaterialTheme.typography.caption)
                Text(text = "Released : ${movie.Year}", style = MaterialTheme.typography.caption)

                AnimatedVisibility(visible = expanded) {
                    Column {
                       /*
                       We have two type Text in compose:
                       1- Simple Text
                       2- Text With annotated String
                       We will use the second text
                        */
                        Text(buildAnnotatedString {
                            withStyle(style = SpanStyle(color = Color.DarkGray,
                            fontSize = 13.sp)){
                                append(text = "Plot : ")
                            }
                            withStyle(style = SpanStyle(color = Color.DarkGray,
                                fontSize = 13.sp,
                            fontWeight= FontWeight.Light)){
                                append(movie.Plot)

                            }

                        }, modifier = Modifier.padding(6.dp))

                        Divider(modifier = Modifier.padding(6.dp))
                        Text(text = "Director : ${movie.Director}", style = MaterialTheme.typography.caption)
                        Text(text = "Actors : ${movie.Actors}", style = MaterialTheme.typography.caption)
                        Text(text = "Rating : ${movie.Rated}", style = MaterialTheme.typography.caption)
                    }
                }
             



                Icon(imageVector = if (!expanded) Icons.Filled.KeyboardArrowDown else Icons.Filled.KeyboardArrowUp,
                    contentDescription = "Arrow Down",
                    modifier = Modifier
                        .size(25.dp)
                        .clickable {
                            expanded = !expanded
                        },
                    tint = Color.DarkGray)

            }
        }



    }

}