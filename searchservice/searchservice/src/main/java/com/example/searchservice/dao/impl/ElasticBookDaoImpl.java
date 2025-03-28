package com.example.searchservice.dao.impl;

import com.example.searchservice.dao.BookDao;
import com.example.searchservice.models.Book;
import com.example.searchservice.repository.BookSearchRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@ConditionalOnProperty(name="search.engine", havingValue = "elasticsearch")
@Slf4j
public class ElasticBookDaoImpl implements BookDao {

    private BookSearchRepository bookSearchRepository;

    public ElasticBookDaoImpl(BookSearchRepository bookSearchRepository){
        this.bookSearchRepository = bookSearchRepository;
    }
    @Override
    public List<Book> searchBook(String query, int page, int size, String sortField, String sortDirection) {
        try{
            log.info("Building Elasticsearch query for search: query='{}', page={}, size={}, sortField={}, sortDirection={}",
                    query, page, size, sortField, sortDirection);
            Pageable pageable = PageRequest.of(page, size, Sort.by(sortDirection, sortField));
            List<Book> books = bookSearchRepository.search(query, pageable);
            //List<Book> books = new ArrayList<>();
            log.info("Elasticsearch query executed successfully. Found {} results.", books.size());
            return books;
        } catch(Exception ex){
            log.error("Error executing Elasticsearch search query for query '{}': {}", query, ex.getMessage(), ex);
            throw ex;
        }
    }
}
