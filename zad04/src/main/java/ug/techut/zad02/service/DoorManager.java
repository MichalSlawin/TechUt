package ug.techut.zad02.service;

import ug.techut.zad02.domain.Door;

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

    /* batch insert - transactional */
    void addAllDoors(List<Door> doorsList);
}
