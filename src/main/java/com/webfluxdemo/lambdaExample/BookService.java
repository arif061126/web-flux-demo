package com.webfluxdemo.lambdaExample;

import java.util.Collections;
import java.util.List;

public class BookService {
    private BookDAO bookDAO = new BookDAO();

    public List<Book> getBooksInSort(){
        List<Book> bookList = bookDAO.getBooks();
        //Collections.sort(bookList,new MyComparator());
        /*Collections.sort(bookList, new Comparator<Book>() {
            @Override
            public int compare(Book o1, Book o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });*/

        //Collections.sort(bookList,(Comparator.comparing(Book::getName)));
        //Collections.sort(bookList,((o1, o2) -> o2.getName().compareTo(o1.getName())));

        Collections.sort(bookList,((o1, o2) -> o1.getName().compareTo(o2.getName())));

        return bookList;
    }

    public List<Book> getBooksInDeSort(){
        List<Book> bookList = bookDAO.getBooks();
        //Collections.sort(bookList,new MyComparator());
        /*Collections.sort(bookList, new Comparator<Book>() {
            @Override
            public int compare(Book o1, Book o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });*/

        //Collections.sort(bookList,(Comparator.comparing(Book::getName)));
        Collections.sort(bookList,((b1, b2) -> b2.getName().compareTo(b1.getName())));
        //Collections.sort(bookList,((o1, o2) -> o1.getName().compareTo(o2.getName())));

        return bookList;
    }

    public static void main(String[] args) {
        System.out.println(new BookService().getBooksInSort());
        System.out.println(new BookService().getBooksInDeSort());
    }
}

/*class MyComparator implements Comparator<Book> {

    @Override
    public int compare(Book o1, Book o2) {
        return o1.getName().compareTo(o2.getName());
    }
}*/
