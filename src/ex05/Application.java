package src.ex05;

import src.ex03.View;
import src.ex04.Viewable_Table;

import java.util.Scanner;

/**
 * Формує та відображає меню
 * 
 * Реалізує шаблон Singleton
 */
public class Application {

    private static final Application instance = new Application();

    private Application() {}

    public static Application getInstance() {
        return instance;
    }

    private final View view = new Viewable_Table().getView();

    private final Menu menu = new Menu();

    private final Scanner scanner = new Scanner(System.in);

    public void run() {
        menu.add(new ViewConsoleCommand(view));
        menu.add(new GenerateConsoleCommand(view));
        menu.add(new ChangeConsoleCommand(view));
        menu.add(new SaveConsoleCommand(view));
        menu.add(new RestoreConsoleCommand(view));
        menu.add(new UndoConsoleCommand(view));
        menu.add(new SortConsoleCommand(view));
        menu.execute();
    }

    public Scanner getScanner() {
        return scanner;
    }
}
