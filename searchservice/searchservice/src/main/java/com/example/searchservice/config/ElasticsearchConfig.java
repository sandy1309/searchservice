package com.example.searchservice.config;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.json.jackson.JacksonJsonpMapper;
import co.elastic.clients.transport.rest_client.RestClientTransport;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.client.elc.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;

@Configuration
@Slf4j
public class ElasticsearchConfig  {

    @Value("${elasticsearch.host:localhost}")
    private String host;

    @Value("${elasticsearch.port:9200}")
    private int port;

    @Value("${elasticsearch.scheme:http}")
    private String scheme;

    /**
     * Creates a RestClient bean for low-level communication with Elasticsearch.
     *
     * @return a configured RestClient instance.
     */
    @Bean(destroyMethod = "close")
    public RestClient restClient() {
        log.info("Creating RestClient for Elasticsearch at {}:{}", host, port);
        return RestClient.builder(new HttpHost(host, port, scheme)).build();
    }

    /**
     * Creates a RestClientTransport bean, wrapping the RestClient and using JacksonJsonpMapper for JSON mapping.
     *
     * @param restClient the low-level Elasticsearch client.
     * @return a RestClientTransport instance.
     */
    @Bean(destroyMethod = "close")
    public RestClientTransport restClientTransport(RestClient restClient) {
        return new RestClientTransport(restClient, new JacksonJsonpMapper());
    }

    /**
     * Creates an ElasticsearchClient bean using the new Java API client.
     *
     * @param transport the transport layer wrapping the RestClient.
     * @return a configured ElasticsearchClient.
     */
    @Bean
    public ElasticsearchClient elasticsearchClient(RestClientTransport transport) {
        ElasticsearchClient client = new ElasticsearchClient(transport);
        log.info("ElasticsearchClient created successfully");
        return client;
    }

    /**
     * Creates an ElasticsearchOperations bean using DefaultElasticsearchOperations, a non-deprecated
     * replacement for ElasticsearchRestTemplate.
     *
     * @param client the ElasticsearchClient to be used for operations.
     * @return a configured ElasticsearchOperations instance.
     */
    @Bean
    public ElasticsearchOperations elasticsearchOperations(ElasticsearchClient client) {
        ElasticsearchOperations operations = new ElasticsearchTemplate(client);
        log.info("ElasticsearchOperations (DefaultElasticsearchOperations) created successfully");
        return operations;
    }
}
