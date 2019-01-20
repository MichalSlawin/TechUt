package ug.techut.zad04.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;
import ug.techut.zad04.domain.Handles;
import ug.techut.zad04.domain.Producer;

import static org.junit.Assert.assertEquals;
import static ug.techut.zad04.service.ProjectUtils.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/beans.xml" })
@TransactionConfiguration(transactionManager = "txManager", defaultRollback = true)
@Transactional
public class HandlesManagerTest {
    @Autowired
    HandlesManager handlesManager;

    @Autowired
    ProducerManager producerManager;

    @Test
    public void getHandlesByShapeCheck() {
        Producer handlesProducer = new Producer(PRODUCER_NAME_HANDLES);
        producerManager.addProducer(handlesProducer);
        handlesManager.addHandles(new Handles(handlesProducer, HANDLES_SHAPE1));
        handlesManager.addHandles(new Handles(handlesProducer, HANDLES_SHAPE1));
        handlesManager.addHandles(new Handles(handlesProducer, HANDLES_SHAPE2));

        assertEquals(handlesManager.getHandles(HANDLES_SHAPE1).size(), 2);
    }

    @Test
    public void updateHandlesCheck() {
        Producer handlesProducer = new Producer(PRODUCER_NAME_HANDLES);
        producerManager.addProducer(handlesProducer);
        Handles handles = new Handles(handlesProducer, HANDLES_SHAPE1);
        handlesManager.addHandles(handles);

        handles.setShape(HANDLES_SHAPE2);
        handlesManager.updateHandles(handles);

        assertEquals(handlesManager.getHandles(HANDLES_SHAPE2).size(), 1);
    }

    @Test
    public void deleteHandlesCheck() {
        Producer handlesProducer = new Producer(PRODUCER_NAME_HANDLES);
        producerManager.addProducer(handlesProducer);
        Handles handles = new Handles(handlesProducer, HANDLES_SHAPE1);
        handlesManager.addHandles(handles);

        handlesManager.deleteHandles(handles);

        assertEquals(handlesManager.getAllHandles().size(), 0);
    }
}
