package gautam.sarthak.wishlistapp

import kotlinx.coroutines.flow.Flow


class WishRepository(private val wishdao:WishDao){

    suspend fun addAWish(wish:Data){
        wishdao.addAWish(wish)
    }
    fun updateAWish(wish:Data){
        wishdao.updateAWish(wish)
    }
    fun delete(wish:Data){
        wishdao.delete(wish)
    }

    fun getAllWishes(): Flow<List<Data>> = wishdao.getAllWishes()
    fun getAWishById(id:Int):Flow<Data> = wishdao.getAWishById(id)
}