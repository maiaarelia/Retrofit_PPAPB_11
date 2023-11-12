package com.example.tugas_retrofit

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

import com.example.tugas_retrofit.databinding.ItemHeroBinding

class HeroAdapter(private val listHero: List<ResultItem>):
    RecyclerView.Adapter<HeroAdapter.ItemHeroViewHolder>() {

    inner class ItemHeroViewHolder(private val binding: ItemHeroBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(data: ResultItem) {
            with(binding) {
                heroId.text = data.id.toString()
                heroName.text = data.heroName

                    Glide.with(itemView.context).load(data.image).into(heroImg)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHeroViewHolder {
        val binding = ItemHeroBinding.inflate(
            LayoutInflater.from(parent.context),
            parent, false)
        return ItemHeroViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ItemHeroViewHolder, position: Int) {
        holder.bind(listHero[position])
    }

    override fun getItemCount(): Int = listHero.size

}