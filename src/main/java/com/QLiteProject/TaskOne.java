package com.QLiteProject;

import java.util.Arrays;

public class TaskOne {
    private final int maxValues = 3;

    public TaskOne() {
        run();
    }

    public void run() {
        Util.printCMDLine("Инициализация процесса. Задание №1.", true);
        Util.printCMDLine("Введите массив чисел, строго разделяя: ");

        String inputString = Util.readCMDLine();
        int[] inputIntegers = Util.parseInt(inputString);

        if (inputIntegers.length > maxValues) {
            inputIntegers = Arrays.stream(inputIntegers).sorted().toArray();
            int[] outputIntegers = Arrays.copyOfRange(inputIntegers, inputIntegers.length - maxValues, inputIntegers.length);
            Util.printCMDLine(Arrays.toString(outputIntegers), true);
            Util.exitCMD();
        } else {
            Util.printCMDLine("Некорректный ввод пользователя.", true);
            run();
        }
    }
}
