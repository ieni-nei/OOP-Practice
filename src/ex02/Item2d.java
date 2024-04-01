package src.ex02;

import java.io.Serializable;

/**
 * Клас, що представляє параметри та результати обчислень.
 */
public class Item2d implements Serializable {
    private static final long serialVersionUID = 1L;
    private double[] arguments;
    private double result;
    private transient int transientField;

    /**
     * Конструктор для створення екземпляра класу з параметрами.
     * @param arguments Аргументи функції.
     * @param result Результат обчислення.
     */
    public Item2d(double[] arguments, double result) {
        this.arguments = arguments;
        this.result = result;
        this.transientField = 10; // Assign a value to the transient field
    }

    /**
     * Повертає аргументи функції.
     * @return Масив аргументів функції.
     */
    public double[] getArguments() {
        return arguments;
    }

    /**
     * Повертає результат обчислення.
     * @return Результат обчислення.
     */
    public double getResult() {
        return result;
    }

    /**
     * Повертає значення перехідного поля.
     * @return Значення перехідного поля.
     */
    public int getTransientField() {
        return transientField;
    }
}
