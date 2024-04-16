package ex07;

/**
 * Інтерфейс спостерігаємого об'єкта.
 * Реалізацію шаблону Observer.
 */
public interface Observable {
   
	// Додає спостерігача
    void register(Observer observer);

   // Оновлює спостерігачів
   public void notify(String type, String message);
}
