package se.edu.inclass;

import se.edu.inclass.data.DataManager;
import se.edu.inclass.task.Deadline;
import se.edu.inclass.task.Task;
import se.edu.inclass.task.TaskNameComparator;

import java.util.ArrayList;

public class Main {

    private TaskNameComparator taskNameComparator;

    public static void main(String[] args) {
        DataManager dm = new DataManager("./data/data.txt");
        ArrayList<Task> tasksData = dm.loadData();
        printData(tasksData);
        System.out.println("Printing deadlines");
        printDeadlines(tasksData);
        System.out.println("Total number of deadlines: " + countDeadlines(tasksData));

        printDeadlineUsingStreams(tasksData);
        System.out.println("Total Deadline: " + countDeadlinesUsingStreams(tasksData));

    }

    private static int countDeadlines(ArrayList<Task> tasksData) {
        int count = 0;
        for (Task t : tasksData) {
            if (t instanceof Deadline) {
                count++;
            }
        }
        return count;
    }

    public static int countDeadlinesUsingStreams(ArrayList<Task> tasksData) {
        System.out.println("Calculating count using streams");
        return (int) tasksData.stream()
                .filter((t) -> t instanceof Deadline)
                .count();
    }

    public static void printData(ArrayList<Task> tasksData) {
        for (Task t : tasksData) {
            System.out.println(t);
        }
    }

    public static void printDataUsingStreams(ArrayList<Task> tasksData) {
        System.out.println("Printing data using streams");
        tasksData.stream()
                .forEach(System.out::println);

    }

    public static void printDeadlines(ArrayList<Task> tasksData) {
        for (Task t : tasksData) {
            if (t instanceof Deadline) {
                System.out.println(t);
            }
        }
    }

    public static void printDeadlineUsingStreams(ArrayList<Task> tasksData) {
        System.out.println("Printing deadlines using streams");
        tasksData.stream()
                .filter((t) -> t instanceof Deadline) //Extract all tasks that are deadline with predicates
                .forEach(System.out::println);
    }

}
