package com.nazlican.turkcellgelecegiyazanlarmentorshipproject.di

import com.nazlican.turkcellgelecegiyazanlarmentorshipproject.data.source.remote.SimpsonsQuoteService
import com.nazlican.turkcellgelecegiyazanlarmentorshipproject.util.Constant.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RetrofitModule {

    @Singleton
    @Provides
    fun provideRetrofit(okHttpClient: OkHttpClient) = Retrofit.Builder().apply {
        addConverterFactory(GsonConverterFactory.create())
        baseUrl(BASE_URL)
        client(okHttpClient)
    }.build()

    @Singleton
    @Provides
    fun provideProductService(retrofit: Retrofit) = retrofit.create(SimpsonsQuoteService::class.java)
}