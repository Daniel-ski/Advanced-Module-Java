package IteratorsAndComparators.x02_Library;

import java.util.Iterator;

public class Library implements Iterable<Book> {
    private Book[] books;

    public Library(Book... books) {
        this.books = books;
    }

    public Book[] getBooks() {
        return books;
    }

    @Override
    public Iterator<Book> iterator() {
        return new LibIterator();
        }


        private class LibIterator implements Iterator<Book> {
            private int counter;

            public LibIterator() {
                this.counter = 0;
            }

            public boolean hasNext() {
                return this.counter < books.length;
            }

            public Book next() {
                return books[counter++];
            }
        } 
    }

