package ar.com.pabloflores.harrypotter.ui.adapter

import android.view.ViewGroup
import androidx.collection.SparseArrayCompat
import androidx.recyclerview.widget.RecyclerView
import ar.com.pabloflores.harrypotter.ui.adapter.delegate.CharactersDelegateAdapter
import ar.com.pabloflores.harrypotter.ui.adapter.delegate.ValuesDelegateAdapter
import ar.com.pabloflores.harrypotter.ui.model.HouseInfoUI

/**
 * Created by Pablo Flores on 14/11/19.
 */
class HouseInfoAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var items: ArrayList<ViewType>
    private var delegateAdapter = SparseArrayCompat<ViewTypeDelegateAdapter>()

    init {
        delegateAdapter.put(HouseInfoAdapterConstants.VALUES, ValuesDelegateAdapter())
        delegateAdapter.put(HouseInfoAdapterConstants.CHARACTERS, CharactersDelegateAdapter())
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
        items.addAll(houseInfo.values)
        items.addAll(houseInfo.characters)
        notifyDataSetChanged()
    }
}