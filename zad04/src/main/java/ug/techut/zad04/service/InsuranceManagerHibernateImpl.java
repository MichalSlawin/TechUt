package ug.techut.zad04.service;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ug.techut.zad04.domain.Insurance;

import java.util.Date;
import java.util.List;

@Component
@Transactional
public class InsuranceManagerHibernateImpl implements InsuranceManager {

    @Autowired
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void addInsurance(Insurance insurance) {
        insurance.setId(null);
        sessionFactory.getCurrentSession().persist(insurance);
    }

    @Override
    public void deleteInsurance(Insurance insurance) {
        insurance = (Insurance) sessionFactory.getCurrentSession().get(Insurance.class, insurance.getId());

        sessionFactory.getCurrentSession().delete(insurance);
    }

    @Override
    public void updateInsurance(Insurance insurance) {
        sessionFactory.getCurrentSession().update(insurance);
    }

    @Override
    public List<Insurance> getAllInsurances() {
        return sessionFactory.getCurrentSession().getNamedQuery("insurance.all").list();
    }

    @Override
    public Insurance getInsurance(Long id) {
        return (Insurance) sessionFactory.getCurrentSession().getNamedQuery("insurance.byId")
                .setLong("id", id).uniqueResult();
    }

    @Override
    public List<Insurance> getInsurances(Date date) {
        return sessionFactory.getCurrentSession().getNamedQuery("insurance.byDate").
                setDate("date", date).list();
    }

    @Override
    public List<Insurance> getInsurances(String type) {
        return sessionFactory.getCurrentSession().getNamedQuery("insurance.byType").
                setString("type", type).list();
    }
}
