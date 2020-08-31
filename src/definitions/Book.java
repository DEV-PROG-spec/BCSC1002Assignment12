/*  Created by IntelliJ IDEA.
 *  User: Devendra Srivastava(DEV-PROG-Spec)
 *  Date: 21/08/20
 *  Time: 3:49 PM
 *  File Name : Book.java
 * */
package definitions;

import java.util.Objects;

public class Book {
    private String nameOfTheBook;
    private String nameOfTheAuthor;
    private String ISBNNumber;

    public Book(){
        this.nameOfTheBook="NOT FOUND";
        this.nameOfTheAuthor="NOT FOUND";
        this.ISBNNumber="NOT FOUND";
    }

    public Book(String nameOfTheBook,String nameOfTheAuthor) {
        this.nameOfTheBook=nameOfTheBook;
        this.nameOfTheAuthor=nameOfTheAuthor;
    }

    public void setNameOfTheBook(String nameOfTheBook) {
        this.nameOfTheBook = nameOfTheBook;
    }

    public String getNameOfTheBook() {
        return nameOfTheBook;
    }

    public void setNameOfTheAuthor(String nameOfTheAuthor) {
        this.nameOfTheAuthor = nameOfTheAuthor;
    }

    public String getNameOfTheAuthor() {
        return nameOfTheAuthor;
    }

    public void setISBNNumber(String ISBNNumber) {
        this.ISBNNumber = ISBNNumber;
    }

    public String getISBNNumber() {
        return ISBNNumber;
    }

    @Override
    public String toString() {
        return String.format("name of book=%s,name of author=%s,ISBN number=%s",nameOfTheBook,nameOfTheAuthor,ISBNNumber);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(getNameOfTheBook(), book.getNameOfTheBook()) &&
                Objects.equals(getNameOfTheAuthor(), book.getNameOfTheAuthor()) &&
                Objects.equals(getISBNNumber(), book.getISBNNumber());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNameOfTheBook(), getNameOfTheAuthor(), getISBNNumber());
    }


}