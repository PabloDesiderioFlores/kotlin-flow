package ar.com.pabloflores.domain.model

data class House(
    val id: String,
    val name: String,
    val mascot: String,
    val headOfHouse: String,
    val houseGhost: String,
    val founder: String,
    val school: String?,
    val values: List<String>
)