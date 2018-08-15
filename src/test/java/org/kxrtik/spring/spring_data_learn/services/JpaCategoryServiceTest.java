package org.kxrtik.spring.spring_data_learn.services;

import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.extension.ExtendWith;
import org.kxrtik.spring.spring_data_learn.configurations.DataSourceConfiguration;
import org.kxrtik.spring.spring_data_learn.configurations.JpaConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes={JpaCategoryService.class, JpaConfiguration.class, DataSourceConfiguration.class})
class JpaCategoryServiceTest {

    @Autowired
    JpaCategoryService jpaCategoryService;

    @Test
    void getCustomerById() {

    }

    @Test
    @Transactional
    void createCustomer() {
        jpaCategoryService.createCustomer("test", "t");
    }
}