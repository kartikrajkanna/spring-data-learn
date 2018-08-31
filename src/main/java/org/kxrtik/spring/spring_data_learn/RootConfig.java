package org.kxrtik.spring.spring_data_learn;

import org.kxrtik.spring.spring_data_learn.configurations.Configurations;
import org.kxrtik.spring.spring_data_learn.models.Models;
import org.kxrtik.spring.spring_data_learn.services.Services;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackageClasses = { Configurations.class, Models.class, Services.class })
public class RootConfig {

}