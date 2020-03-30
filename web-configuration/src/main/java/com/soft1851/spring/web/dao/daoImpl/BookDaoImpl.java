package com.soft1851.spring.web.dao.daoImpl;

import com.soft1851.spring.web.dao.BookDao;
import com.soft1851.spring.web.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

/**
 * @author xunmi
 * @ClassName BookDaoImpl
 * @Description TODO
 * @Date 2020/3/28
 * @Version 1.0
 **/
@Repository
@Transactional(rollbackFor = Exception.class)
public class BookDaoImpl implements BookDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int insert(Book book) {
        String sql = "INSERT INTO t_wangyi (id, title, author, cover, description) " +
                "VALUE (NULL,?,?,?,?) ";
        Object[] params = {
                book.getTitle(), book.getAuthor(), book.getCover(), book.getDescription()
        };
        return jdbcTemplate.update(sql, params);
    }

    @Override
    public int[] batchInsert(List<Book> list) {
        final List<Book> bookList = list;
        String sql = "INSERT INTO t_wangyi (id, title, author, cover, description) " +
                "VALUES (NULL,?,?,?,?) ";
        return jdbcTemplate.batchUpdate(sql, new BatchPreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement ps, int i) throws SQLException {
                Book book = bookList.get(i);
                ps.setString(1, book.getTitle());
                ps.setString(2, book.getAuthor());
                ps.setString(3, book.getCover());
                ps.setString(4, book.getDescription());
            }

            @Override
            public int getBatchSize() {
                return bookList.size();
            }
        });
    }

    @Override
    public List<Book> selectAll() {
        String sql = "SELECT * FROM t_wangyi ";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Book.class));
    }
}
