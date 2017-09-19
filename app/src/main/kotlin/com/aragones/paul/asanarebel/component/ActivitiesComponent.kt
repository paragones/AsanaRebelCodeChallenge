package com.aragones.paul.asanarebel.component

import com.aragones.paul.asanarebel.modules.*
import com.aragones.paul.asanarebel.ui.main.MainActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(ApplicationModule::class,
        ExecutorsModule::class,
        InteractorModule::class,
        NetworkModule::class,
        RepositoryModule::class))
interface ActivitiesComponent {
    fun inject(activity: MainActivity)
}