package com.example.searchservice.dao;

import com.example.searchservice.models.Book;

import java.util.List;

public interface BookDao {

    List<Book> searchBook(String query, int page, int size, String sortField, String sortDirection);
}
