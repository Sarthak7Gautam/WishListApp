package gautam.sarthak.wishlistapp

sealed class Screen(val route:String){
    object homescreen:Screen("homescreen")
    object addscreen:Screen("addscreen")
}