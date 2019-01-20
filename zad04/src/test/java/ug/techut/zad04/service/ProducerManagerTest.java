package ug.techut.zad04.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import ug.techut.zad04.domain.Producer;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static ug.techut.zad04.service.ProjectUtils.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/beans.xml" })
@TransactionConfiguration(transactionManager = "txManager", defaultRollback = true)
@Transactional
public class ProducerManagerTest {

    @Autowired
    ProducerManager producerManager;

    @Test
    public void addGetByNameProducerCheck() {
        Producer producer = new Producer(PRODUCER_NAME1);

        producerManager.addProducer(producer);
        Producer retrievedProducer = producerManager.getProducer(PRODUCER_NAME1);

        assertEquals(retrievedProducer.getName(), PRODUCER_NAME1);
    }

    @Test
    public void getProducerByIdCheck() {
        Producer producer = new Producer(PRODUCER_NAME1);

        producerManager.addProducer(producer);
        Producer retrievedProducer = producerManager.getProducer(producer.getId());

        assertSame(producer, retrievedProducer);
    }

    @Test
    public void getAllProducersCheck() {
        Producer producer1 = new Producer(PRODUCER_NAME1);
        Producer producer2 = new Producer(PRODUCER_NAME2);
        Producer producer3 = new Producer(PRODUCER_NAME_HANDLES);
        List<Producer> producers = new ArrayList<>();
        producers.add(producer1);
        producers.add(producer2);
        producers.add(producer3);

        producerManager.addAllProducers(producers);
        assertEquals(producerManager.getAllProducers().size(), 3);
    }

    @Test
    public void updateProducerCheck() {
        Producer producer = new Producer(PRODUCER_NAME1);
        producerManager.addProducer(producer);

        producer.setName(PRODUCER_NAME2);
        assertEquals(producerManager.getProducer(PRODUCER_NAME2), producer);
    }

    @Test
    public void deleteProducerCheck() {
        Producer producer = new Producer(PRODUCER_NAME1);
        producerManager.addProducer(producer);

        producerManager.deleteProducer(producer);
        assertEquals(producerManager.getAllProducers().size(), 0);
    }
}
