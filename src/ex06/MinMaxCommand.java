package ex06;

import ex02.Item2d;
import ex03.View_Result;
import ex05.Command;

import java.util.List;

public class MinMaxCommand implements Command {

    private View_Result viewResult;

    public MinMaxCommand(View_Result viewResult) {
        this.viewResult = viewResult;
    }

    @Override
    public void execute() {
        System.out.println("Визначення мінімального та максимального...");
        double min = Double.MAX_VALUE;
        double max = Double.MIN_VALUE;

        List<Item2d> items = viewResult.getItems();
        if (items.isEmpty()) {
            System.out.println("Список елементів порожній.");
            return;
        }

        for (Item2d item : items) {
            double value = item.getResult();
            min = Math.min(min, value);
            max = Math.max(max, value);
        }

        System.out.println("Мінімальне значення = " + min);
        System.out.println("Максимальне значення = " + max);
    }
}
