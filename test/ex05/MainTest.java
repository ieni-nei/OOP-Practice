package test.ex05;

import ex02.Item2d;
import ex05.ChangeItemCommand;

import java.util.ArrayList;
import java.util.List;

/**
 * Клас для тестування класу ChangeItemCommand.
 */
public class MainTest {

    /**
     * Головний метод програми.
     *
     * @param args аргументи командного рядка
     */
    public static void main(String[] args) {
        testChangeItemCommand();
    }

    /**
     * Метод для тестування зміни елемента.
     */
    private static void testChangeItemCommand() {
        System.out.println("Тестування ChangeItemCommand...");
        List<Double> initialArguments = new ArrayList<>();
        initialArguments.add(1.0);
        initialArguments.add(2.0);
        initialArguments.add(3.0);

        Item2d item = new Item2d(initialArguments);

        ChangeItemCommand command = new ChangeItemCommand(item);

        System.out.println("Початкові аргументи елемента: " + item.getArguments());

        command.execute();

        System.out.println("Змінені аргументи елемента: " + item.getArguments());
    }
}
