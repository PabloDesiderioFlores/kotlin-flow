package ar.com.pabloflores.harrypotter.ui.adapter.delegate

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import ar.com.pabloflores.harrypotter.R
import ar.com.pabloflores.harrypotter.databinding.ValuesTitleItemBinding
import ar.com.pabloflores.harrypotter.ui.adapter.ViewType
import ar.com.pabloflores.harrypotter.ui.adapter.ViewTypeDelegateAdapter

/**
 * Created by Pablo Flores on 19/11/19.
 */
class ValuesTitleDelegateAdapter : ViewTypeDelegateAdapter {
    override fun onCreateViewHolder(parent: ViewGroup): RecyclerView.ViewHolder {
        val withDataBinding: ValuesTitleItemBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            ValuesTitleViewHolder.LAYOUT,
            parent,
            false
        )
        return ValuesTitleViewHolder(withDataBinding)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, item: ViewType) {
        //Nothing to do here
    }
}

class ValuesTitleViewHolder(viewDataBinding: ValuesTitleItemBinding) :
    RecyclerView.ViewHolder(viewDataBinding.root) {
    companion object {
        @LayoutRes
        val LAYOUT = R.layout.values_title_item
    }
}