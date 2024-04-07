package ex06;

import ex02.Item2d;
import ex03.View_Result;
import ex05.Command;

import java.util.List;

public class MaxCommand implements Command {

    private View_Result viewResult;

    public MaxCommand(View_Result viewResult) {
        this.viewResult = viewResult;
    }

    @Override
    public void execute() {
        System.out.println("Визначення максимального...");
        double max = Double.MIN_VALUE;

        List<Item2d> items = viewResult.getItems();
        if (items.isEmpty()) {
            System.out.println("Список елементів порожній.");
            return;
        }

        for (Item2d item : items) {
            max = Math.max(max, item.getResult());
        }

        System.out.println("Максимальне значення = " + max);
    }
}
