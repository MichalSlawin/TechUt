package ug.techut.zad04.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;
import ug.techut.zad04.domain.Insurance;

import static ug.techut.zad04.service.ProjectUtils.*;
import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/beans.xml" })
@TransactionConfiguration(transactionManager = "txManager", defaultRollback = true)
@Transactional
public class InsuranceManagerTest {
    @Autowired
    InsuranceManager insuranceManager;

    @Test
    public void getInsurancesByDateCheck() {
        Insurance insurance1 = new Insurance(INSURANCE_TYPE1, DATE1, DATE4);
        Insurance insurance2 = new Insurance(INSURANCE_TYPE2, DATE1, DATE3);
        Insurance insurance3 = new Insurance(INSURANCE_TYPE1, DATE3, DATE2);

        insuranceManager.addInsurance(insurance1);
        insuranceManager.addInsurance(insurance2);
        insuranceManager.addInsurance(insurance3);

        assertEquals(insuranceManager.getInsurances(DATE2).size(), 2);
    }

    @Test
    public void updateInsuranceCheck() {
        Insurance insurance1 = new Insurance(INSURANCE_TYPE1, DATE1, DATE4);
        insuranceManager.addInsurance(insurance1);

        insurance1.setType(INSURANCE_TYPE2);
        insuranceManager.updateInsurance(insurance1);
        assertEquals(insuranceManager.getInsurances(INSURANCE_TYPE2).size(), 1);
    }

    @Test
    public void deleteInsuranceCheck() {
        Insurance insurance1 = new Insurance(INSURANCE_TYPE1, DATE1, DATE4);
        insuranceManager.addInsurance(insurance1);

        insuranceManager.deleteInsurance(insurance1);
        assertEquals(insuranceManager.getAllInsurances().size(), 0);
    }
}
