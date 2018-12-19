/**
 * Copyright (c) 2018 jiuchou. All rights reserved worldwise.
 */
package com.jiuchou.demo.date_jiuchou;

import java.util.Calendar;
import java.util.Date;
import java.util.logging.Logger;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

public class DateUtils {
    private final static Logger logger = Logger.getLogger(com.jiuchou.demo.DateUtils.class.getName());

    /**
	 * Class Date covert to XMLGregorianCalendar.
     * 
	 * @param   Date
	 * @return  XMLGregorianCalendar
     * 
     * @author  jiuchou2018@foxmail.com
     * @version 2018.12.20
	 */
	public static XMLGregorianCalendar covertDateToXMLGregorianCalendar(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        DatatypeFactory dtf = null;
        try {
            dtf = DatatypeFactory.newInstance();
        } catch (DatatypeConfigurationException e) {
            logger.warning("Encounter DatatypeConfigurationException, exception message is " + e);
        }
        XMLGregorianCalendar xgc = dtf.newXMLGregorianCalendar();
        xgc.setYear(cal.get(Calendar.YEAR));
        // Calendar.MONTH ranges from 0 to 11(0~11), requiring an additional 1
        xgc.setMonth(cal.get(Calendar.MONTH)+1);
        xgc.setDay(cal.get(Calendar.DAY_OF_MONTH));
        xgc.setHour(cal.get(Calendar.HOUR_OF_DAY));
        xgc.setMinute(cal.get(Calendar.MINUTE));
        xgc.setSecond(cal.get(Calendar.SECOND));
        return xgc;
    } 

	/**
	 * Class XMLGregorianCalendar covert to Date.
     * 
	 * @param XMLGregorianCalendar
	 * @return 
	 */
	public static Date covertXMLGregorianCalendarToDate(XMLGregorianCalendar xgc){
		return xgc.toGregorianCalendar().getTime();
	}
}
