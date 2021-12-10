package com.QLiteProject;

import java.util.Arrays;

public class TaskOne implements Events{
    private final int maxValues = 3;

    public TaskOne() {
        // run();
    }

    @Override
    public void run() {
        Util.printCMDLine("Инициализация процесса. Задание №1.", true);
        Util.printCMDLine("Введите массив чисел, строго разделяя: ");

        String input = Util.readCMDLine();
        int[] collection = Util.parseInt(input);

        if (collection.length > maxValues) {
            collection = Arrays.stream(collection).sorted().toArray();
            int[] output = Arrays.copyOfRange(collection, collection.length - maxValues, collection.length);
            Util.printCMDLine("Результат: " + Arrays.toString(output), true);
            Util.exitCMD();
        } else {
            Util.warningActionCMD(this);
        }
    }
}
