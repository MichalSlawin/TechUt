package ug.techut.zad04.service;

import ug.techut.zad04.domain.Door;
import ug.techut.zad04.domain.Producer;

import java.sql.PreparedStatement;
import java.util.List;

public interface DoorManager {
    void addDoor(Door door);
    void deleteDoor(Door door);

    List<Door> getDoors(PreparedStatement preparedStatement);
    List<Door> getAllDoors();
    Door getDoor(Long id);
    List<Door> getDoors(boolean exterior);

    /* batch insert - transactional */
    void addAllDoors(List<Door> doorsList);
}
