package com.saurabh;

import java.io.File;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        // prompt users for all possible operation.
        System.out.println("Please enter option(1-4) to proceed and 0 to exit");
        System.out.println("1> Create new file.");
        System.out.println("2> Search in file");
        System.out.println("3> Sort a file");
        System.out.println("4> Display a file");

        Scanner in = new Scanner(System.in);

        // read option from command line
        int option = in.nextInt();
        in.nextLine();
        String fileName;
        FileOperations fileOperations = new FileOperations();
        File file;
        // prompt user for name of the file.
        System.out.println("Enter a file name");
        fileName = in.nextLine();
        switch (option) {
            case 1:
                // Create File
                // create and open file.
                file = fileOperations.create(fileName);
                // repeat until exit.
                System.out.println("Enter a number (Press 0 to exit)");
                // prompt user for to enter a number.
                // append number to the file.
                fileOperations.append(file, in);

                break;
            case 2:
                // Search File
                // opens the file if exit else try again
                file = fileOperations.create(fileName);
                // prompt user for the search value
                System.out.println("Enter number to be searched");
                // read the file
                // search file for the value specified by the user
                // finally display the searching result on monitor screen.
                fileOperations.search(file, in.nextDouble());
                break;
            case 3:
                // Sort
                // opens the file if exit else try again
                file = fileOperations.create(fileName);
                // ask user if ascending or descending
                System.out.println("Please enter option(1-2) to sort file");
                System.out.println("1> Ascending");
                System.out.println("2> Descending");
                option = in.nextInt();
                // reads the file
                // sort the file.
                fileOperations.sort(file, option == 1);
                fileOperations.display(file);
                break;
            case 4:
                // Display a file
                // opens the file if exit else try again
                file = fileOperations.create(fileName);
                // reads the file
                // prints out its contents to the monitor
                fileOperations.display(file);
                break;
        }
    }
}
