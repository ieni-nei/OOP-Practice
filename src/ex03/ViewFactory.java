package src.ex03;

import src.ex02.Item2d;

/**
 * Фабрика для створення об'єктів для віфдображення результатів обчислень.
 */
public class ViewFactory {
    /**
     * Метод для створення відповідного перегляду залежно від типу.
     * @param viewType Тип перегляду.
     * @param item Об'єкт, результати якого будуть відображені.
     * @return Об'єкт перегляду.
     */
    public static Viewable createView(String viewType, Item2d item) {
        switch (viewType.toUpperCase()) {
            case "RESULT":
                return new View_Result(item);
            default:
                return null;
        }
    }
}
