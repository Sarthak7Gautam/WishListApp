package gautam.sarthak.wishlistapp

import android.app.Application

class MainWishListApp:Application() {
    override fun onCreate() {
        super.onCreate()
        graph.provide(this)
    }
}