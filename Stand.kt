package byui.lemonade

// import kotlin.math.roundToInt
import kotlin.random.Random
// import kotlin.system.exitProcess

// import kotlinx.serialization.*
// import kotlinx.serialization.json.*

//@Serializable
/*****************************************************************
 * all things stand related
 ****************************************************************/
class Stand (path: String = "new"){
    // default values
    var day = 1
    var balance: Double = 2.00
    var name = "Don Limon"
    val days = mutableListOf<Day>()

    var recipe = mutableMapOf("lemons" to 1, "sugar" to 1, "mix" to "refreshing") // more lemons = sour, more sugar = sweet

    // expenses
    val INGREDIENTS = 2 // cost of lemons, sugar and water TODO: make this variable
    var cups = 0
    var cupsCost = 0
    var ads = 0
    var adsCost = 0
    var ice = 0
    var iceCost = 0
    var cost: Double = 0.0
    var expenses: Double = 0.0

    // income
    var price: Double = 0.0
    var cupsSold = 0
    var income: Double = 0.0

    // customer
    val SWEET_TOOTH = 25 // below this %, customers prefer sugar
    val SOUR_TOOTH = 75 // above this %, customers prefer lemon
    var customers = 0
    var wordOfMouth = 0
    var probability = 5 // % chance of weather
    var forecast = "sunny"
    var weather = "sunny"

    // initialize class
    init {
        if (path == "new") {
            // println("create a new stand")
        }
        else {
            // TODO: load existing stand
            // println("load existing stand")
            day = 3
            balance = 2.50
            name = "Coconut Nut"
        }
    }

    /*****************************************************************
     * game loop
     ****************************************************************/
    fun play() {

        welcome()

        // recipe
        // promptForRecipe()

        calculateExpenses()

        calculateIncome()

        // track days in collection
        val d = Day(day, forecast, weather, cups, ads, expenses, price, cupsSold, income, recipe)
        days.add(d)

        Menu().showReport(day, probability, forecast, weather, customers, cupsSold, expenses, income, balance)

        day++
    }

    /*****************************************************************
     * show each day
     ****************************************************************/
    fun welcome() {
        // show day and weather
        getWeatherReport()
        showDay(day, probability, forecast, recipe, balance)
    }

    /*****************************************************************
     * get daily forecast
     ****************************************************************/
    fun getWeatherReport() {
        this.probability = Weather().getProbability()
        this.forecast = Weather().getDescription()
        this.weather = Weather().getWeather(this.probability, this.forecast)
    }

    /*****************************************************************
     * change secret recipe
     ****************************************************************/
    fun promptForRecipe() {
        println("Would you like to change the recipe? [Y]es/[N]o]")
    }

    /*****************************************************************
     * determine expenses
     ****************************************************************/
    fun calculateExpenses() {
        // cups
        promptForCups()

        // ice
        promptForIce()

        // signs
        promptForSigns()

        // price
        promptForPrice()

        // price per cup
        cost = (cupsCost + INGREDIENTS) * .01  // convert to cents
        if (ice > 0) {
            cost += iceCost * .01
        }

        // expenses include ads
        expenses = (cups * cost).toDouble()
        if (ads > 0) {
            expenses += ads * (adsCost * .01)
        }

        this.balance -= expenses

        // println("DEBUG: cost = $cost, cups = $cups, cupsCost = ${cupsCost * .01}, ing = ${INGREDIENTS * .01}")
        // println("DEBUG: expenses = $expenses")
    }

    /*****************************************************************
     * how many cups to buy
     ****************************************************************/
    fun promptForCups() {
        var exit = false
        cupsCost = getRandomNumber(1, 2)
        do {
            showMakeCups(cupsCost)
            try {
                this.cups = readln().toInt()
                exit = true
            }
            catch(e: Exception) {
                // expecting an int
                println("Please enter the number of cups you want to buy")
            }
        } while(!exit)
    }

    /*****************************************************************
     * buy ice or not
     ****************************************************************/
    fun promptForIce() {
        iceCost = getRandomNumber(1, 3)

        do {
            println("- Ice costs $iceCost cent(s) per cup. Add? [Y]es/[N]o]")

            val addIce = readln().lowercase()

            if (addIce == "y" || addIce == "yes") {
                ice = iceCost
            }
            else {
                ice = 0
            }
        } while (addIce != "y" && addIce != "yes" && addIce != "n" && addIce != "no")
    }

    /*****************************************************************
     * how many signs to print
     ****************************************************************/
    fun promptForSigns() {
        var exit = false
        adsCost = getRandomNumber(10, 20)

        do {
            showMakeAds(adsCost)
            try {
                this.ads = readln().toInt()
                exit = true
            }
            catch(e: Exception) {
                // expecting an int
                println("Please enter the number of ads you want to buy")
            }
        } while(!exit)
    }

