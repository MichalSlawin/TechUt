package ug.tech_ut.zad02.service;

import ug.tech_ut.zad02.domain.Door;

import java.util.List;

public interface DoorManager {
    public int addDoor(Door door);
    public List<Door> getAllDoors();

    /* batch insert - transactional */
    public void addAllDoors(List<Door> doorsList);
}
