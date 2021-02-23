package sk.stuba.fei.uim.vsa.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data
@AllArgsConstructor
@ToString
public class Book {

    private Integer id;
    private String title;
    private double price;

    public Book(String title, double price) {
        this.title = title;
        this.price = price;
    }
}