    /*****************************************************************
     * how much to charge for each lemonade
     ****************************************************************/
    fun promptForPrice() {
        var exit = false

        do {
            showPerCup()
            try {
                this.price = readln().toDouble() * .01
                exit = true
            }
            catch(e: Exception) {
                // expecting an int
                println("Please enter the price (in cents) you want to charge a cup of lemonade")
            }
        } while(!exit)
    }

    /*****************************************************************
     * determine income
     ****************************************************************/
    fun calculateIncome() {
        // customers
        val potentialCustomers = Customer().getPotentialCustomers(ads)

        this.customers = Customer().getRealCustomers(potentialCustomers, weather)

        // income
        this.cupsSold = cupsSold(this.customers)
        this.income = String.format("%.2f", (this.cupsSold * this.price).toDouble()).toDouble()
        this.balance += this.income

        // println("DEBUG: cups sold = ${this.cupsSold} at price = ${this.price} = $${this.income}")
    }

    /*****************************************************************
     * how many cups of lemonade were sold
     ****************************************************************/
    fun cupsSold(customers: Int) : Int {
        var sold = false
        var cups = 0
        // 25% of customers like sweet, 25% like sour, 50% like refreshing
        val sweet = (customers * .25).toInt()
        val sour = (customers * .25).toInt()
        val refreshing = (customers * .5).toInt()

        // println("DEBUG: cost = $cost, price = $price")
        // TODO: there must be a better way to call this loop ...
        for (i in 1..customers) {
            if (cost + .05 >= price) {
                // println("90% of customers will buy today")
                if (buyLemonade(90)) {
                    sold = true
                }
            }
            else if (cost + .10 >= price) {
                // println("80% of customers will buy today")
                if (buyLemonade(80)) {
                    sold = true
                }
            }
            else if (cost + .15 >= price) {
                // println("70% of customers will buy today")
                if (buyLemonade(70)) {
                    sold = true
                }
            }
            else if (cost + .20 >= price) {
                // println("60% of customers will buy today")
                if (buyLemonade(60)) {
                    sold = true
                }
            }
            else if (cost + .25 >= price) {
                // println("50% of customers will buy today")
                if (buyLemonade(50)) {
                    sold = true
                }
            }
            else if (cost + .30 >= price) {
                // println("40% of customers will buy today")
                if (buyLemonade(40)) {
                    sold = true
                }
            }
            else if (cost + .35 >= price) {
                // println("30% of customers will buy today")
                if (buyLemonade(30)) {
                    sold = true
                }
            }
            else if (cost + .40 >= price) {
                // println("20% of customers will buy today")
                if (buyLemonade(20)) {
                    sold = true
                }
            }
            else if (cost + .45 >= price) {
                // println("10% of customers will buy today")
                if (buyLemonade(10)) {
                    sold = true
                }
            }
            else if (cost + .50 >= price) {
                // println("5% of customers will buy today")
                if (buyLemonade(5)) {
                    sold = true
                }
            }
            else {
                println("That is some expensive lemonade ...")
            }

            // customer has purchased a cup of lemonade
            if (sold) {
                cups++
                val preference = getRandomNumber(1, 100)

                when(recipe["mix"]) {
                    "sweet" -> {
                        when {
                            //
                            preference <= SWEET_TOOTH -> wordOfMouth += 2
                            preference >= SOUR_TOOTH -> wordOfMouth--
                            else -> wordOfMouth++
                        }
                    }
                    "refreshing" -> {
                        // if (preference > SWEET_TOOTH && preference < SOUR_TOOTH)
                        if (preference in (SWEET_TOOTH + 1) until SOUR_TOOTH)
                            wordOfMouth++
                    }
                    "sour" -> {
                        when {
                            preference <= SWEET_TOOTH -> wordOfMouth--
                            preference >= SOUR_TOOTH -> wordOfMouth += 2
                            else -> wordOfMouth++
                        }
                    }
                }

                sold = false
            }
        }
        // println("DEBUG: cups sold = $cups")
        return cups
    }

    /*****************************************************************
     * is a purchase made
     ****************************************************************/
    fun buyLemonade(percent: Int) : Boolean {
        var buy = false
        if (getRandomNumber(1, 100) <= percent) {
            buy = true
        }
        // println("DEBUG: buy lemonade = $buy")
        return buy
    }

    /*****************************************************************
     * generate a random number between min and max
     ****************************************************************/
    fun getRandomNumber(min: Int, max: Int) : Int {
        // (min..max).random()
        return Random.nextInt(min, max)
    }

    /*****************************************************************
     * save to disk
     ****************************************************************/
    fun pickle() {
        println("TODO: save game to file")
    }

    /*****************************************************************
     * read from disk
     ****************************************************************/
    fun unpickle() {
        println("TODO: read game from file")
    }
}