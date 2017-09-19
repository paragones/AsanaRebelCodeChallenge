package com.aragones.paul.asanarebel.modules

import com.aragones.paul.asanarebel.interactors.CatInteractor
import com.aragones.paul.asanarebel.interactors.CatInteractorImpl
import com.aragones.paul.asanarebel.repositories.CatRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class InteractorModule {

    @Provides
    @Singleton
    fun providesCatInteractor(repository: CatRepository): CatInteractor
            = CatInteractorImpl(repository)
}