package byui.lemonade

val yellow = "\u001B[33m"
val reset = "\u001b[0m"

/*****************************************************************
 * all things menu / display related
 ****************************************************************/
class Menu {

    /*****************************************************************
     * main message
     ****************************************************************/
    fun showLogo() {
        // https://stackoverflow.com/questions/5762491/how-to-print-color-in-console-using-system-out-println
        println(yellow)
        println("__                                                                   __                   ______     __                                __")
        println("|  \\                                                                 |  \\                 /      \\   |  \\                              |  \\")
        println("| $$       ______   ______ ____    ______   _______    ______    ____| $$  ______        |  $$$$$$\\ _| $$.     ______   _______    ____| $$")
        println("| $$      /      \\ |      \\    \\  /      \\ |       \\  |      \\  /      $$ /      \\       | $$.__\\$$|   $$ \\   |      \\ |       \\  /      $$")
        println("| $$     |  $$$$$$\\| $$$$$$\\$$$$\\|  $$$$$$\\| $$$$$$$\\  \\$$$$$$\\|  $$$$$$$|  $$$$$$\\       \\$$    \\  \\$$$$$$    \\$$$$$$\\| $$$$$$$\\|  $$$$$$$")
        println("| $$     | $$    $$| $$ | $$ | $$| $$  | $$| $$  | $$ /      $$| $$  | $$| $$    $$       _\\$$$$$$\\  | $$ __  /      $$| $$  | $$| $$  | $$")
        println("| $$.____| $$$$$$$$| $$ | $$ | $$| $$._/ $$| $$  | $$|  $$$$$$$| $$._| $$| $$$$$$$$      |  \\__| $$  | $$|  \\|  $$$$$$$| $$  | $$| $$._| $$")
        println("| $$     \\\\$$    \\\\| $$ | $$ | $$ \\$$    $$| $$  | $$ \\$$    $$ \\$$    $$ \\$$     \\       \\$$    $$   \\$$  $$ \\$$    $$| $$  | $$ \\$$    $$")
        println("\\$$$$$$$$ \\$$$$$$$ \\$$  \\$$  \\$$  \\$$$$$$  \\$$   \\$$  \\$$$$$$$  \\$$$$$$$  \\$$$$$$$        \\$$$$$$     \\$$$$   \\$$$$$$$ \\$$   \\$$  \\$$$$$$$")
        println(reset)
    }

    /*****************************************************************
     * welcome message
     ****************************************************************/
    fun showWelcome() {
        println("\nWelcome to Lemonsville, Utah. In this small town, you are in charge of running your own " +
                "lemonade stand."
        )
    }

    /*****************************************************************
     * 1st instruction
     ****************************************************************/
    fun showInstructions() {
        println("To manage your stand, you need to make the following decisions every day:" +
                "\n1. How many cups of lemonade to make" +
                "\n2. How many advertisements to make" +
                "\n3. What price to charge for your lemonade" +
                "\nPress any key to continue ..."
        )
    }

    /*****************************************************************
     * 2nd instruction
     ****************************************************************/
    fun showInstructionsContinue() {
        println("Your expenses are the sum of your costs (cups, lemons, sugar, ice, signs)." +
                "\nYour profits are the difference between your costs (expenses) and your sales (income)." +
                "\nThe amount of lemonade you sell each day depends on the weather, price you charge, " +
                "number of advertisements you place, etc." +
                "\nKeep track of your money because you can´t spend more than you have!" +
                "\nPress any key to begin ..."
        )
    }

    /*****************************************************************
     * daily report
     ****************************************************************/
    fun showReport(day: Int, probability: Int, forecast: String, weather: String, customers: Int, cups: Int, costs: Double, earnings: Double, balance: Double) {
        println(yellow)
        println("**************************************************")
        println("At the end of day $day \uD83C\uDF4B")
        println("The weather forecast was: ${probability * 10}% $forecast. In reality, the weather was $weather")
        println("You had $customers customers today, sold $cups cups of lemonade, spent $${String.format("%.2f", costs)} and made $${String.format("%.2f", earnings)}")
        println("Current balance: ${String.format("%.2f", balance)}")
        println("**************************************************")
        println(reset)

    }

    /*****************************************************************
     * goodbye
     ****************************************************************/
    fun showGoodbye() {
        println("\nThanks for stopping bye, come again soon")
    }
}

/*****************************************************************
 * daily welcome
 ****************************************************************/
fun showDay(day: Int, prediction: Int, weather: String, recipe: Map<String, Any>, balance: Double) {
    println(yellow)
    println("**************************************************")
    println("Welcome to day $day \uD83C\uDF4B")
    println("The weather prediction for today is: ${prediction * 10}% $weather")
    println("Current recipe: Lemons: ${recipe["lemons"]}, Sugar: ${recipe["sugar"]}, Water")
    println("Current balance: ${String.format("%.2f", balance)}")
    println("**************************************************")
    println(reset)
}

/*****************************************************************
 * how many cups to buy
 ****************************************************************/
fun showMakeCups(cost: Int) {
    println("- Cups cost $cost cent(s) each. How many would you like to buy?")
}

/*****************************************************************
 * how many ads to make
 ****************************************************************/
fun showMakeAds(cost: Int) {
    println("- Advertisements cost $cost cents each. How many would you like to make?")
}

/*****************************************************************
 * how much to charge per cup
 ****************************************************************/
fun showPerCup() {
    println("- What price (in cents) do you want to charge for cup of lemonade?")
}