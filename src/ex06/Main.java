package ex06;

import ex03.View;
import ex04.Viewable_Table;
import ex05.*;

public class Main {

    private View view = new Viewable_Table().getView();
    private Menu menu = new Menu();
    private CommandQueue commandQueue = new CommandQueue();

    public void run() {
        menu.add(new ViewConsoleCommand(view));
        menu.add(new GenerateConsoleCommand(view));
        menu.add(new ChangeConsoleCommand(view));
        menu.add(new SaveConsoleCommand(view));
        menu.add(new RestoreConsoleCommand(view));
        menu.add(new UndoConsoleCommand(view));
        menu.add(new ExecuteConsoleCommand(view, commandQueue));
        menu.execute();
    }

    public static void main(String[] args) {
        Main main = new Main();
        main.run();
    }
}
