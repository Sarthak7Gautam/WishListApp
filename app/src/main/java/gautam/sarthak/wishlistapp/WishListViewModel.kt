package gautam.sarthak.wishlistapp

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class WishListViewModel(
    val wishRepository: WishRepository=graph.wishRepository):ViewModel() {

    var wishtitle by mutableStateOf("")
    var wishdescription by mutableStateOf("")

    fun onwishtitlechanged(newString: String){
        wishtitle=newString
    }
    fun onwishdescriptonchanged(newString: String){
        wishdescription=newString
    }

     var getAllWishes : Flow<List<Data>> = wishRepository.getAllWishes()

    fun addAWish(wish:Data) {
        viewModelScope.launch(Dispatchers.IO){
            wishRepository.addAWish(wish = wish)
        }
    }
    fun updateAWish(wish:Data) {
        viewModelScope.launch(Dispatchers.IO){
            wishRepository.updateAWish(wish = wish)
        }
    }
    fun delete(wish:Data) {
        viewModelScope.launch(Dispatchers.IO){
            wishRepository.delete(wish = wish)
        }
    }
    fun getAWishById(id:Int):Flow<Data>{
        return wishRepository.getAWishById(id)
    }
}