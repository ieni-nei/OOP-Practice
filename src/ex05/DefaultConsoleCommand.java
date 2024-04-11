package ex05;

import ex03.View;

/**
 * Реалізація консольної команди для введення агрументів за замовчуванням.
 */
public class DefaultConsoleCommand implements ConsoleCommand {
        
    private final View view;
    
    /**
     * Конструктор класу.
     * @param view Представлення, що буде використовуватися для виконання команди за замовчуванням.
     */
    public DefaultConsoleCommand(View view){
        this.view = view;
    }
    
    @Override
    public char getKey(){
        return 'd';
    }

    @Override
    public String toString(){
        return "'d'efault";
    }
    
    /**
     * Виконує команду введення за замовчуванням.
     */
    @Override
    public void execute(){
        view.initDefault();
        view.show();
    }
}
