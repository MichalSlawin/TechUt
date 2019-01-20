package ug.techut.zad04.service;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ug.techut.zad04.domain.Lock;
import ug.techut.zad04.domain.Producer;

import java.util.List;

@Component
@Transactional
public class LockManagerHibernateImpl implements LockManager {

    @Autowired
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void addLock(Lock lock) {
        lock.setId(null);
        sessionFactory.getCurrentSession().persist(lock);
    }

    @Override
    public void deleteLock(Lock lock) {
        lock = (Lock) sessionFactory.getCurrentSession().get(Lock.class, lock.getId());

        sessionFactory.getCurrentSession().delete(lock);
    }

    @Override
    public void updateLock(Lock lock) {
        sessionFactory.getCurrentSession().update(lock);
    }

    @Override
    public List<Lock> getAllLocks() {
        return sessionFactory.getCurrentSession().getNamedQuery("lock.all").list();

    }

    @Override
    public Lock getLock(Long id) {
        return (Lock) sessionFactory.getCurrentSession().getNamedQuery("lock.byId")
                .setLong("id", id).uniqueResult();
    }

    @Override
    public List<Lock> getLocks(boolean electronic) {
        return sessionFactory.getCurrentSession().getNamedQuery("lock.byElectronic")
                .setBoolean("electronic", electronic).list();
    }

    @Override
    public List<Lock> getLocks(Producer producer) {
        return sessionFactory.getCurrentSession().getNamedQuery("lock.byProducer")
                .setParameter("producer", producer).list();
    }
}
