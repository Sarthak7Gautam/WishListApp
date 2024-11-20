package gautam.sarthak.wishlistapp

import android.content.Context
import androidx.room.Room

object graph {
    lateinit var database:RoomDB

    val wishRepository by lazy {
            WishRepository(wishdao = database.wishDao())
    }
    fun provide(context: Context){
        database=Room.databaseBuilder(context, RoomDB::class.java,"wishlist.db").build()
    }
}