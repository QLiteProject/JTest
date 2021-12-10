package com.QLiteProject;

import java.util.Arrays;

public class TaskTwo implements Events{
    public TaskTwo() {
        // run();
    }

    @Override
    public void run() {
        Util.printCMDLine("Инициализация процесса. Задание №2.", true);
        Util.printCMDLine("Введите число: ");

        String input = Util.readCMDLine();
        int[] collection = Util.parseInt(input);

        if (collection.length > 0) {
            Util.printCMDLine("Результат: " + (Arrays.stream(Util.splitInt(collection[0])).sum()), true);
            Util.exitCMD();
        } else {
            Util.warningActionCMD(this);
        }
    }
}
