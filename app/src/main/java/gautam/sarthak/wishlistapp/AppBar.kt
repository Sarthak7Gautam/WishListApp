package gautam.sarthak.wishlistapp

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp


@Composable
fun AppBarView(
    title: String,
    onBackNav: () -> Unit = {}
) {
    val navButton: (@Composable () -> Unit)? = if (!title.contains("WishList")) {
        {
            IconButton(onClick = { onBackNav() }) {
                Icon(
                    imageVector = Icons.AutoMirrored.Default.ArrowBack,
                    tint = Color.White,
                    contentDescription = "null"
                )
            }
        }
    } else {
        null
    }
    TopAppBar(
        title = {
            Text(
                text = title,
                color = Color.White,
                modifier = Modifier.heightIn(max = 24.dp)
            )
        },
        elevation = 3.dp,
        backgroundColor = colorResource(id = R.color.cherrycolor2),
        navigationIcon = navButton
    )
}
