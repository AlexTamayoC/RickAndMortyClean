package com.example.rickandmortyclean.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.cai.randomuser.databinding.RowViewBinding
import com.example.rickandmortyclean.model.Character

class MainAdapter : RecyclerView.Adapter<MainViewHolder>() {

    private val users = mutableListOf<Character>()

    fun loadUsers(data: List<Character>) {
        users.clear()
        users.addAll(data)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        return MainViewHolder(
            RowViewBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount() = users.size

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        holder.bindToView(users[position])
    }
}