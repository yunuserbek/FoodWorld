package com.food.data.di


import com.food.data.local.LocalDataSourceImpl
import com.food.data.source.remote.RemoteDataSourceImpl
import com.food.domain.local.LocalDataSource
import com.food.domain.source.remote.RemoteDataSource
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
abstract class DataSourceModule {

    @Binds
    @Singleton
    abstract fun provideRemoteDataSource(remoteDataSourceImpl: RemoteDataSourceImpl): RemoteDataSource

    @Binds
    @Singleton
    abstract fun provideDtaSource(LocalDataSourceImpl: LocalDataSourceImpl): LocalDataSource


}
