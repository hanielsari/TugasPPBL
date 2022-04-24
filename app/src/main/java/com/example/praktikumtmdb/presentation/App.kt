package com.example.praktikumtmdb.presentation
import android.app.Application
import com.example.praktikumtmdb.BuildConfig
import com.example.praktikumtmdb.presentation.di.Injector
import com.example.praktikumtmdb.presentation.di.artist.ArtistSubComponent
import com.example.praktikumtmdb.presentation.di.core.*
import com.example.praktikumtmdb.presentation.di.movie.MovieSubComponent
import com.example.praktikumtmdb.presentation.di.tvshow.TvShowSubComponent

class App : Application(), Injector {
    private lateinit var appComponent :AppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder()
            .appModule(AppModule(applicationContext))
            .netModule(NetModule(BuildConfig.BASE_URL))
            .remoteDataModule(RemoteDataModule(BuildConfig.API_KEY))
            .build()
    }

    override fun createMovieSubComponent(): MovieSubComponent {
        return appComponent.movieSubComponent().create()
    }

    override fun createTvShowComponent(): TvShowSubComponent {
        return appComponent.tvShowSubComponent().create()
    }

    override fun createArtistComponent(): ArtistSubComponent {
        return appComponent.artistSubComponent().create()
    }
}