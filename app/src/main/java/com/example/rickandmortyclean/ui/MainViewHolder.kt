package com.example.rickandmortyclean.ui

import androidx.recyclerview.widget.RecyclerView.ViewHolder
import coil.load
import com.cai.randomuser.R
import com.cai.randomuser.databinding.RowViewBinding
import com.example.rickandmortyclean.model.Character

class MainViewHolder(
    private val item: RowViewBinding
) : ViewHolder(item.root) {

    fun bindToView(character: Character) {
        item.charName.text = character.name
        item.charSpecies.text = character.species
        item.charImage.load(character.image) {
            placeholder(R.drawable.user_placeholder)
            crossfade(true)
        }
        }
    }