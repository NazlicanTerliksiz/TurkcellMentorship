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
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RetrofitModule {

    /* @Singleton
     @Provides
     fun provideOkHttpClient(): OkHttpClient {
         return OkHttpClient.Builder()
             .connectTimeout(30, TimeUnit.SECONDS)
             .readTimeout(30, TimeUnit.SECONDS)
             .writeTimeout(30, TimeUnit.SECONDS)
             .build()
     }
     @Singleton
     @Provides
     fun provideRetrofit(okHttpClient: OkHttpClient) = Retrofit.Builder().apply {
         addConverterFactory(GsonConverterFactory.create())
         baseUrl(BASE_URL)
         client(okHttpClient)
     }.build()

     @Singleton
     @Provides
     fun provideProductService(retrofit: Retrofit) = retrofit.create(SimpsonsQuoteService::class.java)*/

    val okHttpClient = OkHttpClient
        .Builder()
        .readTimeout(60, TimeUnit.SECONDS)
        .build()


 /*   @Singleton
    @Provides
    fun provideRetrofitClient(retrofit: Retrofit) {
        val service: SimpsonsQuoteService? by lazy {
            Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(OkHttpClient())
                .build()
                .create(SimpsonsQuoteService::class.java)
        }
    }*/
    @Singleton
    @Provides
    fun provideRetrofitClient(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(OkHttpClient())
            .build()
    }

    @Singleton
    @Provides
    fun provideSimpsonsQuoteService(retrofit: Retrofit): SimpsonsQuoteService {
        return retrofit.create(SimpsonsQuoteService::class.java)
    }
}