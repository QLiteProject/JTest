package com.QLiteProject;

import java.util.ArrayList;
import java.util.List;

public class TaskThree implements Events{
    int[] collection;
    int countGroup;

    public TaskThree() {
        // run();
    }

    @Override
    public void run() {
        Util.printCMDLine("Инициализация процесса. Задание №3.", true);

        detectedCollection();
        detectedCountGroup();

        List<Integer> originalValues = Util.intAsListInteger(this.collection);
        List<List<Integer>> groupedValues = new ArrayList<>();
        List<Integer> pseudoGroupedValues = new ArrayList<>();
        Integer value = originalValues.stream().max(Integer::compare).orElse(0);

        pseudoGroupedValues.add(value);
        groupedValues.add(pseudoGroupedValues);
        originalValues.remove(value);

        int a = 0, summaPseudoGroupedValues = 0;

        while (true) {
            List<Integer> bufferElements = new ArrayList<>();
            int b = 0;

            if (a  < originalValues.size()) {

            }

            while (true) {
                int c = 0, summaBufferElements = 0;

                if (b < originalValues.size()) {
                    int element = originalValues.get(b);
                    originalValues.remove(element);
                    bufferElements.add(element);
                } else {
                    pseudoGroupedValues.clear();
                    originalValues.addAll(bufferElements);
                    break;
                }

                summaBufferElements = bufferElements.stream().mapToInt(i -> i).sum();

                if (summaBufferElements > summaPseudoGroupedValues) {
                    pseudoGroupedValues.clear();
                    originalValues.addAll(bufferElements);
                    break;
                }

                while (true) {
                    List<Integer> bufferValues = new ArrayList<>();
                    int summaBufferValues = 0;

                    if (c < originalValues.size()) {
                        bufferValues.add(originalValues.get(c));
                        bufferValues.addAll(bufferElements);
                        summaBufferValues = bufferValues.stream().mapToInt(i -> i).sum();

                        if (summaBufferValues == value) {
                            groupedValues.add(bufferValues);
                            b++;
                        } else {
                            c++;
                        }
                    } else {
                        b++;
                        break;
                    }
                }
            }
        }

//        int summa = Arrays.stream(this.collection).sum();
//        if (summa % this.countGroup == 0) {
//            List<List<Integer>> result = new ArrayList<>();
//            List<Integer> list = new ArrayList<>(Arrays.asList(Arrays.stream(this.collection).boxed().toArray(Integer[]::new)));
//            int average = summa / this.countGroup;
//
//            for (int i = 0; i < this.countGroup; i++) {
//                int a = 0, number = 0, element;
//                List<Integer> buffer = new ArrayList<>();
//
//                while (true) {
//                    element = list.get(a < list.size() ? a : (a = 0));
//
//                    if (number < average & number + element < average) {
//                        number += element;
//                        buffer.add(element);
//                        list.remove(a);
//                    } else if (number == average) {
//                        result.add(buffer);
//                        break;
//                    } else {
//                        a++;
//                    }
//                }
//            }
//
//            Util.printCMDLine(Arrays.toString(result.toArray()));
//        } else {
//            Util.warningActionCMD(this);
//        }
    }

    private void detectedCollection() {
        Util.printCMDLine("Введите массив чисел, строго разделяя: ");

        String input = Util.readCMDLine();
        this.collection = Util.parseInt(input);

        if (this.collection.length == 0) Util.warningActionCMD(this);
    }

    private void detectedCountGroup() {
        Util.printCMDLine("Введите количество групп: ");

        String input = Util.readCMDLine();
        int[] collection = Util.parseInt(input);

        if (collection.length > 0 & collection[0] > 0) {
            this.countGroup = collection[0];
        } else {
            Util.warningActionCMD(this);
        }
    }
}
