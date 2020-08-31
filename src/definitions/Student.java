/*  Created by IntelliJ IDEA.
 *  User: DEVENDRA  SRIVASTAVA(DEV-PROG-Spec)
 *  Date: 21/08/20
 *  Time: 3:49 PM
 *  File Name : Student.java
 * */
package definitions;

import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

public class Student {
    Scanner scanner = new Scanner(System.in);
    private String nameOfStudent;
    private long universityRollNo;
    private int noOfBooksIssued = 0;
    private Book[] namesOfBooks;

    public Student() {
        this.namesOfBooks = new Book[2];
    }

    public Student(String nameOfStudent, long universityRollNo) {
        this.nameOfStudent = nameOfStudent;
        this.universityRollNo = universityRollNo;
    }

    public String getNameOfStudent() {
        return nameOfStudent;
    }

    public void setNameOfStudent(String nameOfStudent) {
        this.nameOfStudent = nameOfStudent;
    }

    public long getUniversityRollNo() {
        return universityRollNo;
    }

    public void setUniversityRollNo(long universityRollNo) {
        this.universityRollNo = universityRollNo;
    }

    public void setNoOfBooksIssued() {
        this.noOfBooksIssued += 1;
    }

    public int getNoOfBooksIssued() {
        return noOfBooksIssued;
    }

    public Book[] getNamesOfBooks() {
        return namesOfBooks.clone();
    }

    public void setNamesOfBooks(Book[] namesOfBooks) {
        this.namesOfBooks = namesOfBooks;
    }

    @Override
    public String toString() {
        return "Student{" +
                "nameOfStudent='" + nameOfStudent + '\'' +
                ", universityRollNo=" + universityRollNo +
                ", noOfBooksIssued=" + noOfBooksIssued +
                ", namesOfBooks=" + Arrays.toString(namesOfBooks) +
                '}';

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return getUniversityRollNo() == student.getUniversityRollNo() &&
                getNoOfBooksIssued() == student.getNoOfBooksIssued() &&
                Objects.equals(getNameOfStudent(), student.getNameOfStudent()) &&
                Arrays.equals(getNamesOfBooks(), student.getNamesOfBooks());
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(getNameOfStudent(), getUniversityRollNo(), getNoOfBooksIssued());
        result = 31 * result + Arrays.hashCode(getNamesOfBooks());
        return result;
    }

    /**
     * This methods helps Students to issue books
     * A student can issue atmost 2 books at a time
     */
    public void issueBook() {
        if (noOfBooksIssued == 0) {
            System.out.println("What's your good name?");
            nameOfStudent = scanner.nextLine();
            System.out.println("University Roll number is Required:");
            universityRollNo = scanner.nextInt();
            scanner.nextLine();
            System.out.println("Which book do you want to issued?");
            String bookName = scanner.nextLine();
            System.out.println("You have to enter the name of author also");
            String authorName = scanner.nextLine();
            namesOfBooks[getNoOfBooksIssued()] = new Book(bookName, authorName);
            System.out.println(bookName + " is issued to you.Hope you gain some knowledge.");
            setNoOfBooksIssued();
        } else if (noOfBooksIssued < 2 && noOfBooksIssued != 0) {
            System.out.println("Which book do you want to issued?");
            String bookName = scanner.nextLine();
            System.out.println("You have to enter the name of author also");
            String authorName = scanner.nextLine();
            namesOfBooks[getNoOfBooksIssued()] = new Book(bookName, authorName);
            System.out.println(bookName + " is issued to you.Hope you gain some knowledge.");
            setNoOfBooksIssued();
        } else {
            System.out.println("You can't issue more than 2 books at a time!!");
        }
    }

    /**
     * This method helps students to return books
     */
    public void returnBook() {
        if (noOfBooksIssued == 0) {
            System.out.println("How can you return a book,you haven't issued any book yet.");
        } else {
            System.out.println("Which book do you want to return and enter the author name also");
            String bookName = scanner.nextLine();
            String authorName = scanner.nextLine();
            int i;
            for (i = 0; i < noOfBooksIssued; i++) {
                if (namesOfBooks[i].getNameOfTheBook().equalsIgnoreCase(bookName) && namesOfBooks[i].getNameOfTheAuthor().equalsIgnoreCase(authorName)) {
                    namesOfBooks[i].setNameOfTheBook("-----");
                    namesOfBooks[i].setNameOfTheAuthor("-----");
                    System.out.println("Book returned successfully");
                    break;
                }
            }
            if (i == noOfBooksIssued) {
                System.out.println("No such book issued");
            }
        }
    }

    /**
     * This method shows all the books issued by a particular student.
     */
    public void myBooks() {
        System.out.println("Name: " + nameOfStudent);
        if (noOfBooksIssued == 0) {
            System.out.println("You haven't issued any book");
        } else {
            for (Book issue : namesOfBooks) {
                System.out.println(issue);
            }
        }
    }
}