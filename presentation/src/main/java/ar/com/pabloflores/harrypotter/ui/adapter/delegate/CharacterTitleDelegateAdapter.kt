package ar.com.pabloflores.harrypotter.ui.adapter.delegate

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import ar.com.pabloflores.harrypotter.R
import ar.com.pabloflores.harrypotter.databinding.CharacterTitleItemBinding
import ar.com.pabloflores.harrypotter.ui.adapter.ViewType
import ar.com.pabloflores.harrypotter.ui.adapter.ViewTypeDelegateAdapter

/**
 * Created by Pablo Flores on 19/11/19.
 */
class CharacterTitleDelegateAdapter : ViewTypeDelegateAdapter {
    override fun onCreateViewHolder(parent: ViewGroup): RecyclerView.ViewHolder {
        val withDataBinding: CharacterTitleItemBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            CharacterTitleViewHolder.LAYOUT,
            parent,
            false
        )
        return CharacterTitleViewHolder(withDataBinding)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, item: ViewType) {
        //Nothing to do here
    }
}

class CharacterTitleViewHolder(viewDataBinding: CharacterTitleItemBinding) :
    RecyclerView.ViewHolder(viewDataBinding.root) {
    companion object {
        @LayoutRes
        val LAYOUT = R.layout.character_title_item
    }
}