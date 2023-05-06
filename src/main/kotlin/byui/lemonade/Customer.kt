package byui.lemonade

import kotlin.math.roundToInt

/*****************************************************************
 * all things customer related
 ****************************************************************/
class Customer {

    /*****************************************************************
     * generate pool of potential customers
     ****************************************************************/
    fun getPotentialCustomers(ads: Int) : Int {

        // foot traffic
        var customers = Stand().getRandomNumber(1, 25)
        // println("DEBUG: foot traffic = $customers")

        // ads
        if (ads > 0) {
            // every sign generates from 1-15 new customers
            for (i in 1..ads) {
                // customers += getRandomNumber(1, 15)
                val signs = Stand().getRandomNumber(1, 15)
                customers += signs
                // println("DEBUG: signs = $signs")
            }
        }

        // word of mouth
        //customers += wordOfMouth
        //println("DEBUG: word of mouth = $wordOfMouth")

        // println("DEBUG: potential customers = $customers")
        return customers
    }

    /*****************************************************************
     * generate pool of actual customers
     ****************************************************************/
    fun getRealCustomers(potentialCustomers: Int, weather: String) : Int {
        val customers: Double
        // depending on the weather, only a percentage of the customers show up
        customers = when(weather) {
            "stormy" -> potentialCustomers * .10
            "rainy" -> potentialCustomers * .25
            "cloudy" -> potentialCustomers * .50
            "windy" -> potentialCustomers * .75
            "sunny" -> potentialCustomers * .90
            "heatwave" -> potentialCustomers * 1.10
            else -> potentialCustomers * 1.0 // when hot, 100% of customers show up
        }

        // println("DEBUG: actual customers = ${customers.roundToInt()}")
        return customers.roundToInt() // round
    }
}