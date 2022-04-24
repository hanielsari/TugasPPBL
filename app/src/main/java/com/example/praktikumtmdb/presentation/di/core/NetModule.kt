package com.example.praktikumtmdb.presentation.di.core

import com.example.praktikumtmdb.data.api.TMDBService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class NetModule(private val baseUrl: String) {
    //pada module di butuhkan object yang akan di inject pada kelas lain

    @Singleton
    @Provides
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            //converter gson melakukan convert gson di create jadi objek
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(baseUrl)
            .build()
    }

    // hasil dari provideRetrofit akan digunakan pada fungsi di bawah ini tanpa kita perlu melakukan import
    @Singleton
    @Provides
    fun provideTMDBService(retrofit: Retrofit): TMDBService {
        return retrofit.create(TMDBService::class.java)
    }
}