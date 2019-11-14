package ar.com.pabloflores.harrypotter.ui.adapter.delegate

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import ar.com.pabloflores.harrypotter.R
import ar.com.pabloflores.harrypotter.databinding.CharacterItemBinding
import ar.com.pabloflores.harrypotter.ui.adapter.ViewType
import ar.com.pabloflores.harrypotter.ui.adapter.ViewTypeDelegateAdapter
import ar.com.pabloflores.harrypotter.ui.adapter.delegate.CharacterViewHolder.Companion.LAYOUT
import ar.com.pabloflores.harrypotter.ui.model.CharacterUI

/**
 * Created by Pablo Flores on 14/11/19.
 */
class CharactersDelegateAdapter : ViewTypeDelegateAdapter {
    override fun onCreateViewHolder(parent: ViewGroup): RecyclerView.ViewHolder {
        val withDataBinding: CharacterItemBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            LAYOUT,
            parent,
            false
        )
        return CharacterViewHolder(withDataBinding)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, item: ViewType) {
        holder as CharacterViewHolder
        holder.viewDataBinding.also {
            it.character = item as CharacterUI
        }
    }
}

class CharacterViewHolder(val viewDataBinding: CharacterItemBinding) :
    RecyclerView.ViewHolder(viewDataBinding.root) {
    companion object {
        @LayoutRes
        val LAYOUT = R.layout.character_item
    }
}