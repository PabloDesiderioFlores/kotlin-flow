package ar.com.pabloflores.harrypotter.ui.model

import android.os.Parcelable
import ar.com.pabloflores.harrypotter.ui.adapter.HouseInfoAdapterConstants
import ar.com.pabloflores.harrypotter.ui.adapter.ViewType
import kotlinx.android.parcel.Parcelize

/**
 * Created by Pablo Flores on 14/11/19.
 */
@Parcelize
data class ValuesUI(val values: String) : ViewType, Parcelable {
    override fun getViewType() = HouseInfoAdapterConstants.VALUES
}