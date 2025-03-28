package com.example.searchservice.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Document(indexName = "books")
public class Book {
    @Id
    private String id;
    private String title;
    private String author;
    private String isbn;
    private String description;
    private double price;
    private String category;
    private String imageUrl;

//    public Book() {
//    }

//    public Book(String id, String title, String author, String isbn, String description, double price, String category, String imageUrl) {
//        this.id = id;
//        this.title = title;
//        this.author = author;
//        this.isbn = isbn;
//        this.description = description;
//        this.price = price;
//        this.category = category;
//        this.imageUrl = imageUrl;
//    }

    // Getters and setters
//    public String getId() {
//        return id;
//    }
//    public void setId(String id) {
//        this.id = id;
//    }
//    public String getTitle() {
//        return title;
//    }
//    public void setTitle(String title) {
//        this.title = title;
//    }
//    public String getAuthor() {
//        return author;
//    }
//    public void setAuthor(String author) {
//        this.author = author;
//    }
//    public String getIsbn() {
//        return isbn;
//    }
//    public void setIsbn(String isbn) {
//        this.isbn = isbn;
//    }
//    public String getDescription() {
//        return description;
//    }
//    public void setDescription(String description) {
//        this.description = description;
//    }
//    public double getPrice() {
//        return price;
//    }
//    public void setPrice(double price) {
//        this.price = price;
//    }
//    public String getCategory() {
//        return category;
//    }
//    public void setCategory(String category) {
//        this.category = category;
//    }
//    public String getImageUrl() {
//        return imageUrl;
//    }
//    public void setImageUrl(String imageUrl) {
//        this.imageUrl = imageUrl;
//    }
}
