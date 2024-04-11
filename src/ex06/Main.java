package ex06;

import ex03.View;
import ex04.Viewable_Table;
import ex05.*;

/**
 * Клас для запуску головного модуля програми.
 */
public class Main {

    /** Представлення для відображення даних. */
    private View view = new Viewable_Table().getView();

    /** Меню для взаємодії з користувачем. */
    private Menu menu = new Menu();

    /**
     * Запускає головний модуль програми.
     */
    public void run() {
        menu.add(new ViewConsoleCommand(view));
        menu.add(new GenerateConsoleCommand(view));
        menu.add(new DefaultConsoleCommand(view));
        menu.add(new ChangeConsoleCommand(view));
        menu.add(new SaveConsoleCommand(view));
        menu.add(new RestoreConsoleCommand(view));
        menu.add(new UndoConsoleCommand(view));
        menu.add(new ExecuteConsoleCommand(view));
        menu.execute();
    }

    /**
     * Точка входу у програму.
     *
     * @param args аргументи командного рядка
     */
    public static void main(String[] args) {
        Main main = new Main();
        main.run();
    }
}
