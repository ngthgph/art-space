package com.example.artspace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.artspace.ui.theme.ArtSpaceTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArtSpaceTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ArtSpaceApp()
                }
            }
        }
    }
}

@Composable
fun ArtSpaceApp() {
    var art by remember { mutableStateOf(1) }

    when(art) {
        1 -> ArtSpaceLayout(
            painter = R.drawable.girl_with_a_pearl_earring,
            art = R.string.girl_with_a_pearl_earring,
            author = R.string.a_girl_with_a_pearl_earring,
            year = R.string.y_girl_with_a_pearl_earring,
            onPreviousClick  = { art = 7 },
            onNextClick = { art++ }
        )

        2 -> ArtSpaceLayout(
            painter = R.drawable.mona_lisa,
            art = R.string.mona_lisa,
            author = R.string.a_mona_lisa,
            year = R.string.y_mona_lisa,
            onPreviousClick  = { art-- },
            onNextClick = { art++ }
        )

        3 -> ArtSpaceLayout(
            painter = R.drawable.the_starry_night,
            art = R.string.the_starry_night,
            author = R.string.a_the_starry_night,
            year = R.string.y_the_starry_night,
            onPreviousClick  = { art-- },
            onNextClick = { art++ }
        )

        4 -> ArtSpaceLayout(
            painter = R.drawable.the_kiss,
            art = R.string.the_kiss,
            author = R.string.a_the_kiss,
            year = R.string.y_the_kiss,
            onPreviousClick  = { art-- },
            onNextClick = { art++ }
        )

        5 -> ArtSpaceLayout(
            painter = R.drawable.the_birth_of_venus,
            art = R.string.the_birth_of_venus,
            author = R.string.a_the_birth_of_venus,
            year = R.string.y_the_birth_of_venus,
            onPreviousClick  = { art-- },
            onNextClick = { art++ }
        )

        6 -> ArtSpaceLayout(
            painter = R.drawable.a_sunday_afternoon_on_the_island_of_la_grande_jatte,
            art = R.string.a_sunday_afternoon_on_the_island_of_la_grande_jatte,
            author = R.string.a_a_sunday_afternoon_on_the_island_of_la_grande_jatte,
            year = R.string.y_a_sunday_afternoon_on_the_island_of_la_grande_jatte,
            onPreviousClick  = { art-- },
            onNextClick = { art++ }
        )

        7 -> ArtSpaceLayout(
            painter = R.drawable.whistler_s_mother,
            art = R.string.whistler_s_mother,
            author = R.string.a_whistler_s_mother,
            year = R.string.y_whistler_s_mother,
            onPreviousClick  = { art-- },
            onNextClick = { art = 1 }
        )
    }
}

@Composable
fun ArtSpaceLayout(
    @DrawableRes painter: Int = R.drawable.girl_with_a_pearl_earring,
    @StringRes art: Int = R.string.girl_with_a_pearl_earring,
    @StringRes author: Int = R.string.a_girl_with_a_pearl_earring,
    @StringRes year: Int = R.string.y_girl_with_a_pearl_earring,
    onPreviousClick: () -> Unit,
    onNextClick: () -> Unit
) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(16.dp)
    ) {

        Spacer(modifier = Modifier.height(45.dp))

        Image(
            painter = painterResource(id = painter), 
            contentDescription = stringResource(id = art),
            modifier = Modifier
                .size(350.dp, 400.dp)
                .wrapContentSize(Alignment.Center)
                .padding(30.dp)
        )

        Spacer(modifier = Modifier.height(65.dp))

        Column(
            modifier = Modifier
                .height(130.dp)
                .width(320.dp)
                .background(color = Color(0xFFE9EAF1))
                .padding(
                    top = 15.dp,
                    bottom = 5.dp,
                    start = 30.dp
                )
        ) {
            Text(
                text = stringResource(id = art),
                fontSize = 25.sp,
                fontWeight = FontWeight.Light,
                color = Color(0xff757575),
                modifier = Modifier
                    .padding(bottom = 8.dp)
            )
            Row{
                Text(
                    text = stringResource(id = author),
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.sizeIn(maxWidth = 250.dp)
                )
                Spacer(modifier = Modifier.width(5.dp))
                Text(
                    text = stringResource(id = R.string.year, stringResource(id = year)),
                    color = Color(0xff9e9e9e),
                )
            }
        }

        Spacer(modifier = Modifier.height(45.dp))

        Row() {
            NavigationButton(direction = R.string.previous, onPreviousClick)
            Spacer(modifier = Modifier.width(40.dp))
            NavigationButton(direction = R.string.next, onNextClick)
        }
    }

}

@Composable
fun NavigationButton(
    @StringRes direction: Int,
    onButtonClick: () -> Unit
) {
    Button(
        onClick = onButtonClick,
        colors = ButtonDefaults.buttonColors(Color(0xFF4F5B9C)),
        shape = RoundedCornerShape(25.dp),
        modifier = Modifier
            .width(150.dp)
    ) {
        Text(
            text = stringResource(id = direction),
            color = Color(0xffffffff)
        )
    }
}

@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun GreetingPreview() {
    ArtSpaceTheme {
        ArtSpaceApp()
    }
}