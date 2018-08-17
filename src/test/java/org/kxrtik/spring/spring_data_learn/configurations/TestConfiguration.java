package org.kxrtik.spring.spring_data_learn.configurations;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages= {"org.kxrtik.spring.spring_data_learn.services", "org.kxrtik.spring.spring_data_learn.configurations"})
public class TestConfiguration {}