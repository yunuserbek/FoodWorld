package com.food.foodworld.di

import com.food.foodworld.common.Constants.API_KEY
import com.food.foodworld.common.Constants.BASE_URL
import com.food.foodworld.data.source.remote.FoodServices
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Protocol
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RetrofitModule {


    //    @Provides
//    @Singleton
//    fun provideFoodService(): FoodService = Retrofit.Builder()
//        .baseUrl(BASE_URL)
//        .addConverterFactory(GsonConverterFactory.create())
//        .client(getOkHttpClient(getInterceptor()))
//        .build()
//        .create(FoodService::class.java)
    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    @Singleton
    @Provides
    fun provideHomeService(retrofit: Retrofit): FoodServices =
        retrofit.create(FoodServices::class.java)

    @Provides
    @Singleton
    fun getInterceptor(): Interceptor {
        return Interceptor {
            val request = it.request().newBuilder()
                .addHeader("Content-Type", "application/json")
                .addHeader("x-api-key", API_KEY).build()
            it.proceed(request)
        }
    }

    @Provides
    @Singleton
    fun getOkhttpClient(interceptor: Interceptor): OkHttpClient {
        val httpBuilder =OkHttpClient.Builder()
            .addInterceptor(interceptor)
            .connectTimeout(30, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
            .writeTimeout(50, TimeUnit.SECONDS)
        return httpBuilder
            .protocols(mutableListOf(Protocol.HTTP_1_1))
            .build()
    }
}