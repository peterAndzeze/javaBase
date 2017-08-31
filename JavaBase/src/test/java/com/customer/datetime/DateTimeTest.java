package com.customer.datetime;

import com.customer.date.DateTime;
import org.junit.Before;
import org.junit.Test;

public class DateTimeTest {
    private DateTime dateTime;
    @Before
    public void init(){
        dateTime=new DateTime();
    }
    @Test
    public void getCurrentUTC(){
        dateTime.getCurrentUTC();
    }

    @Test
    public void getLocalDateTest(){
        dateTime.getLocalDateNow();
    }


    @Test
    public void getLocalDateTimeTest(){
        dateTime.localDateTime();
    }

}
