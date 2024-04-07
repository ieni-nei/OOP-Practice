package ex06;

import ex02.Item2d;
import ex03.View_Result;
import ex05.Command;

import java.util.List;

public class AvgCommand implements Command {

    private View_Result viewResult;

    public AvgCommand(View_Result viewResult) {
        this.viewResult = viewResult;
    }

    @Override
    public void execute() {
        System.out.println("Середнє обчислено...");
        double result = 0;
        int count = 0;

        List<Item2d> items = viewResult.getItems();
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
            System.out.println("Середнє арифметичне аргументів = " + result);
        } else {
            System.out.println("Немає аргументів для обчислення середнього арифметичного.");
        }
    }
}
