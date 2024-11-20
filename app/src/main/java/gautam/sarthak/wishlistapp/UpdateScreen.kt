package gautam.sarthak.wishlistapp

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.rememberScaffoldState
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.FontScaling
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import kotlinx.coroutines.launch

@Composable
fun UpdateWish(
    id: Int,
    viewModel: WishListViewModel,
    navController: NavController
) {
    val snackmessage = remember { mutableStateOf("") }
    val scope = rememberCoroutineScope()
    val scaffoldState = rememberScaffoldState()

    if (id != 0) {
        val wish = viewModel.getAWishById(id).collectAsState(initial = Data(0, "", ""))
        viewModel.wishtitle = wish.value.title
        viewModel.wishdescription = wish.value.description
    } else {
        viewModel.wishtitle = ""
        viewModel.wishdescription = ""
    }


    androidx.compose.material.Scaffold(scaffoldState = scaffoldState,
        topBar = {
            AppBarView(title = if (id!= 0) "Update Wish" else "Add Wish")
            { navController.navigateUp() }
        }) {
        Column(
            modifier = Modifier
                .padding(it)
                .wrapContentSize(), horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Spacer(modifier = Modifier.height(10.dp))
            editTextView(
                label = "Title",
                value = viewModel.wishtitle,
                onValueChange = { viewModel.onwishtitlechanged(it) })
            Spacer(modifier = Modifier.height(12.dp))
            editTextView(
                label = "Description",
                value = viewModel.wishdescription,
                onValueChange = { viewModel.onwishdescriptonchanged(it) })
            Spacer(modifier = Modifier.height(12.dp))
            Button(onClick = {
                if (viewModel.wishtitle.isNotEmpty() && viewModel.wishdescription.isNotEmpty()) {
                    if (id != 0) {
                        viewModel.updateAWish(
                            Data(
                                id = id,
                                title = viewModel.wishtitle,
                                description = viewModel.wishdescription
                            )
                        )
                        snackmessage.value = "Wish Updated"
                    } else {
                        viewModel.addAWish(
                            Data(
                                title = viewModel.wishtitle,
                                description = viewModel.wishdescription
                            )
                        )
                        snackmessage.value = "Wish has been created"
                    }
                } else {
                    snackmessage.value = "Enter the fields to create a wish"
                }
                scope.launch {
                    scaffoldState.snackbarHostState.showSnackbar(snackmessage.value)
                    navController.navigateUp()
                }
            }, modifier = Modifier.padding(start = 4.dp, end = 4.dp)) {
                Text(
                    text = if (id != 0) "Update Wish" else "Add Wish",
                    fontSize = 12.sp,
                    modifier = Modifier.fillMaxWidth(),
                    color = Color.White
                )
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun editTextView(
    label: String,
    value: String,
    onValueChange: (String) -> Unit
) {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        label = { Text(text = label, color = Color.Black) },
        modifier = Modifier.fillMaxWidth(),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
        colors = TextFieldDefaults.outlinedTextFieldColors(
            disabledBorderColor = Color.Black,
            focusedBorderColor = Color.Black,
            unfocusedBorderColor = Color.Black,
            cursorColor = Color.Black,
            focusedLabelColor = Color.Black,
            unfocusedLabelColor = Color.Black
        )
    )
}
