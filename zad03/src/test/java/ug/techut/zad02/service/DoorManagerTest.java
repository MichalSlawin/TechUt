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
        doorManagerJDBC.clearDoors();
        crdDoorTest();
        doorManagerJDBC.clearDoors();
        addAllDoorsTest();
        printAllDoors();
        findDoorTest();
    }

    private static void crdDoorTest() {
        Door door1 = new Door("Porta", DATE1, true, 16);
        doorManagerJDBC.addDoor(door1);
//        Door door2 = new Door("BRW", DATE2, false, 0);
//        doorManagerJDBC.addDoor(door2);
        Door door3 = new Door("test", DATE1, false, 15);
        doorManagerJDBC.addDoor(door3);

        doorManagerJDBC.deleteDoor(door1.getId());

        if(doorManagerJDBC.getAllDoors().size() == 1) System.out.println("crdDoorTest SUCCESS");
        else System.out.println("crdDoorTest FAILURE");
    }

    private static void addAllDoorsTest() {
        List<Door> doorsList = new ArrayList<>();
        try {
            Date date = new SimpleDateFormat( "yyyy-MM-dd" ).parse( "2012-07-22" );

            doorsList.add(new Door("Porta", date, true, 12));
            doorsList.add(new Door("BRW", date, false, 10));
            doorsList.add(new Door("test", date, false, 15));

        } catch (ParseException e) {
            e.printStackTrace();
        }

        doorManagerJDBC.addAllDoors(doorsList);

        if(doorManagerJDBC.getAllDoors().size() == 3) System.out.println("addAllDoorsTest SUCCESS");
        else System.out.println("addAllDoorsTest FAILURE");

    }

    private static void findDoorTest() {
        List<Door> idDoors = doorManagerJDBC.findDoorById(2);
        printDoors(idDoors);
        if(idDoors.size() > 0) System.out.println("findDoorTest by id SUCCESS");
        else System.out.println("findDoorTest by id FAILURE");

        List<Door> producerDoors = doorManagerJDBC.findDoorByProducer("test");
        printDoors(producerDoors);
        if(producerDoors.size() > 0) System.out.println("findDoorTest by producer SUCCESS");
        else System.out.println("findDoorTest by producer FAILURE");
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
}
