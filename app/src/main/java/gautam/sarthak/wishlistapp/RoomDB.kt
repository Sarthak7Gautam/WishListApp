package gautam.sarthak.wishlistapp

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Data::class],
    version = 1,
    exportSchema = false)

abstract class RoomDB:RoomDatabase() {
    abstract fun wishDao(): WishDao
}