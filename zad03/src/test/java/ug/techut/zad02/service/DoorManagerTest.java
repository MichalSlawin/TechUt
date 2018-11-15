package ug.techut.zad02.service;

import ug.techut.zad02.domain.Door;

import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DoorManagerTest {
    private static final ParsePosition PARSE_POSITION = new ParsePosition(0);
    private static final Date DATE1 = new SimpleDateFormat( "yyyy-MM-dd" ).parse( "2010-05-20", PARSE_POSITION);
    private static final Date DATE2 = new SimpleDateFormat( "yyyy-MM-dd" ).parse( "2012-11-06", PARSE_POSITION);

    private static DoorManagerJDBC doorManagerJDBC = new DoorManagerJDBC();

    public static void main(String [] args) {
        //doorManagerJDBC.clearDoors();
        //crdDoorTest();
        //addAllDoorsTest();
        //printAllDoors();
        printDoors(doorManagerJDBC.findDoorById(0));
        printDoors(doorManagerJDBC.findDoorByProducer("test"));
    }

    private static void crdDoorTest() {
        doorManagerJDBC.addDoor(new Door("Porta", DATE1, true, 16));
        doorManagerJDBC.addDoor(new Door("BRW", DATE1, false, 0));
        doorManagerJDBC.addDoor(new Door("test", DATE1, false, 15));
        doorManagerJDBC.deleteDoor(0);
    }

    private static void addAllDoorsTest() {
        List<Door> doorsList = new ArrayList<>();
        try {
            Date date = new SimpleDateFormat( "yyyy-MM-dd" ).parse( "2012-07-22" );

            doorsList.add(new Door("Porta", date, true, 12));
            doorsList.add(new Door("BRW", date, false, 0));
            doorsList.add(new Door("test", date, false, 15));

            doorManagerJDBC.addAllDoors(doorsList);

        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    private static void printDoors(List<Door> doorsList) {
        for(Door door: doorsList) {
            System.out.println(door);
        }
        System.out.println();
    }

    private static void printAllDoors() {
        List<Door> doorsList = doorManagerJDBC.getAllDoors();
        printDoors(doorsList);
    }

    private static void findDoorTest() {
        printDoors(doorManagerJDBC.findDoorById(1));
        printDoors(doorManagerJDBC.findDoorByProducer("Porta"));
    }
}
