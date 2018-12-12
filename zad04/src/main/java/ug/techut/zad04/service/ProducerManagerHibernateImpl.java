package ug.techut.zad04.service;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ug.techut.zad04.domain.Producer;

import java.util.List;

@Component
@Transactional
public class ProducerManagerHibernateImpl implements ProducerManager {

    @Autowired
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void clearProducers() {

    }

    @Override
    public void addProducer(Producer producer) {
        producer.setId(null);
        sessionFactory.getCurrentSession().persist(producer);
    }

    @Override
    public void deleteProducer(Producer producer) {
        producer = (Producer) sessionFactory.getCurrentSession().get(Producer.class, producer.getId());

        sessionFactory.getCurrentSession().delete(producer);
    }

    @Override
    public List<Producer> getAllProducers() {
        return sessionFactory.getCurrentSession().getNamedQuery("producer.all").list();
    }

    @Override
    public Producer getProducer(Long id) {
        return null;
    }

    @Override
    public Producer getProducer(String name) {
        return (Producer) sessionFactory.getCurrentSession().getNamedQuery("producer.byName")
                .setString("name", name).uniqueResult();
    }

}
