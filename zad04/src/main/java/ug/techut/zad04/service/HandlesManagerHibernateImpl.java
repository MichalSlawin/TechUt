package ug.techut.zad04.service;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ug.techut.zad04.domain.Handles;

import java.util.List;

@Component
@Transactional
public class HandlesManagerHibernateImpl implements HandlesManager {

    @Autowired
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void addHandles(Handles handles) {
        handles.setId(null);
        sessionFactory.getCurrentSession().persist(handles);
    }

    @Override
    public void deleteHandles(Handles handles) {
        handles = (Handles) sessionFactory.getCurrentSession().get(Handles.class, handles.getId());

        sessionFactory.getCurrentSession().delete(handles);
    }

    @Override
    public void updateHandles(Handles handles) {
        sessionFactory.getCurrentSession().update(handles);
    }

    @Override
    public List<Handles> getAllHandles() {
        return sessionFactory.getCurrentSession().getNamedQuery("handles.all").list();
    }

    @Override
    public Handles getHandles(Long id) {
        return (Handles) sessionFactory.getCurrentSession().getNamedQuery("handles.byId")
                .setLong("id", id).uniqueResult();
    }

    @Override
    public List<Handles> getHandles(String shape) {
        return sessionFactory.getCurrentSession().getNamedQuery("handles.byShape")
                .setString("shape", shape).list();
    }
}
