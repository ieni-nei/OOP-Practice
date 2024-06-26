package ex04;

import java.util.List;

import ex02.Calculate;
import ex02.Item2d;
import ex03.View_Result;

/**
 * Клас для відображення результатів у вигляді таблиці.
 * 
 * @author @ieni-nei
 */
public class View_Table extends View_Result {

    /**
     * Конструктор за замовчуванням.
     */
    public View_Table() {
        super();
    }

    /**
     * Показує таблицю з результатами.
     */
    @Override
    public void show() {
        header();
        separator();
        body();
        separator();
    }

    /**
     * Виводить заголовок таблиці.
     */
    @Override
    public void header() {
        System.out.printf("%-30s | %-20s | %-30s | %-50s\n", "Аргументи", "Середнє арифметичне", "Результат у двійковому форматі", "Кількість одиниць у двійковому поданні цілої частини");
    }

    /**
     * Виводить роздільник таблиці.
     */
    public void separator() {
        System.out.println("-".repeat(30) + " | " + "-".repeat(20) + " | " + "-".repeat(30) + " | " + "-".repeat(50));
    }

    /**
     * Виводить тіло таблиці з даними.
     */
    @Override
    public void body() {
        List<Item2d> items = getItems();
        for (Item2d item : items) {
            System.out.printf("%-30s | %-20.2f | %-30s | %-50d\n", item.getArguments(), item.getResult(), Calculate.toBinaryString(item.getResult()), Calculate.countOnes(item.getResult()));
        }
    }
}
