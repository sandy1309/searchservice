package com.example.searchservice.repository.impl;

import com.example.searchservice.models.Book;
import com.example.searchservice.repository.BookSearchRepository;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.client.elc.NativeQuery;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.query.Query;
import org.springframework.data.elasticsearch.repository.support.ElasticsearchEntityInformation;
import org.springframework.data.elasticsearch.repository.support.SimpleElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BookSearchRepositoryImpl extends SimpleElasticsearchRepository<Book,String> implements BookSearchRepository {
    private final ElasticsearchOperations elasticsearchOperations;

    public BookSearchRepositoryImpl(ElasticsearchEntityInformation<Book,String> entityInformation,
                                    ElasticsearchOperations elasticsearchOperations) {
        super(entityInformation, elasticsearchOperations);
        this.elasticsearchOperations = elasticsearchOperations;
    }

    @Override
    public List<Book> search(String query, Pageable pageable) {
//        Query searchQuery = NativeQuery.builder()
//                .withPageable(pageable)
//                .build();
        return null;
    }
}
