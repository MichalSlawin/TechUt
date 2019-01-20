package ug.techut.zad04.service;

import ug.techut.zad04.domain.Insurance;

import java.util.Date;
import java.util.List;

public interface InsuranceManager {
    void addInsurance(Insurance insurance);
    void deleteInsurance(Insurance insurance);
    void updateInsurance(Insurance insurance);

    List<Insurance> getAllInsurances();
    List<Insurance> getInsurances(Date date);
    List<Insurance> getInsurances(String type);
    Insurance getInsurance(Long id);
}
