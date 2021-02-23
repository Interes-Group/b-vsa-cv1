package sk.stuba.fei.uim.vsa.domain;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Optional;

public class BookRepository implements BookRepositoryInterface {

    private final Connection connection;

    public BookRepository(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Optional<Book> findByTitle(String title) throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM Books WHERE title = \"" + title + "\"");
        if (resultSet.next()) {
            int id = resultSet.getInt(1);
            double price = resultSet.getDouble(3);
            statement.close();
            return Optional.of(new Book(id, title, price));
        } else {
            statement.close();
            return Optional.empty();
        }
    }

    @Override
    public Book insert(Book book) throws SQLException {
        Statement statement = connection.createStatement();
        statement.executeUpdate("INSERT INTO Books (id, title, price) VALUES (" + book.getId() + ", \"" + book.getTitle() + "\", " + book.getPrice() + ")");
        statement.close();
        return findByTitle(book.getTitle()).get();
    }

    @Override
    public Book update(Book book) throws SQLException {
        Statement statement = connection.createStatement();
        int update = statement.executeUpdate("UPDATE Books SET title = \"" + book.getTitle() + "\", price = \"" + book.getPrice() + "\" WHERE id = " + book.getId());
        statement.close();
        if (update == 1) {
            return findByTitle(book.getTitle()).get();
        }
        throw new SQLException("Book not found");
    }
}
