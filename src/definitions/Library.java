/*  Created by IntelliJ IDEA.
 *  User: Devendra Srivastava(DEV-PROG-Spec)
 *  Date: 21/08/20
 *  Time: 3:50 PM
 *  File Name : Library.java
 * */
package definitions;

import java.util.Arrays;

public class Library {
    Book[] booksCurrentlyAvailable;

    public Library() {
        this.booksCurrentlyAvailable = new Book[10];
        for (int i = 0; i < booksCurrentlyAvailable.length; i++) {
            booksCurrentlyAvailable[i] = new Book("BOOK" + (i + 1), "abc" + (i + 1));
        }
    }

    public Library(Book[] booksCurrentlyAvailable) {
        this.booksCurrentlyAvailable = booksCurrentlyAvailable;
    }

    public Book[] getBooksCurrentlyAvailable() {
        return booksCurrentlyAvailable.clone();
    }

    public void setBooksCurrentlyAvailable(Book[] booksCurrentlyAvailable) {
        this.booksCurrentlyAvailable = booksCurrentlyAvailable;
    }

    @Override
    public String toString() {
        return "Library{" +
                "booksCurrentlyAvailable=" + Arrays.toString(booksCurrentlyAvailable) +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Library library = (Library) o;
        return Arrays.equals(getBooksCurrentlyAvailable(), library.getBooksCurrentlyAvailable());
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(getBooksCurrentlyAvailable());
    }

    /**
     * This method return all books present in Library.
     */

    public void allBooksInLibrary() {
        for (Book allBooks : booksCurrentlyAvailable) {
            System.out.println(allBooks);
        }
    }
}