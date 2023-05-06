# Overview

## Software Description
The program I created tracks the daily sale of lemonade. Players start the game with $2.00. Using a generated weather report, they buy cups, ice and advertisements. An algorithm translates potential customers to actual customers which may or may not buy the product. Depending on the mix of lemonade, they may spread the word to others and increase the number of customers that show up the next day.  

## Purpose
I wrote this program to get some hands on experience using Kotlin. The design for this app included all the moving parts I thought would be necessary including: variables, constants, functions, classes, collections and conditions 

[Software Demo Video](https://blackadder-git.github.io/byui/cse310/lemonade.html)

The following list includes some of the language specific things I learned:
- semicolons are optional, at first I missed them but now I'm used to it
- functions begin with "*fun*" because they are fun
- objects are instantiated without new
- parameter names come before they type
- return parameters are declared after the function parameters
- class constructors look like function parameters
- classes can use init to perform an action that might go in a traditional constructor
- when loops don't need *"break"* or "*case*" but do need *"else"*
- when doesn't need condition
- val is used to create constants
- var is used to create variables
- explicit type is optional, if used comes after the variable name
- functions can be defined in classes or outside (it just works)

# Development Environment

- Intellij 2023.1 Community Edition
- Kotlin 1.8.0
- JDK 11

# Useful Websites

- [Coding conventions](https://kotlinlang.org/docs/coding-conventions.html)
- [Conditions and loops](https://kotlinlang.org/docs/control-flow.html)
- [Kotlin for Beginners](https://www.youtube.com/watch?v=k9K71QkrHGE&list=PLrnPJCHvNZuAIbejjZA1kGfLeA8ZpICB2)
- [BYU-I reference](https://byui-cse.github.io/cse222b-course/week03/index.html)

# Future Work

- Let a player name their stand
- Let a player to change their lemonade recipe
- Add word of mouth to increase potential customers
- Make multiplayer
- Build unit tests
- Save to and load from disk
- More testing, so much more testing ...