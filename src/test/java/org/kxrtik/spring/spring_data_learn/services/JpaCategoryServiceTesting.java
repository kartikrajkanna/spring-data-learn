package org.kxrtik.spring.spring_data_learn.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.extension.ExtendWith;
import org.kxrtik.spring.spring_data_learn.configurations.TestConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes=TestConfiguration.class)
class JpaCategoryServiceTesting {

    @Autowired
    private JpaCategoryService jpaCategoryService;

    @Test
    void getCustomerById() {

    }

    @Test
    @Transactional
    void createCustomer() {
        jpaCategoryService.createCustomer("test", "t");
    }
}