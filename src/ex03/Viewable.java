package src.ex03;

/**
 * Інтерфейс для об'єктів, які можуть бути відображені.
 */
public interface Viewable {
    /**
     * Повертає об'єкт, що здійснює відображення.
     *
     * @return Об'єкт, що реалізує інтерфейс View.
     */
    public View getView();
}
