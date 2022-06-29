package com.webfluxdemo.lambdaExample;

import java.util.ArrayList;
import java.util.List;

public class BookDAO {
    public List<Book> getBooks(){
        List<Book> books = new ArrayList<>();

        books.add(new Book(101, "Java", 400));
        books.add(new Book(102, "JDBC", 300));
        books.add(new Book(103, "Spring", 200));

        return books;
    }
}
