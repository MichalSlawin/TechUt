package ug.techut.zad04.service;

import ug.techut.zad04.domain.Door;
import ug.techut.zad04.domain.Producer;

import java.sql.PreparedStatement;
import java.util.List;

public interface DoorManager {
    void clearDoors();
    void addDoor(Door door);
    void deleteDoor(Door door);

    List<Door> getDoors(PreparedStatement preparedStatement);
    List<Door> getAllDoors();
    List<Door> findDoorById(long id);
    List<Door> findDoorByProducer(String producer);



    void clearProducers();
    void addProducer(Producer producer);
    void deleteProducer(Producer producer);

    List<Producer> getAllProducers();


    /* batch insert - transactional */
    void addAllDoors(List<Door> doorsList);
}
