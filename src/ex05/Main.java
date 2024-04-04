package src.ex05;

import src.ex02.Item2d;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**Обчислення та відображення результатів
 * Містить реалізацію статичного методу main()
 *
 * @author Головненко Леонід aka @ieni-nei
 */
public class Main {
    
    public static void main(String[] args){
        Application app = Application.getInstance();
        app.run();

        // Ініціалізуємо список елементів
        List<Item2d> items = new ArrayList<>();

        // Ініціалізуємо Scanner для введення користувача
        Scanner scanner = Application.getInstance().getScanner();

        // Створюємо команду для зміни елемента
        Command changeItemCommand = new ChangeItemCommand(scanner, items);

        // Виконуємо команду зміни елемента
        changeItemCommand.execute();
    }
}
