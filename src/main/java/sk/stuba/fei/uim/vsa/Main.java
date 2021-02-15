package sk.stuba.fei.uim.vsa;


import lombok.extern.slf4j.Slf4j;

import java.sql.*;

@Slf4j
public class Main {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        testH2();
        testMySql();
    }

    private static void testH2() throws SQLException, ClassNotFoundException {
        Class.forName("org.h2.Driver");
        log.info("Testing H2 embedded database");
        testConnection("jdbc:h2:file:./database;SCHEMA=PUBLIC;DATABASE_TO_UPPER=false", "", "");
    }

    private static void testMySql() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        log.info("Testing MySQL database");
        testConnection("jdbc:mysql://localhost/vsa", "root", "root");
    }

    private static void testConnection(String url, String user, String password) throws SQLException {
        Connection connection = DriverManager.getConnection(url, user, password);

        Statement statement = connection.createStatement();
        String sql = "SELECT * FROM Books";
        ResultSet resultSet = statement.executeQuery(sql);

        while (resultSet.next()) {
            int id = resultSet.getInt(1);
            String title = resultSet.getString(2);
            String author = resultSet.getString(3);

            Book book = new Book(id, title, author);
            log.info(book.toString());
        }

        resultSet.close();
        statement.close();
        connection.close();
    }
}
