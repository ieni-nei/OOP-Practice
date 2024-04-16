package ex03;

import java.io.IOException;
import java.util.List;

import ex02.Item2d;

/**
 * Інтерфейс для відображення результатів обчислень.
 * 
 * @author @ieni-nei
 */
public interface View {
    /**
     * Показує весь об'єкт.
     */
    void show();

    /**
     * Показує заголовок.
     */
    void header();

    /**
     * Показує основну частину.
     */
    void body();

    /**
     * Показує колонтитул.
     */
    void footer();

    /**
     * Виконує ініціалізацію.
     */
    void init();

    /**
     * Виконує ініціалізацію за замовчуванням.
     */
    void initDefault();

    /**
     * Зберігає дані у файл за вказаним шляхом.
     *
     * @param path Шлях до файлу.
     * @throws IOException Виникає, якщо виникає помилка при збереженні даних у файл.
     */
    void save(String path) throws IOException;

    /**
     * Відновлює раніше збережені дані з вказаного шляху.
     *
     * @param path Шлях до файлу збереження.
     * @throws Exception Виникає, якщо виникає помилка при відновленні даних з файлу.
     */
    void restore(String path) throws Exception;


    /**
     * Повертає список об'єктів типу Item2d.
     */
    public List<Item2d> getItems();

    /**
     * Змінює список об'єктів типу Item2d.
     */
    public void setItems(List<Item2d> items);
}
