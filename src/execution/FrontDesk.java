package execution;

import definitions.Library;
import definitions.Student;

import java.util.Scanner;

public class FrontDesk {

    private static final int ISSUE_BOOK = 1;
    private static final int RETURN_BOOK = 2;
    private static final int SHOW_ALL_ISSUES_BOOK = 3;
    private static final int ALL_BOOKS_IN_LIBRARY = 4;
    private static final int EXIT = 5;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Library library = new Library();
        int clientInput;
        Student student = new Student();
        System.out.println("What's your good name?");
        String nameOfStudent = scanner.nextLine();
        System.out.println("University Roll number is Required:");
        Long universityRollNo = scanner.nextLong();
        scanner.nextLine();
        do {
            System.out.println("-=-=--=-=-" + "Welcome To The Front Desk" + "-=-=--=-=");
            System.out.println("1. Issue a new book for me.");
            System.out.println("2. Return a previously issues book for me.");
            System.out.println("3. Show me all my issues books.");
            System.out.println("4. All books available in Library.");
            System.out.println("5. Exit .");
            System.out.print("Enter Your Choice (1 to 5): ");
            clientInput = scanner.nextInt();
            switch (clientInput) {
                case ISSUE_BOOK:
                    student.issueBook();
                    break;
                case RETURN_BOOK:
                    student.returnBook();
                    break;
                case SHOW_ALL_ISSUES_BOOK:
                    student.myBooks();
                    break;
                case ALL_BOOKS_IN_LIBRARY:
                    library.allBooksInLibrary();
                    break;
                case EXIT:
                    System.out.println("Thank you.Hope you like our services!!");
                    break;
                default:
                    System.out.println("Please enter right option");
            }
        } while (clientInput != EXIT);
    }
}