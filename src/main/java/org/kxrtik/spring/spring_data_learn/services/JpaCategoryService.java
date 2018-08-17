package org.kxrtik.spring.spring_data_learn.services;

import org.hibernate.Session;

import org.kxrtik.spring.spring_data_learn.models.Category;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;


@Service
@Transactional
public class JpaCategoryService {

    @PersistenceContext
    private EntityManager entityManager;
    
    @Transactional(readOnly=true)
    public List<Category> getCategoriesByName(String name) {
    	return getCategoriesByField("name", name);
    }
    
    @Transactional(readOnly=true)
    public List<Category> getCategoriesByTag(String tag) {
    	return getCategoriesByField("tag", tag);
    }

    public Category createCategory(String name, String tag) {
        Category newCustomer = new Category();

        newCustomer.setName(name);
        newCustomer.setTag(tag);

        entityManager.persist(newCustomer);
        return newCustomer;
    }

    void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    
    @Transactional(readOnly=true)
    private List<Category> getCategoriesByField(String field, String value) {
    	Session session = entityManager.unwrap(Session.class);
    	CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
    	CriteriaQuery<Category> criteria = criteriaBuilder.createQuery(Category.class);
    	Root<Category> category = criteria.from(Category.class);
    	
    	criteria.select(category).where(criteriaBuilder.equal(category.get(field), value));
    	return entityManager.createQuery(criteria).getResultList();
    }
}
