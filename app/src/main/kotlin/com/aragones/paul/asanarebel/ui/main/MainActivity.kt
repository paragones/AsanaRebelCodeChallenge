package com.aragones.paul.asanarebel.ui.main

import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.widget.Toast
import com.aragones.paul.asanarebel.R
import com.aragones.paul.asanarebel.extension.gone
import com.aragones.paul.asanarebel.extension.visible
import com.aragones.paul.asanarebel.models.CatFact
import com.aragones.paul.asanarebel.ui.base.BaseActivity
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject


class MainActivity : BaseActivity(), MainView {

    @Inject
    lateinit var presenter: MainPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        component().inject(this)
        setupView()
        title = getString(R.string.title)
    }

    private fun setupView() {
        presenter.attach(this)
        presenter.loadData()
        setupListeners()
    }

    private fun setupListeners() {
        val MIN_FACT = 1
        val MIN_PAGE = 1
        var limit = catFacts.text.toString().toInt()
        var page = pageView.text.toString().toInt()
        decreaseFact.setOnClickListener {
            if (limit > MIN_FACT) {
                limit--
                loadCatFacts(limit, page)
            }
        }
        increaseFact.setOnClickListener {
            limit++
            loadCatFacts(limit, page)
        }
        nextPage.setOnClickListener {
            page++
            loadPages(limit, page)
        }
        previousPage.setOnClickListener {
            if (page > MIN_PAGE) {
                page--
                loadPages(limit, page)
            }
        }
    }

    private fun loadCatFacts(limit: Int, page: Int) {
        presenter.loadData(limit, page)
        catFacts.text = limit.toString()
    }

    private fun loadPages(limit: Int, page: Int) {
        presenter.loadData(limit, page)
        pageView.text = page.toString()
    }

    override fun displayCatFacts(catFacts: List<CatFact>) {
        mainRecyclerView.setHasFixedSize(true)
        val mainAdapter = MainAdapter(catFacts, { shareCatFact(it) })
        mainRecyclerView.layoutManager = LinearLayoutManager(this)
        mainRecyclerView.adapter = mainAdapter
    }
    
    override fun displayLoading() {
        progressCircle.visible()
        mainRecyclerView.gone()
    }

    override fun hideLoading() {
        progressCircle.gone()
        mainRecyclerView.visible()
    }

    override fun displayError() = Toast.makeText(this, R.string.error_message, Toast.LENGTH_LONG).show()

    private fun shareCatFact(message: String) {
        val shareIntent = Intent(Intent.ACTION_SEND)
        shareIntent.type = "text/plain"
        shareIntent.putExtra(android.content.Intent.EXTRA_TEXT, getString(R.string.cat_fact_content, message))
        startActivity(Intent.createChooser(shareIntent, getString(R.string.share_cat_fact)))
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.detach()
    }
}
