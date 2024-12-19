package project1;

import java.io.*;
import java.util.*;
import java.lang.*;

public class Project01 {

    public static void main(String[] args) {

        String line;
        ArrayList<Integer> numbers = new ArrayList<Integer>();
        String inFile = "C:/Users/babio/useFolder/numbers.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(inFile))) {
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                for (String part : parts) {
                    int number = Integer.parseInt(part.trim());
                    numbers.add(number);
                }
            }
            System.out.println(numbers);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error 12345");
        }
        System.out.println("New entry for git check");
    }
}