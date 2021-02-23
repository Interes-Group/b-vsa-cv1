package sk.stuba.fei.uim.vsa;


import lombok.extern.slf4j.Slf4j;
import sk.stuba.fei.uim.vsa.domain.Book;
import sk.stuba.fei.uim.vsa.domain.BookRepository;
import sk.stuba.fei.uim.vsa.domain.BookRepositoryInterface;
import sk.stuba.fei.uim.vsa.service.BookService;
import sk.stuba.fei.uim.vsa.service.BookServiceInterface;

import java.sql.*;

@Slf4j
public class Main {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/vsa", "root", "root");

        BookRepositoryInterface repository = new BookRepository(connection);
        BookServiceInterface service = new BookService(repository);

        double cenaKnihy = service.cenaKnihy("Title 2");

        connection.close();
    }
}
