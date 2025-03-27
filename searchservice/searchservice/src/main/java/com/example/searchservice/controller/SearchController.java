package com.example.searchservice.controller;

import com.example.searchservice.models.Book;
import com.example.searchservice.service.SearchService;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/search")
@Slf4j
@Validated
public class SearchController {
    @Autowired
    SearchService searchService;

    @GetMapping
    public ResponseEntity<List<Book>> searchBooks(
            @RequestParam("q")  @NotBlank(message = "query parameter must not be blank") String query,
            @RequestParam(value = "page", defaultValue = "0") @Min(value = 0,
                    message = "page number must be 0 or greater than 0") int page,
            @RequestParam(value = "size", defaultValue = "10") @Min(value = 1,
                    message = "page sige must be  or grater than 1") int size,
            @RequestParam(value = "sortField", defaultValue = "title") String sortField,
            @RequestParam(value = "sortDirection", defaultValue = "ASC")
            @Pattern(regexp = "ASC|DESC", message = "Sort direction must be ASC orDESC") String setDirection) {
        String traceId = MDC.get("traceId");

        if(traceId == null){
            traceId = "N/A";
        }

        log.info("Trace Id  : {} - received search  request : query = '{}' , page = {}, size ={}",
                traceId,query,page, size);

        List<Book> results = searchService.searchBook(query, page, size, sortField, setDirection);

        return ResponseEntity.ok(results);

    }
}
