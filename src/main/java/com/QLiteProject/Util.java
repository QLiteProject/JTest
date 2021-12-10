package com.QLiteProject;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Util {
    //region Util
    public static int[] parseInt(String string) {
        List <String> result = new ArrayList<>();
        Pattern pattern = Pattern.compile("(-?\\d+)");
        Matcher matcher = pattern.matcher(string);
        while (matcher.find()) {
            result.add(matcher.group());
        }
        return result.stream().mapToInt(Integer::parseInt).toArray();
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
    //endregion

    //region In & Out methods
    private static final Scanner scannerCMDLine = new Scanner(System.in);

    public static String readCMDLine() {
        return scannerCMDLine.nextLine();
    }

    public static void exitCMD() {
        printCMDLine("Нажмите любую клавишу для выхода из приложения...", true);
        readCMDLine();
    }

    public static void printCMDLine(String text) {
        printCMDLine(text, false);
    }

    public static void printCMDLine(String text, boolean enter) {
        if (enter) System.out.println(text); else System.out.print(text);
    }
    //endregion
}
