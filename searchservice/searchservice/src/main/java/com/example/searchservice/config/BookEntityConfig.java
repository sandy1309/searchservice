package com.example.searchservice.config;

import com.example.searchservice.models.Book;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.mapping.ElasticsearchPersistentEntity;
import org.springframework.data.elasticsearch.repository.support.ElasticsearchEntityInformation;
import org.springframework.data.elasticsearch.repository.support.MappingElasticsearchEntityInformation;

@Configuration
public class BookEntityConfig {
    @Bean
    public ElasticsearchEntityInformation<Book, String> bookEntityInformation(ElasticsearchOperations elasticsearchOperations) {
        ElasticsearchPersistentEntity<Book> persistentEntity =
                (ElasticsearchPersistentEntity<Book>) elasticsearchOperations.getElasticsearchConverter().getMappingContext().getRequiredPersistentEntity(Book.class);
        return new MappingElasticsearchEntityInformation<>(persistentEntity);
    }
}
