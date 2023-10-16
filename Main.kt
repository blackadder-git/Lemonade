package byui.lemonade

// import java.io.File
// import java.nio.file.Paths
import kotlin.system.exitProcess

/*****************************************************************
 * main entry point
 ****************************************************************/
fun main(args: Array<String>) {

    val menu = Menu()
    menu.showLogo()
    menu.showWelcome()

    // loop
    do {
        println("Are you ready to play? [Y]es/[Q]uit]")

        val play = readln().lowercase()

        if (play == "q" || play == "quit") {
            menu.showGoodbye()
            exitProcess(0)
        }
    } while (play != "y" && play != "yes")

    menu.showInstructions()

    // press any key to continue
    readln()

    menu.showInstructionsContinue()

    // press any key to continue
    readln()

    // TODO: show existing games
    // val path = System.getProperty("user.dir")
    /*
    val path = Paths.get("").toAbsolutePath().toString()
    println("Working Directory = $path")

    File(path).walk().forEach {
        println(it)
    }*/

    val stand = Stand()
    stand.unpickle()

    do {
        stand.play()
        print("Press any key to continue, [X] to change your secret recipe or [Q] to exit")

        val play = readln().lowercase()

        if (play == "x" || play == "X") {
            println("modify lemonade mix ...")
        }

    } while (play != "q" && play != "x")

    // save game
    stand.pickle()

    menu.showGoodbye()
    exitProcess(0)
}
