import menus.MainMenu

fun main() {

    val setOfPreviousMenus: MutableSet<Menu?> = mutableSetOf(null)
    val mainMenu = MainMenu("Список архивов") {}
    var currentMenu: Menu = mainMenu

    while (true) {

        currentMenu.takeUserInput()

        if (currentMenu.menuToPass != null) {
            setOfPreviousMenus.add(currentMenu)
        }

        currentMenu = currentMenu.menuToPass ?: currentMenu

        if (currentMenu.isExitTime) {
            currentMenu.isExitTime = false
            currentMenu = setOfPreviousMenus.last() ?: break
            setOfPreviousMenus.remove(setOfPreviousMenus.last())
        }
    }
}






