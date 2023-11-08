// Lenot,Tommy CS2050, Assignment: Program #6 Sorting Arrays
// Things to NOTE: StringsinFile.txt was not named as such and was named StringsinFile, meaning I had to change it, but that's not much of a problem, but it was not found in canvas it was found under CODE, but where the powerpoints were and needed to downloaded from there.
// It was also noted that results.txt, StringsInFile.txt, and NumbersInFile.txt, like the rest of the programs I have sent, they all have to be not in the src folder, but where ever The Project name file's .iml and .gitignore is at.

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class Program6 {

    public static void main(String[] args) throws IOException {

        // PART 1: Sorting Arrays of Integers
        int[] intBubbleArray = new int[20000];
        int[] intSelectionArray = new int[20000];
        ArrayList<Integer> intList = new ArrayList<>();

        BufferedReader reader = new BufferedReader(new FileReader("NumbersInFile.txt"));
        String line;
        int index = 0;
        while ((line = reader.readLine()) != null && index < 20000) {
            int num = Integer.parseInt(line.trim());
            intBubbleArray[index] = num;
            intSelectionArray[index] = num;
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
        Collections.sort(intList);
        long systemTimeInt = System.nanoTime() - startTime;


        // PART 2: System Sort for Strings
        String[] strBubbleArray = new String[10000];
        String[] strSelectionArray = new String[10000];
        ArrayList<String> strList = new ArrayList<>();

        reader = new BufferedReader(new FileReader("StringsInFile.txt"));
        index = 0;
        while ((line = reader.readLine()) != null && index < 10000) {
            strBubbleArray[index] = line;
            strSelectionArray[index] = line;
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
        Collections.sort(strList);
        long systemTimeStr = System.nanoTime() - startTime;

        PrintWriter writer = new PrintWriter(new FileWriter("results.txt"));
        writer.println("Type of Data: Integers");
        writer.println("Number of Integers: " + intBubbleArray.length);
        writer.println("Bubble Sort Time for Integers: " + bubbleTimeInt + " nanoseconds");
        writer.println("Selection Sort Time for Integers: " + selectionTimeInt + " nanoseconds");
        writer.println("System Sort Time for Integers: " + systemTimeInt + " nanoseconds");
        writer.println("------------------------------------------------------------");
        writer.println("Type of Data: Strings");
        writer.println("Number of Strings: " + strBubbleArray.length);
        writer.println("Bubble Sort Time for Strings: " + bubbleTimeStr + " nanoseconds");
        writer.println("Selection Sort Time for Strings: " + selectionTimeStr + " nanoseconds");
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
}
