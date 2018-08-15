package org.kxrtik.spring.spring_data_learn.configurations;

import org.kxrtik.spring.spring_data_learn.annotations.Dev;
import org.springframework.context.annotation.Profile;

import javax.sql.DataSource;

public interface DataConfig {
    public DataSource dataSource();
}
