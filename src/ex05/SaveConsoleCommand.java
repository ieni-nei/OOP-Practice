package ex05;

import ex03.View;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

/**
 * Консольна команда, що виконує серіалізацію.
 */
public class SaveConsoleCommand implements ConsoleCommand {

    private final View view;

    public SaveConsoleCommand(View view) {
        this.view = view;
    }

    @Override
    public char getKey() {
        return 's';
    }

    @Override
    public String toString() {
        return "'s'ave";
    }

    @Override
    public void execute() {
        try {
            view.save("temp/Task-5/item.dat");

            File backupFile = new File("temp/Task-5/item_backup.dat");
            Files.copy(new File("temp/Task-5/item.dat").toPath(), backupFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
            System.out.println("Файл резервної копії створено: " + backupFile.getAbsolutePath());
        } catch (IOException e) {
            System.err.println("Помилка серіалізації: " + e);
        }
    }
}
