package com.example.searchservice.service.impl;

import com.example.searchservice.dao.BookDao;
import com.example.searchservice.models.Book;
import com.example.searchservice.service.SearchService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class SearchServiceImpl implements SearchService {

    private final BookDao bookDao;

    public SearchServiceImpl(BookDao bookDao){
        this.bookDao = bookDao;
    }
    @Override
    public List<Book> searchBook(String query, int page, int size, String sortField, String sortDirection) {
        log.info("Initiating search with query: '{}', page: {}, size: {}, sortField: {}, sortDirection: {}",
                query, page, size, sortField, sortDirection);
        //List<Book> books = new ArrayList<>();
        List<Book> books = bookDao.searchBook(query,page, size, sortField, sortDirection);
        return books;
    }
}
