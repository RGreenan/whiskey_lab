package com.codeclan.example.WhiskyTracker.repositories.DistilleryRepository;

import com.codeclan.example.WhiskyTracker.models.Distillery;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

public class DistilleryRepositoryImpl implements DistilleryRepositoryCustom {

    @Autowired
    EntityManager entityManager;

    @JsonIgnoreProperties("age")
    @Transactional
    public List<Distillery> findDistilleryWithWhiskyAged(int age){
        List<Distillery> results = null;

        Session session = entityManager.unwrap(Session.class);

        try{
            Criteria cr = session.createCriteria(Distillery.class);
            cr.createAlias("whiskies", "whiskiesAlias");
            cr.add(Restrictions.eq("whiskiesAlias.age", age));
            results = cr.list();
        }
        catch (HibernateException ex){
            ex.printStackTrace();
        }
        return results;
    }

}
