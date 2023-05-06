package byui.lemonade

/*****************************************************************
 * data class with historical data
 ****************************************************************/
data class Day(
    val day: Int,
    val forecast: String,
    val weather: String,
    val cups: Int,
    val ads: Int,
    val expenses: Double,
    val price: Double,
    val sold: Int,
    val income: Double,
    val recipe: Map<String, Any>
)
