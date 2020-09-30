package kz.iitu.busfleets.models

data class Item(
    val id: Int? = null,
    val city: String,
    val toCity: String,
    val leaveDate: String,
    var arriveDate: String,
    val name: String,
    val number: String,
    val quantity: Int = 0

)