package performanceTasks;

// Ethan So
// 4/25/2024

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

//a class that builds the library and runs the application
public class LibraryApplication {

    //shared array for the class
    private static Book[] bookArray = new Book[5]; //5 books

    //shared Scanner variable for the class
    private static Scanner input = new Scanner(System.in);

    //Fill the library (method call)
    //Shows the menu and then calls the appropriate method until the user chooses to exit
    public static void main(String[] args) {

        //fill library with "books"
        fillLibrary();

        int choice; //holds user's choice "sentinel"

        do {
            //display the menu and get the users choice
            choice = showMenu();

            //call appropriate method depending on the user's choice
            if (choice == 1)
                showLibrary();
            else if (choice == 2)
                showBook();
            else if (choice == 3)
                showLibraryByTitle();
            else if (choice == 4)
                showLibraryByCost();

            //repeat until user chooses to exit
        } while (choice != 5);

    }

    //Fills the library with 5 books
    private static void fillLibrary() {

        //create 5 new objects/instances and put it in the Array
        bookArray[0] = new Book("Java How to Program",
                "Paul J. Deitel",
                1560,
                2009,
                "9780136053064",
                72.71);
        bookArray[1] = new Book("Harry Potter and the Philosopher's Stone",
                "J.K. Rowling",
                352,
                2014,
                "9781408855652",
                11.20);
        bookArray[2] = new Book("Fellowship of the Ring",
                "J.R.R. Tolkien",
                448,
                1998,
                "9780261102354",
                10.88);
        bookArray[3] = new Book("Algorithms - 4th Edition",
                "Robert Sedgewick",
                976,
                2011,
                "9780321573513",
                111.37);
        bookArray[4] = new Book("The Skin We're In",
                "Desmond Cole",
                256,
                2020,
                "9780385686341",
                24.75);

    }

    //Displays the title
    //Displays a menu with 5 choices (see sample)
    //Returns the user’s choice
    private static int showMenu() {

        //display title and choices
        System.out.println("MY BOOK LIBRARY");
        System.out.println("===============");
        System.out.println("1) Show the library\n" +
                "2) Show book\n" +
                "3) Show library by Title\n" +
                "4) Show library by Cost\n" +
                "5) Exit");

        //Get user's choice
        System.out.print("Enter your choice: ");
        return input.nextInt();

    }

    //Displays the entire book library based on the original order
    private static void showLibrary() {

        //show that the library is being displayed
        System.out.println("*Displaying library");

        //display the all the books in the library
        for (int index = 0; index < bookArray.length; index++) {

            System.out.printf("%d. ", index + 1);
            System.out.print(bookArray[index]);
            System.out.println();

        }

    }

    //Displays the information for a specific book based on a keyword that matches a word in the title
    //(use the contains method from the String class)
    private static void showBook() {

        System.out.println("Enter a keyword in the book title ");
        String keyword = input.next();

        //check each book for the keyword
        for (int index = 0; index < bookArray.length; index++) {

            //check for a book that has the keyword in the title
            if (bookArray[index].getTitle().contains(keyword))
                System.out.print(bookArray[index]); //display the book

        }

        //skip to next line
        System.out.println();

    }

    //Displays the entire book library based on the title
    //uses object array sorting code - Comparator class
    private static void showLibraryByTitle() {

        //sort book array by title
        Arrays.sort(bookArray, Comparator.comparing(Book::getTitle));

        //display new sorted library
        showLibrary();

    }

    //Displays the entire book library based on the cost
    //uses object array sorting code - Comparator class
    private static void showLibraryByCost() {

        //sort book array by cost
        Arrays.sort(bookArray, Comparator.comparing(Book::getCost));

        //display new sorted library
        showLibrary();

    }


}

