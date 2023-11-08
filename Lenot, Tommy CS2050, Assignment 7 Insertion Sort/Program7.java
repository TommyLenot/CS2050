// Lenot,Tommy CS2050, Assignment: Program #7 Insertion Sort
// also noted that results.txt, StringsInFile.txt, and NumbersInFile.txt, like the rest of the programs I have sent, they all have to be not in the src folder, but where ever The Project name file's .iml and .gitignore is at.

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class Program7 {

    public static void main(String[] args) throws IOException {

        // PART 1: Sorting Arrays of Integers
        int[] intBubbleArray = new int[20000];
        int[] intSelectionArray = new int[20000];
        int[] intInsertionArray = new int[20000];
        ArrayList<Integer> intList = new ArrayList<>();

        BufferedReader reader = new BufferedReader(new FileReader("NumbersInFile.txt"));
        String line;
        int index = 0;
        while ((line = reader.readLine()) != null && index < 20000) {
            int num = Integer.parseInt(line.trim());
            intBubbleArray[index] = num;
            intSelectionArray[index] = num;
            intInsertionArray[index] = num;
            intList.add(num);
            index++;
        }
        reader.close();

        long startTime = System.nanoTime();
        bubbleSort(intBubbleArray);
        long bubbleTimeInt = System.nanoTime() - startTime;

        startTime = System.nanoTime();
        selectionSort(intSelectionArray);
        long selectionTimeInt = System.nanoTime() - startTime;

        startTime = System.nanoTime();
        insertionSort(intInsertionArray);
        long insertionTimeInt = System.nanoTime() - startTime;

        startTime = System.nanoTime();
        Collections.sort(intList);
        long systemTimeInt = System.nanoTime() - startTime;

        // PART 2: System Sort for Strings
        String[] strBubbleArray = new String[10000];
        String[] strSelectionArray = new String[10000];
        String[] strInsertionArray = new String[10000];
        ArrayList<String> strList = new ArrayList<>();

        reader = new BufferedReader(new FileReader("StringsInFile.txt"));
        index = 0;
        while ((line = reader.readLine()) != null && index < 10000) {
            strBubbleArray[index] = line;
            strSelectionArray[index] = line;
            strInsertionArray[index] = line;
            strList.add(line);
            index++;
        }
        reader.close();

        startTime = System.nanoTime();
        bubbleSort(strBubbleArray);
        long bubbleTimeStr = System.nanoTime() - startTime;

        startTime = System.nanoTime();
        selectionSort(strSelectionArray);
        long selectionTimeStr = System.nanoTime() - startTime;

        startTime = System.nanoTime();
        insertionSort(strInsertionArray);
        long insertionTimeStr = System.nanoTime() - startTime;

        startTime = System.nanoTime();
        Collections.sort(strList);
        long systemTimeStr = System.nanoTime() - startTime;

        PrintWriter writer = new PrintWriter(new FileWriter("results.txt"));
        writer.println("Type of Data: Integers");
        writer.println("Number of Integers: " + intBubbleArray.length);
        writer.println("Bubble Sort Time for Integers: " + bubbleTimeInt + " nanoseconds");
        writer.println("Selection Sort Time for Integers: " + selectionTimeInt + " nanoseconds");
        writer.println("Insertion Sort Time for Integers: " + insertionTimeInt + " nanoseconds");
        writer.println("System Sort Time for Integers: " + systemTimeInt + " nanoseconds");
        writer.println("------------------------------------------------------------");
        writer.println("Type of Data: Strings");
        writer.println("Number of Strings: " + strBubbleArray.length);
        writer.println("Bubble Sort Time for Strings: " + bubbleTimeStr + " nanoseconds");
        writer.println("Selection Sort Time for Strings: " + selectionTimeStr + " nanoseconds");
        writer.println("Insertion Sort Time for Strings: " + insertionTimeStr + " nanoseconds");
        writer.println("System Sort Time for Strings: " + systemTimeStr + " nanoseconds");
        writer.close();
    }

    public static void bubbleSort(int[] arr) {
    }

    public static void bubbleSort(String[] arr) {
    }

    public static void selectionSort(int[] arr) {
    }

    public static void selectionSort(String[] arr) {
    }

    public static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j = i - 1;

            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
    }

    public static void insertionSort(String[] arr) {
        for (int i = 1; i < arr.length; i++) {
            String key = arr[i];
            int j = i - 1;

            while (j >= 0 && arr[j].compareTo(key) > 0) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
    }
}
