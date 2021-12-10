package com.QLiteProject;

public class TaskMain implements Events{
    private final TaskOne one;
    private final TaskTwo two;

    public TaskMain() {
        this(new TaskOne(), new TaskTwo());
    }

    public TaskMain(TaskOne one, TaskTwo two) {
        this.one = one;
        this.two = two;
    }

    @Override
    public void run() {
        Util.printCMDLine("Введите номер задания (1-3): ");

        String input = Util.readCMDLine();
        int[] collection = Util.parseInt(input);

        if (collection.length > 0) {
            switch (collection[0]) {
                case 1: one.run(); break;
                case 2: two.run(); break;
                case 3: break;
                default:  Util.warningActionCMD(this); break;
            }
        } else {
            Util.warningActionCMD(this);
        }
    }
}
