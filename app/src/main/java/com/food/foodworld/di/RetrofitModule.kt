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
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RetrofitModule {


  @Provides
  @Singleton
   fun provideFoodService(): FoodServices = Retrofit.Builder()
  .baseUrl(BASE_URL)
  .addConverterFactory(GsonConverterFactory.create())
  .client(getOkhttpClient(getInterceptor()))
  .build()
  .create(FoodServices::class.java)



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
            .addInterceptor(HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY
            }
            )
            .connectTimeout(30, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
            .writeTimeout(50, TimeUnit.SECONDS)

        return httpBuilder
            .protocols(mutableListOf(Protocol.HTTP_1_1))
            .build()
    }
}