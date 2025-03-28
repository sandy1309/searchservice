package com.example.searchservice.repository;

import com.example.searchservice.models.Book;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookSearchRepository extends ElasticsearchRepository<Book, String> {

    List<Book> search(String query, Pageable pageable);

}
