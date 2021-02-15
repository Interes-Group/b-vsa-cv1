package sk.stuba.fei.uim.vsa;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data
@AllArgsConstructor
@ToString
public class Book {

    private int id;
    private String title;
    private String author;
}