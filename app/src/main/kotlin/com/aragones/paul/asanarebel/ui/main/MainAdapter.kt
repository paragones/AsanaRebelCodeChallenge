package com.aragones.paul.asanarebel.ui.main

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.SeekBar
import android.widget.TextView
import com.aragones.paul.asanarebel.R
import com.aragones.paul.asanarebel.models.CatFact


class MainAdapter(private val catFacts: List<CatFact>,
                  private val shareCatFact: (String) -> Unit) : RecyclerView.Adapter<MainAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context)
                .inflate(R.layout.facts_view, parent, false))
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val content: TextView = view.findViewById(R.id.cat_fact_content) as TextView
        val seekBar: SeekBar = view.findViewById(R.id.seek_bar) as SeekBar
        val shareButton: ImageView = view.findViewById(R.id.share_button) as ImageView
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.content.text = catFacts[position].content
        holder.seekBar.max = catFacts[position].length - 1
        holder.seekBar.progress = catFacts[position].length
        holder.seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onStopTrackingTouch(seekBar: SeekBar) {}
            override fun onStartTrackingTouch(seekBar: SeekBar) {}
            override fun onProgressChanged(seekBar: SeekBar, progress: Int, fromUser: Boolean) {
                if (progress != catFacts[position].length) holder.content.text = catFacts[position].content.substring(0, progress)
            }
        })
        holder.shareButton.setOnClickListener {
            shareCatFact(holder.content.text.toString())
        }
    }

    override fun getItemCount(): Int = catFacts.size
}