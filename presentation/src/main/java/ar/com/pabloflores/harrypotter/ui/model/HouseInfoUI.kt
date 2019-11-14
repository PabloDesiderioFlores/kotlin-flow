package ar.com.pabloflores.harrypotter.ui.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

/**
 * Created by Pablo Flores on 14/11/19.
 */
@Parcelize
data class HouseInfoUI(val values: List<ValuesUI>, val characters: List<CharacterUI>) : Parcelable