package ex05;

import ex03.View;
/**
 * Консольна команда, що скасовує команду. 
 */
public class UndoConsoleCommand implements ConsoleCommand {

    private final View view;
    
    public UndoConsoleCommand(View view) {
        this.view = view;
    }

    @Override
    public char getKey() {
        return 'u';
    }

    @Override
    public String toString() {
        return "'u'ndo";
    }

    @Override
    public void execute() {
        UndoReserve undoReserve = new UndoReserve(view);
        System.out.println("Скасувано останню команду.");
        try {
            undoReserve.undo();
        } catch (Exception e) {
            System.err.println("Помилка серіалізації: " + e);
        }
    }
}
