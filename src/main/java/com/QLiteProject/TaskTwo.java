package com.QLiteProject;

import java.util.Arrays;

public class TaskTwo {
    public TaskTwo() {
        run();
    }

    public void run() {
        Util.printCMDLine("Инициализация процесса. Задание №2.", true);
        Util.printCMDLine("Введите число: ");

        String input = Util.readCMDLine();
        int[] collection = Util.parseInt(input);

        if (collection.length > 0) {
            Util.printCMDLine("Результат: " + (Arrays.stream(Util.splitInt(collection[0])).sum()));
        }
    }
}
