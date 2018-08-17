package org.kxrtik.spring.spring_data_learn.services;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Iterator;
import java.util.List;

import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.extension.ExtendWith;
import org.kxrtik.spring.spring_data_learn.configurations.TestConfiguration;
import org.kxrtik.spring.spring_data_learn.models.Category;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes=TestConfiguration.class)
@Transactional
class JpaCategoryServiceTest {

    @Autowired
    private JpaCategoryService jpaCategoryService;
    Logger logger = LoggerFactory.getLogger(JpaCategoryServiceTest.class.getSimpleName());
    
    @Test
    void testCreatingCustomer() {
        Category c = jpaCategoryService.createCategory("test", "t");
    	jpaCategoryService.createCategory("test", "t1");
    	jpaCategoryService.createCategory("test", "t2");
    	jpaCategoryService.createCategory("test1", "notT");
        assertEquals("test", c.getName());
        assertEquals("t", c.getTag());
    }
    
    @Test
    void testGetCategoriesByTag() {
    	Category c1 = jpaCategoryService.createCategory("test", "t");
    	Category c2 = jpaCategoryService.createCategory("test2", "t");
    	Category c3 = jpaCategoryService.createCategory("test3", "notT");
    	
    	List<Category> result = jpaCategoryService.getCategoriesByTag("t");
    	
    	assertTrue(result.contains(c1));
    	assertTrue(result.contains(c2));
    	assertFalse(result.contains(c3));
    	
    	Iterator<Category> iterator = result.iterator();
    	
    	while (iterator.hasNext()) {
    		assertEquals("t", iterator.next().getTag());
    	}
    }
    
    @Test
    void testGetCategoriesByName() {
    	Category c1 = jpaCategoryService.createCategory("test", "t1");
    	Category c2 = jpaCategoryService.createCategory("test", "t2");
    	Category c3 = jpaCategoryService.createCategory("test1", "notT");
    	
    	List<Category> result = jpaCategoryService.getCategoriesByName("test");
    	
    	assertTrue(result.contains(c1));
    	assertTrue(result.contains(c2));
    	assertFalse(result.contains(c3));
    	
    	Iterator<Category> iterator = result.iterator();
    	
    	while (iterator.hasNext()) {
    		assertEquals("test", iterator.next().getName());
    	}
    }
}