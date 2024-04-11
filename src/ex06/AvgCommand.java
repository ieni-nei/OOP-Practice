package ex06;

import ex02.Calculate;
import ex02.Item2d;
import ex03.View;
import ex05.Command;

import java.util.List;

/**
 * Клас, що реалізує команду для знаходження середнього арифметичного значення.
 */
public class AvgCommand implements Command {

    private View view;

    /**
     * Конструктор класу AvgCommand.
     *
     * @param view Представлення, з якого отримується список елементів.
     */
    public AvgCommand(View view) {
        this.view = view;
    }

    
    /**
     * Виконання команди для знаходження середнього арифметичного значення.
     */
    @Override
    public void execute() {
        System.out.println("Визначення середнього арифметичного...");
        double result = 0;
        int count = 0;

        List<Item2d> items = view.getItems();
        if (items.isEmpty()) {
            System.out.println("Список елементів порожній.");
            return;
        }

        for (Item2d item : items) {
            List<Double> arguments = item.getArguments();
            if (arguments != null && !arguments.isEmpty()) {
                for (Double argument : arguments) {
                    result += argument;
                    count++;
                }
            }
        }

        if (count > 0) {
            result /= count;
            System.out.println("Середнє арифметичне аргументів = " + Calculate.roundValue(result, 2));
        } else {
            System.out.println("Немає аргументів для обчислення середнього арифметичного.");
        }
    }
}
