package src.ex05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**Макрокоманда Pattern Command
 * 
 * Колекція об'єктів класу ConsoleCommand
 */
public class Menu implements Command {

    private List<ConsoleCommand> menu = new ArrayList<ConsoleCommand>();

    public ConsoleCommand add(ConsoleCommand command){
        menu.add(command);
        return command;
    }
    
    @Override
    public String toString(){
        String s = "Введіть команду...\n";
        for(ConsoleCommand c : menu){
            s += c + ", ";
        }
        s += "'q'uit: ";
        return s;
    }
    
    @Override
    public void execute() {
        String s = null;
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        menu:
        while (true) {
            do {
                System.out.print(this);
                try {
                    s = in.readLine();
                } catch (IOException e) {
                    System.err.println("Помилка: " + e);
                    System.exit(0);
                }
            } while (s.length() != 1);
            char key = s.charAt(0);
            if (key == 'q') {
                System.out.println("Вихід.");
                System.exit(0);
            }
            for (ConsoleCommand c : menu) {
                if (s.charAt(0) == c.getKey()) {
                    c.execute();
                    continue menu;
                }
            }
            System.out.println("Неправильна команда.");
            continue menu;
        }
    }

    /**
     * Повертає список команд меню.
     *
     * @return Список команд меню.
     */
    public List<ConsoleCommand> getCommands() {
        return menu;
    }
}
