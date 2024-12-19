package project1;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

public class Project01 {

    public static void main(String[] args) {

        ArrayList<Integer> numbers = new ArrayList<Integer>();

        try (BufferedInputStream in = new BufferedInputStream(new FileInputStream("C:/Users/babio/useFolder/input.txt"))) {



        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error 12345");
        }

    }
}