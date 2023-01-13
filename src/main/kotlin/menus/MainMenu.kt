package menus

import Menu


class MainMenu(title: String, lambdaAction: () -> Unit) : Menu(title, lambdaAction) {

    override val listOfItems: MutableList<Menu> = mutableListOf(
        ArchiveMenu("Создать архив") { addItem() },
        ArchiveMenu("Выход") { exit() }
    )
}
