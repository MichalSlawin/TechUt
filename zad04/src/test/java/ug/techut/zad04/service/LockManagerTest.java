package ug.techut.zad04.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;
import ug.techut.zad04.domain.Lock;
import ug.techut.zad04.domain.Producer;
import static org.junit.Assert.assertEquals;

import java.util.List;

import static ug.techut.zad04.service.ProjectUtils.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/beans.xml" })
@TransactionConfiguration(transactionManager = "txManager", defaultRollback = true)
@Transactional
public class LockManagerTest {
    @Autowired
    LockManager lockManager;
    @Autowired
    ProducerManager producerManager;

    @Test
    public void getLocksByExteriorCheck() {
        Producer producer = new Producer(PRODUCER_NAME_LOCK);
        producerManager.addProducer(producer);
        lockManager.addLock(new Lock(producer, true));
        lockManager.addLock(new Lock(producer, true));
        lockManager.addLock(new Lock(producer, false));

        List<Lock> retrievedLocks = lockManager.getLocks(true);
        assertEquals(retrievedLocks.size(), 2);
    }

    @Test
    public void getLocksByProducerCheck() {
        Producer producer1 = new Producer(PRODUCER_NAME_LOCK);
        producerManager.addProducer(producer1);
        lockManager.addLock(new Lock(producer1, true));

        lockManager.addLock(new Lock(producer1, false));

        Producer producer2 = new Producer(PRODUCER_NAME1);
        producerManager.addProducer(producer2);
        lockManager.addLock(new Lock(producer2, false));


        List<Lock> retrievedLocks = lockManager.getLocks(producer1);
        assertEquals(retrievedLocks.size(), 2);
    }

    @Test
    public void updateLocksCheck() {
        Producer producer1 = new Producer(PRODUCER_NAME_LOCK);
        producerManager.addProducer(producer1);
        Lock lock = new Lock(producer1, true);
        lockManager.addLock(lock);

        lock.setElectronic(false);
        lockManager.updateLock(lock);

        assertEquals(lockManager.getLocks(false).size(), 1);
    }

    @Test
    public void deleteLocksCheck() {
        Producer producer1 = new Producer(PRODUCER_NAME_LOCK);
        producerManager.addProducer(producer1);
        Lock lock = new Lock(producer1, true);
        lockManager.addLock(lock);

        lockManager.deleteLock(lock);

        assertEquals(lockManager.getAllLocks().size(), 0);
    }

}
