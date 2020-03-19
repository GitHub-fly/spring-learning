package com.soft1851.spring.ioc.other;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = {"/applicationContext.xml"})
public class SortTest {

    @Autowired
    private Sort sort;

    @Test
    public  void test() {
        for (int i : sort.sortSelection()) {
            System.out.print(i + "\t");
        }

        System.out.println("\n" + "--------------------------------------------------------");

        for (int i : sort.sort()) {
            System.out.print(i + "\t");
        }
    }
}