package org.kxrtik.spring.spring_data_learn.models;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.*;

class CategoryTest {

    private static Category category;

    @BeforeAll
    static void setUp() {
        System.out.println("Testing");
        category = new Category(BigInteger.ZERO, "grocery", "gry");
    }

    @Test
    void getId() {
        assertEquals(category.getId(), BigInteger.ZERO);
    }

    @Test
    void setId() {
        category.setId(BigInteger.ONE);
        assertEquals(category.getId(), BigInteger.ONE);
    }

    @Test
    void getName() {
        assertEquals(category.getName(), "grocery");
    }

    @Test
    void setName() {
        category.setName("not grocery");
        assertEquals(category.getName(), "not grocery");
    }

    @Test
    void getTag() {
        assertEquals(category.getTag(), "gry");
    }

    @Test
    void setTag() {
        category.setTag("ngy");
        assertEquals(category.getTag(), "ngy");
    }
}