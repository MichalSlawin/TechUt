package ug.techut.zad04.service;

import java.text.DateFormat;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

class ProjectUtils {
     private static final ParsePosition PARSE_POSITION = new ParsePosition(0);
     private static final DateFormat parser = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
     static final Date DATE1 = parser.parse( "2010-05-20", PARSE_POSITION);
     private static final ParsePosition PARSE_POSITION1 = new ParsePosition(0);
     static final Date DATE2 = parser.parse( "2012-11-06", PARSE_POSITION1);
     private static final ParsePosition PARSE_POSITION2 = new ParsePosition(0);
     static final Date DATE3 = parser.parse( "2012-05-20", PARSE_POSITION2);
     private static final ParsePosition PARSE_POSITION3 = new ParsePosition(0);
     static final Date DATE4 = parser.parse( "2014-11-06", PARSE_POSITION3);
     static final String PRODUCER_NAME1 = "Porta";
     static final String PRODUCER_NAME2 = "BRW";
     static final String PRODUCER_NAME_HANDLES = "Klamkotron";
     static final String PRODUCER_NAME_LOCK = "Zamkonix";
     static final double WEIGHT1 = 100;
     static final double WEIGHT2 = 120;
     static final String HANDLES_SHAPE1 = "Straight";
     static final String HANDLES_SHAPE2 = "Curved";
     static final String INSURANCE_TYPE1 = "In case of bears attack";
     static final String INSURANCE_TYPE2 = "In case of robbery";
}
