package ug.techut.zad04.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;
import ug.techut.zad04.domain.*;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static ug.techut.zad04.service.ProjectUtils.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/beans.xml" })
@TransactionConfiguration(transactionManager = "txManager", defaultRollback = true)
@Transactional
public class DoorManagerTest {

    @Autowired
    DoorManager doorManager;

    @Autowired
    ProducerManager producerManager;

    @Autowired
    HandlesManager handlesManager;

    @Autowired
    InsuranceManager insuranceManager;

    @Autowired
    LockManager lockManager;

    private static final double DELTA = 1e-15;

    @Test
    public void addDeleteDoorCheck() {
        producerManager.addProducer(new Producer(PRODUCER_NAME1));
        Producer handlesProducer = new Producer(PRODUCER_NAME_HANDLES);
        producerManager.addProducer(handlesProducer);
        Producer lockProducer = new Producer(PRODUCER_NAME_LOCK);
        producerManager.addProducer(lockProducer);

        Handles handles = new Handles(handlesProducer, HANDLES_SHAPE1);
        handlesManager.addHandles(handles);

        Insurance insurance1 = new Insurance(INSURANCE_TYPE1, DATE1, DATE3);
        insuranceManager.addInsurance(insurance1);
        Insurance insurance2 = new Insurance(INSURANCE_TYPE2, DATE2, DATE4);
        insuranceManager.addInsurance(insurance2);
        List<Insurance> insurances = new ArrayList<>();
        insurances.add(insurance1);
        insurances.add(insurance2);

        Lock lock = new Lock(lockProducer, false);
        List<Lock> locks = new ArrayList<>();
        locks.add(lock);

        Door door = new Door();
        door.setProducer(producerManager.getProducer(PRODUCER_NAME1));
        door.setProductionDate(DATE1);
        door.setExterior(false);
        door.setWeight(WEIGHT1);
        door.setHandles(handles);
        door.setInsurance(insurances);
        door.setLock(locks);

        doorManager.addDoor(door);
        List<Door> retrievedDoors = doorManager.getAllDoors();
        assertEquals(retrievedDoors.size(), 1);

        Door retrievedDoor = doorManager.getDoor(door.getId());
        assertNotNull(retrievedDoor.getProducer());
        assertNotNull(retrievedDoor.getHandles());
        assertNotNull(retrievedDoor.getInsurance());
        assertNotNull(retrievedDoor.getLock());

        doorManager.deleteDoor(door);
        assertEquals(doorManager.getAllDoors().size(), 0);
    }

    @Test
    public void getDoorsByExteriorCheck() {
        producerManager.addProducer(new Producer(PRODUCER_NAME1));
        producerManager.addProducer(new Producer(PRODUCER_NAME2));

        Door door1 = new Door();
        door1.setProducer(producerManager.getProducer(PRODUCER_NAME1));
        door1.setProductionDate(DATE1);
        door1.setExterior(false);
        door1.setWeight(WEIGHT1);
        doorManager.addDoor(door1);

        Door door2 = new Door();
        door2.setProducer(producerManager.getProducer(PRODUCER_NAME2));
        door2.setProductionDate(DATE2);
        door2.setExterior(true);
        door2.setWeight(WEIGHT2);
        doorManager.addDoor(door2);

        List<Door> exteriorDoors = doorManager.getDoors(true);
        assertEquals(exteriorDoors.size(), 1);

        Door retrievedDoor = exteriorDoors.get(0);
        assertEquals(retrievedDoor.getProducer().getName(), PRODUCER_NAME2);
    }

    @Test
    public void updateDoorCheck() {
        Door door = new Door();
        door.setProductionDate(DATE2);
        door.setExterior(true);
        door.setWeight(WEIGHT2);
        doorManager.addDoor(door);

        door.setWeight(WEIGHT1);

        doorManager.updateDoor(door);

        assertEquals(door.getWeight(), WEIGHT1, DELTA);
    }

}
