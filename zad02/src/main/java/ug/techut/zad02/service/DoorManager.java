package ug.techut.zad02.service;

import ug.techut.zad02.domain.Door;

import java.util.List;

public interface DoorManager {
    public int addDoor(Door door);
    public int deleteDoor(int id);
    public List<Door> getAllDoors();

    /* batch insert - transactional */
    public void addAllDoors(List<Door> doorsList);
}
