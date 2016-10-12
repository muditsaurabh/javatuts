package com.saurabh;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * Created by muditsaurabh on 11/10/16.
 */
public class FileOperations {

    public File create(String name) {
        File file = null;
        try {
            file = new File(name);
            if (file.exists()) {
                System.out.println("File already exists.");
            } else {
                file.createNewFile();
                System.out.println("File is created!");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return file;
    }

    public void append(File file, Scanner in) {
        try {
            FileWriter fileWriter = new FileWriter(file);
            PrintWriter out = new PrintWriter(fileWriter);
            while (in.hasNextDouble()) {
                double d = in.nextDouble();
                if(d == 0) break;
                out.println(d);
            }

            out.flush();
            out.close();

            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void search(File file, double toBeSearched) {
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(file));
            Scanner scanner = new Scanner(reader);
            double numberFromFile;
            while (scanner.hasNextDouble()) {
                numberFromFile = scanner.nextDouble();
                if (numberFromFile == toBeSearched) {
                    // a match!
                    System.out.println("I found " + toBeSearched + " in file " + file.getName());
                    break;
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void sort(File file, Boolean isAscending) {
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(file));
            Scanner scanner = new Scanner(reader);
            ArrayList<Double> fileContent = new ArrayList<Double>();
            while (scanner.hasNextDouble()) {
                fileContent.add(scanner.nextDouble());
            }

            reader.close();

            Collections.sort(fileContent);
            if (!isAscending) {
                Collections.reverse(fileContent);
            }

            FileWriter fileWriter = new FileWriter(file);
            PrintWriter out = new PrintWriter(fileWriter);
            for (Double outputLine : fileContent) {
                out.println(outputLine);
            }

            out.flush();
            out.close();
            fileWriter.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void display(File file) {
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(file));
            Scanner scanner = new Scanner(reader);
            while (scanner.hasNextLine()) {
                System.out.println(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
