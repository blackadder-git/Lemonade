package byui.lemonade

/*****************************************************************
 * all things weather related
 ****************************************************************/
class Weather {

    val weather = mapOf(1 to "stormy", 2 to "rainy", 3 to "cloudy", 4 to "windy", 5 to "sunny", 6 to "hot", 7 to "heat wave")

    /*****************************************************************
     * chance of accurate forecast
     ****************************************************************/
    fun getProbability(): Int {
        return (1..9).random()
    }

    /*****************************************************************
     * return actual weather
     ****************************************************************/
    fun getWeather(probability: Int, forecast: String ): String {
        var weather = "sunny"
        val barometer = (1..10).random()

        // e.g probability is 80% sunny, if barometer is greater than 8, forecast is inaccurate
        // a low probability is likely to be wrong while a high probability is likely to be accurate
        if (barometer > probability) {
            if ((1..2).random() == 1) {
                // weather is hotter than expected
                weather = when(forecast) {
                    "stormy" -> "rainy"
                    "rainy" -> "cloudy"
                    "cloudy" -> "windy"
                    "windy" -> "sunny"
                    "sunny" -> "hot"
                    "hot" -> "heatwave"
                    else -> "heatwave" // doesn't get hotter than heatwave
                }
                // stormy ⛈️
                // rainy 🌧️
                // cloudy ☁️
                // windy 🍃
                // sunny ☀️
                // hot 🌶️
                // headwave 🔥

            }
            else {
                // weather is cooler than expected
                weather = when(forecast) {
                    "rainy" -> "stormy"
                    "cloudy " -> "rainy"
                    "windy" -> "cloudy"
                    "sunny" -> "windy"
                    "hot" -> "sunny"
                    "heatwave" -> "hot"
                    else -> "stormy" // doesn't get cooler than stormy
                }
            }
        }

        return weather
    }

    /*****************************************************************
     * get weather description
     ****************************************************************/
    fun getDescription() : String {
        val weather = (0..11).random()

        // sunny, rainy, windy, stormy, cloudy, heat wave
        val description = when (weather) {
            0 -> "stormy"
            1 -> "rainy"
            2 -> "cloudy"
            3 -> "cloudy"
            4 -> "windy"
            5 -> "sunny"
            6 -> "sunny"
            7 -> "sunny"
            8 -> "hot"
            9 -> "hot"
            else -> "heatwave"
        }

        return description
    }
}