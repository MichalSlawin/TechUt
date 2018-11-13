package ug.techut.zad02.service;

import ug.techut.zad02.domain.Door;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class DoorManagerTest {
    private static DoorManagerJDBC doorManagerJDBC = new DoorManagerJDBC();

    public static void main(String [] args) {
        try {
            Date date = new SimpleDateFormat( "yyyy-MM-dd" ).parse( "2010-05-20" );

            doorManagerJDBC.addDoor(new Door("Porta", date, true, 16));
            doorManagerJDBC.addDoor(new Door("BRW", date, false, 15));
            doorManagerJDBC.addDoor(new Door("test", date, false, 15));
            doorManagerJDBC.deleteDoor(2);

            printAllDoors();

        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    private static void printAllDoors() {
        List<Door> doorsList = doorManagerJDBC.getAllDoors();

        for(Door door: doorsList) {
            System.out.println(door);
        }
    }
}
