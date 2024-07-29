package com.brytcode.springjdbc.repository;

import com.brytcode.springjdbc.book.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.sql.SQLType;
import java.sql.Types;
import java.util.List;

@Repository
public class BookRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private NamedParameterJdbcOperations operations;

    public List<Book> getBooks(){
        List<Book> books = jdbcTemplate.query("SELECT * FROM BOOK",new BeanPropertyRowMapper<>(Book.class));
        return books;
    }

    public Book updateBook(int bookId, BigDecimal newPrice){
        String updateQuery = String.format("UPDATE BOOK SET price=%f WHERE BOOK_ID=%d",newPrice, bookId);
        jdbcTemplate.update(updateQuery);
        Book result = jdbcTemplate.queryForObject(String.format("SELECT * FROM BOOK WHERE BOOK_ID=%d",bookId), new BeanPropertyRowMapper<>(Book.class));
        return result;
    }

    public Book updateBookByParams(int bookId, BigDecimal newPrice){
        SqlParameterSource params = new MapSqlParameterSource()
                                            .addValue("price", newPrice)
                                            .addValue("bookId", bookId);

        operations.update("UPDATE BOOK SET price=:price WHERE BOOK_ID=:bookId", params);
        /*Book result = operations.queryForObject(String.format("SELECT * FROM BOOK WHERE BOOK_ID=?",bookId),params, new BeanPropertyRowMapper<>(Book.class));*/
        return null;
    }



}
