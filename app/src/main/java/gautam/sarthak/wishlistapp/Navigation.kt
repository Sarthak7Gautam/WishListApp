package gautam.sarthak.wishlistapp

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument

@Composable
fun Navigation(navModel:WishListViewModel= viewModel(), navController: NavHostController= rememberNavController()) {
    NavHost(navController = navController, startDestination = Screen.homescreen.route){
        composable(Screen.homescreen.route){
            ScreenBar(navController,navModel)
        }

        composable(Screen.addscreen.route+"/{id}", arguments = listOf(navArgument("id"){
            type= NavType.IntType
            defaultValue=0
            nullable=false
        })) { entry ->
            val id = if (entry.arguments != null) {
                    entry.arguments!!.getInt("id")
            }
            else{
                0
            }
            UpdateWish(id = id, viewModel = navModel, navController = navController)
        }
    }
}