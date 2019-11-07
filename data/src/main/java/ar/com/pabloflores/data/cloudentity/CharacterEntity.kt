package ar.com.pabloflores.data.cloudentity


import com.google.gson.annotations.SerializedName

data class CharacterEntity(
    @SerializedName("_id")
    val id: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("role")
    val role: String,
    @SerializedName("house")
    val house: String,
    @SerializedName("school")
    val school: String,
    @SerializedName("bloodStatus")
    val bloodStatus: String
)