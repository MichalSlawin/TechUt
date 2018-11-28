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


}
