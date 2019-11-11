package ar.com.pabloflores.data.cloudentity


import com.google.gson.annotations.SerializedName

data class HouseEntity(
    @SerializedName("_id")
    val id: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("mascot")
    val mascot: String,
    @SerializedName("headOfHouse")
    val headOfHouse: String,
    @SerializedName("houseGhost")
    val houseGhost: String,
    @SerializedName("founder")
    val founder: String,
    @SerializedName("school")
    val school: String?,
    @SerializedName("values")
    val values: List<String>
)