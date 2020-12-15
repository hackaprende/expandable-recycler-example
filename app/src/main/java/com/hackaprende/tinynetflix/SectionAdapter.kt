package com.hackaprende.tinynetflix

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView

class SectionAdapter(val context: Context) : ListAdapter<Section, SectionAdapter.ViewHolder>(DiffCallback) {

    companion object DiffCallback : DiffUtil.ItemCallback<Section>() {
        override fun areItemsTheSame(oldItem: Section, newItem: Section): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: Section, newItem: Section): Boolean {
            return oldItem.name == newItem.name
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.section_list_item, parent,
            false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val section = getItem(position)
        holder.bind(section)
    }

    inner class ViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {

        private val sectionNameText = view.findViewById<TextView>(R.id.section_name_text)
        private val movieRecycler = view.findViewById<RecyclerView>(R.id.movie_recycler)

        fun bind(section: Section) {
            sectionNameText.text = section.name

            sectionNameText.setOnClickListener {
                if (section.expanded) {
                    sectionNameText
                            .setCompoundDrawablesWithIntrinsicBounds(
                                    R.drawable.ic_baseline_arrow_drop_down_24,
                                    0, 0, 0
                            )
                    movieRecycler.visibility = View.GONE
                } else {
                    sectionNameText
                            .setCompoundDrawablesWithIntrinsicBounds(
                                    R.drawable.ic_baseline_arrow_drop_up_24,
                                    0, 0, 0
                            )
                    movieRecycler.visibility = View.VISIBLE
                }

                section.expanded = !section.expanded
            }

            movieRecycler.layoutManager = LinearLayoutManager(context)
            val movieAdapter = MovieAdapter()
            movieRecycler.adapter = movieAdapter
            movieAdapter.submitList(section.movieList)
        }
    }
}