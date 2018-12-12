package ug.techut.zad04.service;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ug.techut.zad04.domain.Door;
import ug.techut.zad04.domain.Producer;

import java.sql.PreparedStatement;
import java.util.List;

@Component
@Transactional
public class DoorManagerHibernateImpl implements DoorManager {

    @Autowired
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void clearDoors() {

    }

    @Override
    public void addDoor(Door door) {
        door.setId(null);
        sessionFactory.getCurrentSession().persist(door);
    }

    @Override
    public void deleteDoor(Door door) {
        door = (Door) sessionFactory.getCurrentSession().get(Door.class, door.getId());

        sessionFactory.getCurrentSession().delete(door);
    }

    @Override
    public List<Door> getDoors(PreparedStatement preparedStatement) {
        return null;
    }

    @Override
    public List<Door> getAllDoors() {
        return sessionFactory.getCurrentSession().getNamedQuery("door.all").list();
    }

    @Override
    public List<Door> findDoorById(long id) {
        return null;
    }

    @Override
    public List<Door> findDoorByProducer(String producer) {
        return null;
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

    }

    @Override
    public List<Producer> getAllProducers() {
        return sessionFactory.getCurrentSession().getNamedQuery("producer.all").list();
    }

    @Override
    public void addAllDoors(List<Door> doorsList) {

    }
}
