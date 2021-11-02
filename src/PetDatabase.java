/*  CSC 422 - Assignment 1 - 11/2/2021
    Nicholas Handberg - handbern@csp.edu
 */

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class PetDatabase {
    // Adds scanner for user input and ArrayList to store Pet objects
    static Scanner sc = new Scanner(System.in);
    static ArrayList<Pet> petList = new ArrayList<Pet>();

    public static void main(String[] args){
        int choice = 0;

        // Main program loop. Gets users choice and calls the respective method using switch statement
        while(choice != 7){
            System.out.print("\n\nPet Database Program.\n" +
                    "What would you like to do?\n" +
                    "1) View all pets\n" +
                    "2) Add more pets\n" +
                    "3) Update an existing pet\n" +
                    "4) Remove an existing pet\n" +
                    "5) Search pets by name\n" +
                    "6) Search pets by age\n" +
                    "7) Exit program\n" +
                    "Your choice: ");

            while(true){
                try{ choice = sc.nextInt();  break; }
                catch(InputMismatchException e){ System.out.println("Please enter a number: "); }
            }

            switch(choice){
                case 1 -> showAllPets();
                case 2 -> addPets();
            }
        }
    }

    // Method calls the respective print methods passing in the Pet object's name and ages
    public static void showAllPets(){
        printTableHeader();
        for (int i = 0; i < petList.size(); i++) {
            printTableRow(i, petList.get(i).getName(), petList.get(i).getAge());
        }
        printTableFooter(petList.size());
    }

    // Gets the user's input, splits the string by a space, and creates/adds a new Pet instance to the petList
    // Continues looping until the user inputs "done"
    public static void addPets(){
        String input;
        sc.nextLine();
        while (true) {
            System.out.print("add pet (name, age): ");
            input = sc.nextLine();
            if (input.equals("done")) { break; }
            String[] inputSplit = input.split(" ");
            try { Pet temp = new Pet(inputSplit[0], Integer.parseInt(inputSplit[1]));
                petList.add(temp);
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("ERROR: Enter name and age seperated by a space.");
            }
        }
    }

    // PRINT METHODS
    private static void printTableHeader() {
        System.out.print("\n+---------------------+\n| ID | NAME     | AGE |\n+---------------------+");
    }
    private static void printTableRow(int id, String name, int age) {
        System.out.printf("\n| %1$-3s|", id);
        System.out.printf(" %1$-9s", name);
        System.out.printf("| %1$-4s|", age);
    }
    private static void printTableFooter(int rowCount) {
        System.out.print("\n+---------------------+\n" + rowCount + " rows in set.");
    }

}
