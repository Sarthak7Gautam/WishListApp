package gautam.sarthak.wishlistapp

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
abstract class WishDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    abstract suspend fun addAWish(wishEntity:Data)

    @Update
    abstract fun updateAWish(wishEntity: Data)

    @Delete
    abstract fun delete(wishEntity: Data)

    @Query("Select * from `wishlist-table`")
    abstract fun getAllWishes(): Flow<List<Data>>

    @Query("Select * from `wishlist-table` where id=:id")
    abstract fun getAWishById(id:Int): Flow<Data>
}