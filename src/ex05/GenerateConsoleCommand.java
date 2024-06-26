package ex05;

import ex03.View;
/**
 * Реалізація консольної команди для генерування випадкових агрументів.
 */
public class GenerateConsoleCommand implements ConsoleCommand {
    
    private final View view;
    
    public GenerateConsoleCommand(View view){
        this.view = view;
    }
    
    @Override
    public char getKey(){
        return 'g';
    }
    
    @Override
    public String toString(){
        return "'g'enerate";
    }
    
    @Override
    public void execute(){
        view.init();
        view.show();
    }
}
