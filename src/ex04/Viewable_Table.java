package ex04;

import ex03.View;
import ex03.Viewable_Result;

/**
 * Клас, що реалізує інтерфейс Viewable_Result для створення об'єктів типу View_Table.
 */
public class Viewable_Table extends Viewable_Result {
    
    /**
     * Повертає новий об'єкт типу View_Table.
     *
     * @return Об'єкт типу View_Table.
     */
    @Override
    public View getView() {
        return new View_Table();
    }
}
