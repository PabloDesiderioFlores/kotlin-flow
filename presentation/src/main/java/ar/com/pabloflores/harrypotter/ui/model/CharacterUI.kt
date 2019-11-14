package ar.com.pabloflores.harrypotter.ui.model

import android.os.Parcelable
import ar.com.pabloflores.harrypotter.ui.adapter.HouseInfoAdapterConstants
import ar.com.pabloflores.harrypotter.ui.adapter.ViewType
import kotlinx.android.parcel.Parcelize

/**
 * Created by Pablo Flores on 14/11/19.
 */
@Parcelize
class CharacterUI(
    val id: String,
    val bloodStatus: String,
    val house: String,
    val name: String,
    val role: String,
    val school: String?
) : ViewType, Parcelable {
    override fun getViewType() = HouseInfoAdapterConstants.CHARACTERS
}