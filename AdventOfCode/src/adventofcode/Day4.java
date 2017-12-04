package adventofcode;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Day4 {
    
    public static void main(String[] args) {
        List<String> passphrase = new ArrayList<>();
        Scanner textFile=null;
        String tempLine;
        String tempWord;
        int numberOfIncorrect=0;
        int numberOfCorrect=0;
        try {
            textFile = new Scanner(new File("input.txt"));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Day4.class.getName()).log(Level.SEVERE, null, ex);
        }
        while(textFile.hasNextLine()) {
            tempLine=textFile.nextLine().trim();
            Scanner lineScan = new Scanner(tempLine);
            while(lineScan.hasNext()) {
                tempWord = lineScan.next();
                if (passphrase.contains(tempWord)) {
                    numberOfIncorrect++;
                    //break;
                }
                else {
                    passphrase.add(tempLine);
                }
            }
            numberOfCorrect++;
            passphrase.removeAll(passphrase);
            lineScan.close();
        }
        System.out.println("Number incorrect:"+numberOfIncorrect);
    }
}
