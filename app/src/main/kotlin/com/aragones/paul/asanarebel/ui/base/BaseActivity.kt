package com.aragones.paul.asanarebel.ui.base

import android.support.v7.app.AppCompatActivity
import android.view.MenuItem
import com.aragones.paul.asanarebel.component.ActivitiesComponent
import com.aragones.paul.asanarebel.component.DaggerActivitiesComponent
import com.aragones.paul.asanarebel.modules.*

abstract class BaseActivity : AppCompatActivity() {

    protected fun component(): ActivitiesComponent {
        return DaggerActivitiesComponent.builder()
                .applicationModule(ApplicationModule(application))
                .executorsModule(ExecutorsModule())
                .interactorModule(InteractorModule())
                .networkModule(NetworkModule())
                .repositoryModule(RepositoryModule())
                .build()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            finish()
        }
        return super.onOptionsItemSelected(item)
    }
}