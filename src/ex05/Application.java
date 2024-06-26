package ex05;

import ex03.View;
import ex04.Viewable_Table;

/**
 * Формує та відображає меню
 * 
 * Реалізує шаблон Singleton
 */
public class Application {

    private static final Application instance = new Application();

    private Application() {}

    /**
     * Повертає єдиний екземпляр класу Application.
     * 
     * @return єдиний екземпляр класу Application
     */
    public static Application getInstance() {
        return instance;
    }

    private final View view = new Viewable_Table().getView();

    private final Menu menu = new Menu();

    /**
     * Запускає додаток, додаючи команди до меню та виконуючи його.
     */
    public void run() {
        menu.add(new ViewConsoleCommand(view));
        menu.add(new GenerateConsoleCommand(view));
        menu.add(new DefaultConsoleCommand(view));
        menu.add(new ChangeConsoleCommand(view));
        menu.add(new SaveConsoleCommand(view));
        menu.add(new RestoreConsoleCommand(view));
        menu.add(new UndoConsoleCommand(view));
        menu.execute();
    }
}
