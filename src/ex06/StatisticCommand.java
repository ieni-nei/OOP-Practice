package ex06;

import ex02.Item2d;
import ex03.View_Result;
import ex05.Command;

import java.util.List;

public class StatisticCommand implements Command {

    private View_Result viewResult;

    // Updated constructor to accept View_Result
    public StatisticCommand(View_Result viewResult) {
        this.viewResult = viewResult;
    }

    @Override
    public void execute() {
        List<Item2d> items = viewResult.getItems();
        if (items.isEmpty()) {
            System.out.println("Список елементів порожній.");
            return;
        }

        double min = Double.MAX_VALUE;
        double max = Double.MIN_VALUE;
        double sum = 0;

        for (Item2d item : items) {
            double value = item.getResult();
            min = Math.min(min, value);
            max = Math.max(max, value);
            sum += value;
        }

        double average = sum / items.size();

        System.out.println("Мінімальне значення: " + min);
        System.out.println("Максимальне значення: " + max);
        System.out.println("Середнє значення: " + average);
    }
}
