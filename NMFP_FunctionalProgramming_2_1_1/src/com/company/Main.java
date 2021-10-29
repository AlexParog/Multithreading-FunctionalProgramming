package com.company;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main  {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Что написали жители острова?");

        String[] alphabet = scanner.nextLine().split(" ");
        List<String> newAlphabet = myFunction(alphabet);
        newAlphabet.forEach(System.out::println);


    }

    public static List<String> myFunction(String[] alphabet) {
        return Arrays.stream(alphabet)
                .sorted()
                .collect(Collectors.toList());
    }

/*    @Override
    public List<String> myAlphabet(String[] alphabet) {
        return Arrays.stream(alphabet)
                .sorted()
                .collect(Collectors.toList());
    }*/
}
