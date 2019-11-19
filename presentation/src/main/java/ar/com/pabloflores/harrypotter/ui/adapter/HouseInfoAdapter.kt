package ar.com.pabloflores.harrypotter.ui.adapter

import android.view.ViewGroup
import androidx.collection.SparseArrayCompat
import androidx.recyclerview.widget.RecyclerView
import ar.com.pabloflores.harrypotter.ui.adapter.delegate.CharacterTitleDelegateAdapter
import ar.com.pabloflores.harrypotter.ui.adapter.delegate.CharactersDelegateAdapter
import ar.com.pabloflores.harrypotter.ui.adapter.delegate.ValuesDelegateAdapter
import ar.com.pabloflores.harrypotter.ui.adapter.delegate.ValuesTitleDelegateAdapter
import ar.com.pabloflores.harrypotter.ui.model.HouseInfoUI

/**
 * Created by Pablo Flores on 14/11/19.
 */
class HouseInfoAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var items: ArrayList<ViewType>
    private var delegateAdapter = SparseArrayCompat<ViewTypeDelegateAdapter>()
    private val valuesTitle = object : ViewType {
        override fun getViewType() = HouseInfoAdapterConstants.VALUES_TITLE
    }
    private val charactersTitle = object : ViewType {
        override fun getViewType() = HouseInfoAdapterConstants.CHARACTERS_TITLE
    }

    init {
        delegateAdapter.put(HouseInfoAdapterConstants.VALUES, ValuesDelegateAdapter())
        delegateAdapter.put(HouseInfoAdapterConstants.CHARACTERS, CharactersDelegateAdapter())
        delegateAdapter.put(
            HouseInfoAdapterConstants.CHARACTERS_TITLE,
            CharacterTitleDelegateAdapter()
        )
        delegateAdapter.put(HouseInfoAdapterConstants.VALUES_TITLE, ValuesTitleDelegateAdapter())
        items = ArrayList()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        delegateAdapter.get(viewType)!!.onCreateViewHolder(parent)

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        delegateAdapter.get(getItemViewType(position))?.onBindViewHolder(holder, items[position])
    }

    override fun getItemViewType(position: Int) = items[position].getViewType()


    fun addHouseInfo(houseInfo: HouseInfoUI) {
        items.clear()
        items.add(valuesTitle)
        items.addAll(houseInfo.values)
        items.add(charactersTitle)
        items.addAll(houseInfo.characters)
        notifyDataSetChanged()
    }
}