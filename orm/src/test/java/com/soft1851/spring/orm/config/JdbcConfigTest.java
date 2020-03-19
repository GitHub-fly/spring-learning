package com.soft1851.spring.orm.config;

import com.soft1851.spring.orm.entity.Forum;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {JdbcConfig.class})
//@ContextConfiguration(locations = {"/applicationContext.xml"})
public class JdbcConfigTest {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Test
    public void test() {
        String sql = "SELECT * FROM t_forum ";
        jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Forum.class)).forEach(System.out::println);
    }
}