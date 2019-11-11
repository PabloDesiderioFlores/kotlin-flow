package ar.com.pabloflores.harrypotter.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import ar.com.pabloflores.domain.model.Character
import ar.com.pabloflores.domain.model.HouseInfo
import ar.com.pabloflores.harrypotter.R
import ar.com.pabloflores.harrypotter.databinding.CharacterItemBinding

/**
 * Created by Pablo Flores on 06/11/19.
 */
class CharacterAdapter : RecyclerView.Adapter<CharacterViewHolder>() {

    var characters: List<String> = emptyList()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun getItemCount() = characters.size

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        holder.viewDataBinding.also {
            it.character = characters[position]
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        val withDataBinding: CharacterItemBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            CharacterViewHolder.LAYOUT,
            parent,
            false
        )
        return CharacterViewHolder(withDataBinding)
    }
}

class CharacterViewHolder(val viewDataBinding: CharacterItemBinding) :
    RecyclerView.ViewHolder(viewDataBinding.root) {
    companion object {
        @LayoutRes
        val LAYOUT = R.layout.character_item
    }
}