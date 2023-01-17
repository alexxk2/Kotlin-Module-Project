package menus

import Menu

class ArchiveMenu(title: String, lambdaAction: () -> Unit) : Menu(title, lambdaAction) {

    override val listOfItems: MutableList<Menu> = mutableListOf(
        NoteMenu("Создать заметку") { addItem() },
        NoteMenu("Назад") { exit() }
    )

    override fun printTitle() {
        println("Меню архива: $title")
    }

    override fun printTextToAddItem() {
        println("Введите имя новой заметки")
    }
}

