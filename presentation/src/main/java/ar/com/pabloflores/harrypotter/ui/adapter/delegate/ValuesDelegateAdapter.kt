package ar.com.pabloflores.harrypotter.ui.adapter.delegate

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import ar.com.pabloflores.harrypotter.R
import ar.com.pabloflores.harrypotter.databinding.ValuesItemBinding
import ar.com.pabloflores.harrypotter.ui.adapter.ViewType
import ar.com.pabloflores.harrypotter.ui.adapter.ViewTypeDelegateAdapter
import ar.com.pabloflores.harrypotter.ui.adapter.delegate.ValuesViewHolder.Companion.LAYOUT
import ar.com.pabloflores.harrypotter.ui.model.ValuesUI

/**
 * Created by Pablo Flores on 14/11/19.
 */
class ValuesDelegateAdapter : ViewTypeDelegateAdapter {
    override fun onCreateViewHolder(parent: ViewGroup): RecyclerView.ViewHolder {
        val withDataBinding: ValuesItemBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            LAYOUT,
            parent,
            false
        )
        return ValuesViewHolder(withDataBinding)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, item: ViewType) {
        holder as ValuesViewHolder
        holder.viewDataBinding.also {
            it.values = item as ValuesUI
        }
    }
}

class ValuesViewHolder(val viewDataBinding: ValuesItemBinding) :
    RecyclerView.ViewHolder(viewDataBinding.root) {
    companion object {
        @LayoutRes
        val LAYOUT = R.layout.values_item
    }
}