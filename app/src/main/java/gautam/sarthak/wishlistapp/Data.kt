package gautam.sarthak.wishlistapp

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "WishList-Table")
data class Data(
    @PrimaryKey(autoGenerate = true)
    val id:Int=0,
    @ColumnInfo(name="title")
    val title:String="",
    @ColumnInfo(name="description")
    val description:String="")

object WishList {
    val datalist = listOf(
        Data(id=1,title = "Android Development Course", description = "Android Developer Job"),
        Data(id=2,title = "Web Development Course", description = "Web Developer Job"),
        Data(id=3,title = "Blockchain Development Course", description = "Blockchain Developer Job"),
        Data(id=4,title = "DataScience Development Course", description = "DataScience Job"),
        Data(id=5,title = "Designer Development Course", description = "Designer Job"),
    )
}
