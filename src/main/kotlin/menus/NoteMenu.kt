package menus

import Menu
import java.util.Scanner

class NoteMenu(title: String, lambdaAction: () -> Unit) : Menu(title, lambdaAction) {

    private var content = ""

    override val listOfItems: MutableList<Menu> = mutableListOf(
        Note("Посмотреть заметку") { watchNoteText() },
        Note("Добавить текст в заметку") { addTextToNote() },
        Note("Очистить заметку") { cleanNote() },
        Note("Назад") { exit() }
    )

    override fun printTitle() {
        println("Меню заметки: $title")
    }

    override fun printTextToAddItem() {
        println("Добавьте текст в заметку")
    }

    private fun addTextToNote() {
        println("Введите текст, который хотите добавить в заметку")
        val newText = Scanner(System.`in`).nextLine()
        content += "$newText \n"
        return
    }

    private fun cleanNote() {
        content = ""
        println("Заметка очищена")
    }

    private fun watchNoteText() {
        println(if (content == "") "Заметка пуста" else content)
        return
    }
}
