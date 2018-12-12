package ug.techut.zad04.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;
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

    private static final ParsePosition PARSE_POSITION = new ParsePosition(0);
    private static final Date DATE1 = new SimpleDateFormat( "yyyy-MM-dd" ).parse( "2010-05-20", PARSE_POSITION);
    private static final Date DATE2 = new SimpleDateFormat( "yyyy-MM-dd" ).parse( "2012-11-06", PARSE_POSITION);

    @Test
    public void addProducerCheck() {
        Producer producer = new Producer();
        producer.setName("Porta");

        doorManager.addProducer(producer);

        List<Producer> retrievedProducers = doorManager.getAllProducers();

        assertEquals(retrievedProducers.size(), 1);
    }

}
