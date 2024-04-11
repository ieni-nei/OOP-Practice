package ex06;

import ex02.Item2d;
import ex03.View;
import ex05.Command;

import java.util.List;

/**
 * Клас, що реалізує команду для знаходження мінімального та максимального аргументів.
 */
public class MinMaxCommand implements Command {

    private View view;

    /**
     * Конструктор класу MinMaxCommand.
     *
     * @param view Представлення, з якого отримується список елементів.
     */
    public MinMaxCommand(View view) {
        this.view = view;
    }

    /**
     * Виконання команди для знаходження мінімального та максимального аргументів.
     */
    @Override
    public void execute() {
        System.out.println("Визначення мінімального та максимального аргументів...");

        List<Item2d> items = view.getItems();
        if (items.isEmpty()) {
            System.out.println("Список елементів порожній.");
            return;
        }

        double minArgument = Double.MAX_VALUE;
        double maxArgument = Double.MIN_VALUE;

        for (Item2d item : items) {
            List<Double> arguments = item.getArguments();
            if (arguments != null && !arguments.isEmpty()) {
                for (Double argument : arguments) {
                    minArgument = Math.min(minArgument, argument);
                    maxArgument = Math.max(maxArgument, argument);
                }
            }
        }

        System.out.println("Найменший аргумент = " + minArgument);
        System.out.println("Найбільший аргумент = " + maxArgument);
    }
}
