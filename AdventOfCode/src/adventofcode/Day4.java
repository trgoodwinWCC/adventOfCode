package adventofcode;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Day4 {
    
    public static void main(String[] args) {
        Day4 tryCode = new Day4();
        tryCode.part1();
        tryCode.part2();
    }

    private int part1() {
        List<String> passphrase = new ArrayList<>();
        Scanner textFile = null;
        String tempLine;
        String tempWord;
        boolean valid = true;
        int numberOfIncorrect = 0;
        int numberOfCorrect = 0;
        try {
            textFile = new Scanner(new File("input.txt"));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Day4.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex.toString());
        }
        while (textFile.hasNextLine()) {
            tempLine = textFile.nextLine().trim();
            Scanner lineScan = new Scanner(tempLine);
            while (lineScan.hasNext()) {
                tempWord = lineScan.next().trim();
                if (passphrase.contains(tempWord)) {
                    numberOfIncorrect++;
                    valid = false;
                    break;
                } else {
                    passphrase.add(tempWord);
                }
            }
            if (valid) {
                numberOfCorrect++;
            }
            passphrase.removeAll(passphrase);
            valid = true;
            lineScan.close();
        }
        System.out.println("Number incorrect:" + numberOfIncorrect);
        System.out.println("Number correct:" + numberOfCorrect);
        return numberOfCorrect;
    }
    
    private int part2() {        
        List<char[]> passphraseNoAna = new ArrayList<>();
        Scanner textFile = null;
        String tempLine;
        String tempWord;
        boolean valid = true;
        int numberOfIncorrect = 0;
        int numberOfCorrect = 0;
        char[] charOfTempWord;
        try {
            textFile = new Scanner(new File("input.txt"));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Day4.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex.toString());
        }
        while (textFile.hasNextLine()) {
            tempLine = textFile.nextLine().trim();
            Scanner lineScan = new Scanner(tempLine);
            while (lineScan.hasNext()) {
                tempWord = lineScan.next().trim();
                charOfTempWord=tempWord.toCharArray();
                Arrays.sort(charOfTempWord);
                for (char[] testArr : passphraseNoAna) {
                    if (Arrays.equals(testArr, charOfTempWord)) {
                        numberOfIncorrect++;
                        valid=false;
                    }
                }
                passphraseNoAna.add(charOfTempWord);
            }
            if (valid) {
                numberOfCorrect++;
            }
            passphraseNoAna.removeAll(passphraseNoAna);
            valid = true;
            lineScan.close();
        }
        System.out.println("Number incorrect:" + numberOfIncorrect);
        System.out.println("Number correct:" + numberOfCorrect);
        return numberOfCorrect;
    }
    public boolean checkForAna(char[] a,char[] b) {
        Arrays.sort(a);
        Arrays.sort(b);
        return Arrays.equals(a, b);
    }
}