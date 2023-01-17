import menus.ArchiveMenu

import menus.Note
import menus.NoteMenu
import java.util.*


abstract class Menu(val title: String, val lambdaAction: () -> Unit) {

    var isExitTime = false
    var menuToPass: Menu? = null
    open val listOfItems = mutableListOf<Menu>()

    private fun printMenu() {
        println()
        printTitle()
        listOfItems.forEachIndexed { index, menu ->
            println("${index}. ${menu.title}")
        }
        return
    }

    open fun addItem() {
        printTextToAddItem()
        val newName = Scanner(System.`in`).nextLine()
        val indexOfNewItem = listOfItems.size - 1
        val newItem = when {
            listOfItems[0] is ArchiveMenu -> ArchiveMenu(newName) { openItem(indexOfNewItem) }
            listOfItems[0] is NoteMenu -> NoteMenu(newName) { openItem(indexOfNewItem) }
            else -> Note(newName) { openItem(indexOfNewItem) }
        }
        listOfItems.add(indexOfNewItem, newItem)
        return
    }

    fun takeUserInput() {
        menuToPass = null
        printMenu()
        println("Выберите пункт меню")
        val userInput = Scanner(System.`in`).nextLine().toIntOrNull()
        if (userInput == null) {
            println("Необходимо ввести цифру")
            takeUserInput()
        } else if (listOfItems.indices.contains(userInput)) {
            listOfItems[userInput].lambdaAction()
        } else {
            println("Необходимо ввести цифру из предложенных в меню")
            takeUserInput()
        }
    }

    open fun openItem(index: Int) {
        menuToPass = listOfItems[index]

    }

    open fun printTitle() {
        println(title)
    }

    open fun printTextToAddItem() {
        println("Введите имя нового архива")
    }

    open fun exit() {
        isExitTime = true
    }
}