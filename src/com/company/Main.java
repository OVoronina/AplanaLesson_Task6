package com.company;
import java.io.File;
import java.io.IOException;
import java.util.*;

public class Main {

    public static void main(String[] args) {

        List<String> word = new ArrayList<>();  //список
        List<String> wordWithoutDuplicates = new ArrayList<>(); // список без повторений
        int maxRepeats = 0;
        String maxRepeatsElement = null;

        // считываем файл ***********************************************************************
        try {
            Scanner s = new Scanner(new File("C:\\Users\\Volya\\Desktop", "test.txt"));
            while (s.hasNext()) {
                word.add(s.next());
            }

        } catch (IOException e) {
            System.out.println("Error accessing input file!");
        }
        // сортируем список**********************************************************
        word.sort(String::compareTo);
        // колдуем*******************************************************************
        for(int i = 0; i < word.size(); i++) {
            if (wordWithoutDuplicates.contains(word.get(i))) continue;
            int repeats = 0;
            for (int n = i + 1; n < word.size(); n++) {
                if (word.get(i).equals(word.get(n))) repeats++; //
            }
            wordWithoutDuplicates.add(word.get(i));
            wordWithoutDuplicates.add(String.valueOf(repeats));
            if (repeats > maxRepeats) {
                maxRepeats = repeats;
                maxRepeatsElement = wordWithoutDuplicates.get(i);
            }
        }
        for(String element : word) System.out.print(element + " ");
        System.out.println();
        for(int i = 0; i < wordWithoutDuplicates.size(); i += 2) {
            if (i >= wordWithoutDuplicates.size()) break;
            System.out.println("Слово: \"" + wordWithoutDuplicates.get(i) + "\" повторяется " + wordWithoutDuplicates.get(i+1) + " раз(а)");
        }
        System.out.println();
        System.out.println("Максимально повторяющееся слово \"" +  maxRepeatsElement + "\"повторяется " + maxRepeats + " раз(а)");

    }

}


