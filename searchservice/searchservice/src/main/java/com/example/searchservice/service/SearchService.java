package com.example.searchservice.service;

import com.example.searchservice.models.Book;

import java.util.List;

public interface SearchService {
    List<Book> searchBook(String query, int page, int size, String sortField, String sortDirection);
}
