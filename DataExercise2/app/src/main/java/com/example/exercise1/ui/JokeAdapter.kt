package com.example.exercise1.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.exercise1.domain.models.Joke
import com.example.exercise1.databinding.ListJokesBinding

class JokeAdapter(val joke: MutableList<Joke> = mutableListOf()) : RecyclerView.Adapter<JokeAdapter.ViewHolder>() {

    fun addItems(items: List<Joke>){
        val previousSize = joke.size
        this.joke.addAll(items)
        notifyItemRangeChanged(previousSize, items.size - 1)
    }

    inner class ViewHolder(private val binding: ListJokesBinding) : RecyclerView.ViewHolder(binding.root) {
        fun onBind(item: Joke) {
            binding.jokesSetup.text = item.setup
            binding.jokesPunchline.text = item.punchline
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ListJokesBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind(joke[position])
    }

    override fun getItemCount(): Int {
        return joke.size
    }

}