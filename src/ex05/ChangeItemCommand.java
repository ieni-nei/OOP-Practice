package ex05;

import ex02.Item2d;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Команда для зміни значень елементів.
 */
public class ChangeItemCommand implements Command {

    private final Item2d item;
    private final Scanner scanner;

    /**
     * Конструктор з параметром.
     *
     * @param item Елементи, які потрібно змінити.
     */
    public ChangeItemCommand(Item2d item) {
        this.item = item;
        this.scanner = new Scanner(System.in);
    }

    /**
     * Виконує заміну елементів.
     */
    @Override
    public void execute() {
        if (item != null) {
            System.out.print("Введіть значення зміщення для аргументів: ");
            int newOffset = scanner.nextInt();
            
            List<Double> arguments = item.getArguments();
            List<Double> updatedArguments = new ArrayList<>();
            
            for (Double argument : arguments) {
                updatedArguments.add(argument + newOffset);
            }
            
            item.setArguments(updatedArguments);
            
            System.out.println("Змінено значення об'єкта. Нові аргументи: " + updatedArguments);
        } else {
            System.out.println("Помилка: елемент не було ініціалізовано.");
        }
    }    
}
