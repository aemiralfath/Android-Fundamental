package com.aemiralfath.mylistview

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.aemiralfath.mylistview.databinding.ItemHeroBinding

class HeroAdapter internal constructor(private val context: Context) : BaseAdapter() {
    internal var heroes = arrayListOf<Hero>()

    override fun getCount(): Int = heroes.size

    override fun getItem(p0: Int): Any = heroes[p0]

    override fun getItemId(p0: Int): Long = p0.toLong()

    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
        var itemView = p1
        if (itemView == null) {
            itemView = LayoutInflater.from(context).inflate(R.layout.item_hero, p2, false)
        }

        val viewHolder = ViewHolder(itemView as View)

        val hero = getItem(p0) as Hero
        viewHolder.bind(hero)
        return itemView
    }

    private inner class ViewHolder(view: View) {
        private val binding = ItemHeroBinding.bind(view)

        fun bind(hero: Hero) {
            binding.txtName.text = hero.name
            binding.txtDescription.text = hero.description
            binding.imgPhoto.setImageResource(hero.photo)
        }
    }
}