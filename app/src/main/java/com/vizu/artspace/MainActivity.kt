package com.vizu.artspace

import android.graphics.fonts.FontStyle
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.vizu.artspace.ui.theme.ArtSpaceTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ArtSpaceTheme {
                ArtSpaceApp()
            }
        }
    }
}

@Composable
fun ArtSpaceApp() {
    var currentArtWork by remember { mutableStateOf(1) }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.weight(1f))
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp),
        ) {
            when (currentArtWork) {
                1 -> PaintAndDescription(
                    imageId = R.drawable.noche_estrellada_vangogh,
                    titleId = R.string.noche_estrellada,
                    artistId = R.string.van_gogh,
                )

                2 -> PaintAndDescription(
                    imageId = R.drawable.francisco_de_goya__saturno_devorando_a_su_hijo__1819_1823_,
                    titleId = R.string.saturno_devorando_a_su_hijo,
                    artistId = R.string.francisco_de_goya,
                )
                3 -> PaintAndDescription(
                    imageId = R.drawable.las_meninas_oil_canvas_diego_velazquez_prado_1656,
                    titleId = R.string.las_meninas,
                    artistId = R.string.diego_de_velazquez
                )
            }
        }
        Spacer(modifier = Modifier.weight(1f))
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(80.dp)
        ) {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp)
                    .align(Alignment.BottomCenter),
            ) {
                Button(
                    onClick = {
                        currentArtWork--
                        if(currentArtWork < 1)
                            currentArtWork = 3
                              },
                ) {
                    Text(
                        text = "Previous",
                        fontSize = 12.sp
                    )
                }
                Button(
                    onClick = {
                        currentArtWork++
                        if (currentArtWork > 3){
                            currentArtWork = 1
                        }
                              },
                ) {
                    Text(
                        text = "Next",
                        fontSize = 12.sp
                    )
                }
            }
        }
    }

}

@Composable
private fun PaintAndDescription(
    imageId: Int,
    titleId: Int,
    artistId: Int,
    modifier: Modifier = Modifier
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Surface(
            modifier = Modifier
                .fillMaxWidth(),
            shadowElevation = 16.dp,
        ) {
            Image(
                painter = painterResource(imageId),
                contentDescription = stringResource(titleId),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
                    .sizeIn(maxHeight = 550.dp),
                contentScale = ContentScale.FillWidth,
            )
        }
        Spacer(modifier = Modifier.height(36.dp))
        Column(
            modifier = Modifier
                .background(Color(0xFFDCE9F5))
                .padding(8.dp)
                .fillMaxWidth(),
        ) {
            Text(
                text = stringResource(titleId),
                fontSize = 28.sp,
                fontFamily = FontFamily.Serif
            )
            Text(
                text = stringResource(artistId),
                fontSize = 16.sp,
                fontFamily = FontFamily.SansSerif
            )
        }

    }
}


@Preview(showBackground = true)
@Composable
fun ArtSpacePreview() {
    ArtSpaceTheme {
        ArtSpaceApp()
    }
}