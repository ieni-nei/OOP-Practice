package test.ex06;

import ex03.View;
import ex04.Viewable_Table;
import ex06.ExecuteConsoleCommand;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/**
 * Клас для тестування виконання команд з консолі.
 */
public class MainTest {
    /**
     * Точка входу в програму для тестування.
     *
     * @param args аргументи командного рядка (не використовуються).
     * @throws Exception якщо виникає помилка під час виконання тесту.
     */
    public static void main(String[] args) throws Exception {
        MainTest test = new MainTest();
        test.setUpStreams();
        test.testExecute();
        test.restoreStreams();
    }
    
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    /**
     * Налаштування перехоплення виведення в консоль.
     */
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    /**
     * Відновлення оригінального виведення в консоль.
     */
    public void restoreStreams() {
        System.setOut(originalOut);
        System.out.println(outContent.toString()); // Вивід перехопленого виведення
    }

    /**
     * Тестування виконання команд.
     *
     * @throws Exception якщо виникає помилка під час виконання тесту.
     */
    public void testExecute() throws Exception {
        View view = new Viewable_Table().getView();

        view.init();

        ExecuteConsoleCommand executeConsoleCommand = new ExecuteConsoleCommand(view);

        executeConsoleCommand.execute();

        String output = outContent.toString().trim();

        // Перевірка виведених результатів наявності необхідних рядків
        assert (output.contains("Середнє арифметичне аргументів = "));
        assert (output.contains("Найменший аргумент = "));
        assert (output.contains("Найбільший аргумент = "));
    }
}
