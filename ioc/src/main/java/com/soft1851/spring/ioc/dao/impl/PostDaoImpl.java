package com.soft1851.spring.ioc.dao.impl;

import com.soft1851.spring.ioc.dao.PostDao;
import com.soft1851.spring.ioc.entity.Forum;
import com.soft1851.spring.ioc.entity.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

/**
 * @author xunmi
 * @ClassName PostDaoImpl
 * @Description TODO
 * @Date 2020/3/17
 * @Version 1.0
 **/
@Repository
public class PostDaoImpl implements PostDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int insert(Post post) {
        String sql = "INSERT INTO t_post VALUES (NULL, ?, ?, ?, ?, ?) ";
        Object[] args = {
                post.getForumId(),
                post.getTitle(),
                post.getContent(),
                post.getThumbnail(),
                post.getPostTime()
        };
        return jdbcTemplate.update(sql, args);
    }

    @Override
    public int[] batchInsert(List<Post> posts) {
        final List<Post> postList = posts;
        String sql = "INSERT INTO t_post VALUES (NULL, ?, ?, ?, ?, ?) ";
        return jdbcTemplate.batchUpdate(sql, new BatchPreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement ps, int i) throws SQLException {
                ps.setInt(1, postList.get(i).getForumId());
                ps.setString(2, postList.get(i).getTitle());
                ps.setString(3, postList.get(i).getContent());
                ps.setObject(4, postList.get(i).getThumbnail());
                ps.setObject(5, postList.get(i).getPostTime());
            }

            @Override
            public int getBatchSize() {
                return postList.size();
            }
        });
    }

    @Override
    public int delete(int postId) {
        String sql = "DELETE FROM t_post WHERE post_id = ? ";
        Object[] args = { postId };
        return jdbcTemplate.update(sql, args);
    }

    @Override
    public Post get(int postId) {
        String sql = "SELECT * FROM t_post WHERE post_id = ? ";
        Object[] args = { postId };
        return jdbcTemplate.queryForObject(sql, args, new BeanPropertyRowMapper<>(Post.class));
    }

    @Override
    public List<Post> selectByKey(String key) {
        String sql = "SELECT * FROM t_post \n" +
                    "WHERE title LIKE '%" + key + "%'" +
                    "OR content LIKE '%" + key + "%' ";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Post.class));
    }

    @Override
    public int count(Integer forumId) {
        String sql = "SELECT COUNT(*)\n" +
                "FROM t_post post\n" +
                "LEFT JOIN t_forum forum\n" +
                "ON post.forum_id = forum.forum_id\n" +
                "WHERE post.forum_id = ? ";
        Object[] args = { forumId };
        return jdbcTemplate.query(sql,args, new BeanPropertyRowMapper<>(Forum.class)).size();
    }
}
