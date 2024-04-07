package ex03;

/**
 * Інтерфейс для результатів обчислень, які будуть відображені.
 */
public class Viewable_Result implements Viewable {
    /**
     * Метод для повернення об'єкта, який буде відображений.
     *
     * @return Об'єкт, який буде відображений.
     */
    @Override
    public View getView() {
        return new View_Result(); // Повертаємо екземпляр класу View_Result
    }
}
