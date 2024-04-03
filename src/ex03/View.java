package src.ex03;

import java.io.IOException;

/**
 * Інтерфейс для відображення результатів обчислень.
 */
interface View {
    /**
     * Показує весь об'єкт.
     */
    public void show();

    /**
     * Показує заголовок.
     */
    public void header();

    /**
     * Показує основну частину.
     */
    public void body();

    /**
     * Показує колонтитул.
     */
    public void footer();

    /**
     * Виконує ініціалізацію.
     *
     * 
     */
    public void init();

    public void initDefault();

    /**
     * Зберігає дані в файл за вказаним шляхом.
     *
     * @param path Шлях до файлу.
     * @throws IOException Виникає, якщо виникає помилка при збереженні даних в файл.
     */
    public void save(String path) throws IOException;

    /**
     * Відновлює раніше збережені дані з вказаного шляху.
     *
     * @param path Шлях до файлу збереження.
     * @throws Exception Виникає, якщо виникає помилка при відновленні даних з файлу.
     */
    public void restore(String path) throws Exception;
}
