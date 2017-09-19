package com.aragones.paul.asanarebel.modules

import com.aragones.paul.asanarebel.repositories.CatRepository
import com.aragones.paul.asanarebel.repositories.CatRepositoryImpl
import com.aragones.paul.asanarebel.rest.CatRest
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Provides
    @Singleton
    fun providesCatRepository(rest: CatRest): CatRepository = CatRepositoryImpl(rest)
}