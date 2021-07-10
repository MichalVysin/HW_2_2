package com.company;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws IOException {

        try (
                BufferedReader bufferedReader =
                     new BufferedReader(
                             new FileReader("homeworkInputFile.txt"));

                BufferedWriter bufferedWriter =
                        new BufferedWriter(
                                new FileWriter("homeworkOutputFile.txt"));

        ) {
            String readLine;
            while ((readLine = bufferedReader.readLine()) != null) {

                String[] line = readLine.split("(?=\\d{2} | \\d)");

                String output = Arrays.stream(line)
                        .filter(str -> !str.isBlank())
                        .sorted()
                        .map(str -> str.replaceAll("\\d", ""))
                        .map(str -> str.replace("  ", " "))
                        .collect(Collectors.joining())
                        .replaceFirst(" ", "");

                bufferedWriter.write(output);

            }
        }
    }
}
