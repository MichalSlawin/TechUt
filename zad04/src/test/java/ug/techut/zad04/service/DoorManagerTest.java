package ug.techut.zad04.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;
import ug.techut.zad04.domain.Door;
import ug.techut.zad04.domain.Producer;

import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/beans.xml" })
@TransactionConfiguration(transactionManager = "txManager", defaultRollback = true)
@Transactional
public class DoorManagerTest {

    @Autowired
    DoorManager doorManager;

    @Autowired
    ProducerManager producerManager;

    private static final ParsePosition PARSE_POSITION = new ParsePosition(0);
    private static final Date DATE1 = new SimpleDateFormat( "yyyy-MM-dd" ).parse( "2010-05-20", PARSE_POSITION);
    private static final Date DATE2 = new SimpleDateFormat( "yyyy-MM-dd" ).parse( "2012-11-06", PARSE_POSITION);
    private static final String PRODUCER_NAME1 = "Porta";
    private static final String PRODUCER_NAME2 = "BRW";
    private static final double WEIGHT1 = 100;

    @Test
    public void addProducerDoorCheck() {
        Producer producer = new Producer();
        producer.setName(PRODUCER_NAME1);

        producerManager.addProducer(producer);

        List<Producer> retrievedProducers = producerManager.getAllProducers();

        assertEquals(retrievedProducers.size(), 1);

        Door door = new Door();

        Producer retrievedProducer = producerManager.getProducer(PRODUCER_NAME1);
        assertEquals(retrievedProducer.getName(), PRODUCER_NAME1);

        door.setProducer(producerManager.getProducer(PRODUCER_NAME1));
        door.setProductionDate(DATE1);
        door.setExterior(false);
        door.setWeight(WEIGHT1);

        doorManager.addDoor(door);

        List<Door> retrievedDoors = doorManager.getAllDoors();

        assertEquals(retrievedDoors.size(), 1);
    }


}
