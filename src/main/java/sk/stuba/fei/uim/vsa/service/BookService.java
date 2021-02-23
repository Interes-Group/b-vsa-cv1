package sk.stuba.fei.uim.vsa.service;

import sk.stuba.fei.uim.vsa.domain.Book;
import sk.stuba.fei.uim.vsa.domain.BookRepositoryInterface;

import java.sql.SQLException;
import java.util.Optional;

public class BookService implements BookServiceInterface {

    private final BookRepositoryInterface repository;

    public BookService(BookRepositoryInterface repository) {
        this.repository = repository;
    }

    @SuppressWarnings("OptionalIsPresent")
    @Override
    public double cenaKnihy(String meno) {
        try {
            Optional<Book> book = repository.findByTitle(meno);
            if (book.isPresent()) {
                return book.get().getPrice();
            } else {
                return -1;
            }
        } catch (SQLException exception) {
            return -1;
        }
    }

    @Override
    public boolean pridajKnihu(String meno, double cena) {
        try {
            Optional<Book> book = repository.findByTitle(meno);
            if (book.isPresent()) {
                return false;
            } else {
                Book newBook = new Book(meno, cena);
                repository.insert(newBook);
                return true;
            }
        } catch (SQLException exception) {
            return false;
        }
    }

    @Override
    public void zlava(String meno) {
        try {
            Optional<Book> bookOptional = repository.findByTitle(meno);
            if (!bookOptional.isPresent()) {
                return;
            }
            Book book = bookOptional.get();
            book.setPrice(book.getPrice() * 0.8);
            repository.update(book);
        } catch (SQLException ignored) {}
    }
}