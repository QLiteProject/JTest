package com.QLiteProject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Util {
    //region Util
    public static int[] parseInt(String string) {
        List <Integer> result = new ArrayList<>();
        Pattern pattern = Pattern.compile("(-?\\d+)");
        Matcher matcher = pattern.matcher(string);
        while (matcher.find()) {
            result.add(Integer.parseInt(matcher.group()));
        }
        return result.stream().mapToInt(i -> i).toArray();
    }

    public static int[] splitInt(int variable) {
        List<Integer> result = new ArrayList<>();
        while (true) {
            result.add(variable % 10);
            variable /= 10;
            if (variable == 0) {
                return result.stream().mapToInt(i -> i).toArray();
            }
        }
    }

    public static List<Integer> intAsListInteger (int[] array) {
        return new ArrayList<>(Arrays.asList(Arrays.stream(array).boxed().toArray(Integer[]::new)));
    }
    //endregion

    //region In & Out methods
    private static final Scanner scannerCMDLine = new Scanner(System.in, "UTF-8");

    public static String readCMDLine() {
        return scannerCMDLine.nextLine();
    }

    public static void exitCMD() {
        printCMDLine("Нажмите любую клавишу для выхода из приложения...", true);
        readCMDLine();
    }

    public static void warningActionCMD(Events events) {
        printCMDLine("Некорректный ввод пользователя.", true);
        if (events != null) events.run();
    }

    public static void printCMDLine(String text) {
        printCMDLine(text, false);
    }

    public static void printCMDLine(String text, boolean enter) {
        if (enter) System.out.println(text); else System.out.print(text);
    }
    //endregion
}
