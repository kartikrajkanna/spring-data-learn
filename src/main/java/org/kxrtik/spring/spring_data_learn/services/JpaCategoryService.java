package org.kxrtik.spring.spring_data_learn.services;

import org.kxrtik.spring.spring_data_learn.models.Category;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.math.BigInteger;

@Service
@Transactional
public class JpaCategoryService {

    private static BigInteger nextId = BigInteger.ZERO;

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional(readOnly=true)
    public Category getCustomerById(BigInteger id) {
        return entityManager.find(Category.class, id);
    }

    public Category createCustomer(String name, String tag) {
        Category newCustomer = new Category();
        newCustomer.setId(nextId);
        updateId();

        newCustomer.setName(name);
        newCustomer.setTag(tag);

        entityManager.persist(newCustomer);
        return newCustomer;
    }

    void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    private static void updateId() {
        nextId = nextId.add(BigInteger.ONE);
    }
}
