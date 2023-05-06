/*
* Write one or more programs in Kotlin that demonstrates some of the following:
- Variables (mutable and immutable)
- Expressions
- Conditionals
- Loops
- Functions
- Classes
Use the Kotlin README.md template.
Stretch Challenges (select one):
- Modify your program to demonstrate the creation and modification of collections. e.g (sets, lists, maps)
- Modify your program to demonstrate data classes.
- Modify your program to demonstrate the varied uses of the when keyword.
* */

fun main(args: Array<String>) {
    val welcome = "Welcome to Lemonsville, Utah. In this small town, you are in charge of running your own" +
            "lemonade stand."
    val instructions_one = "To manage your lemonade stand, you will need to make these decisions every day:" +
            "\n1. How many glasses of lemonade to make (only one batch is made each morning)" +
            "\n2. How many advertisments to make (the signs cost .15 cents each)" +
            "\n3. What price to charge for each glass" +
            "\n\nYou will begin with $2.00 cash. Using the sugar you got from your mother. Your cost to make " +
            "lemonade is .02 cents per glass (this may chagne in the future)." +
            "\nPress Space to continue"
    val instructions_two = "Your expenses are the sum of the cost of the lemonade and the cost of hte signs." +
            "\nYour profits are the difference between sales income and expenses." +
            "\nThe number of glasses you sell each day depends o the price you charge, " +
            "and on the number of advertisments you place." +
            "\nKeep track of your money becasue you can´t spend more than you have!"

    println(welcome)

    // loop
    do {
        println("Are you ready to play? Yes/No")
        var play = readln()
    } while (play != "yes")

    println(instructions_one)

    // loop
    do {
        println("Are you ready to play? Yes/No")
        var space = readln()
        // println(space) TODO: capture spacebar
    } while (space != "yes")

    println(instructions_two)

     var lemonade = Lemonade()
    lemonade.drink()
    lemonade.play()
}