package sk.stuba.fei.uim.vsa.domain;

import java.sql.SQLException;
import java.util.Optional;

public interface BookRepositoryInterface {

    Optional<Book> findByTitle(String title) throws SQLException;

    Book insert(Book book) throws SQLException;

    Book update(Book book) throws SQLException;
}