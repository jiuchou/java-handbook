/**
 * Copyright (c) 2018 jiuchou. All rights reserved worldwise.
 */
package com.jiuchou.demo.date_jiuchou;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.logging.Logger;

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
        GregorianCalendar cal = new GregorianCalendar();
        cal.setTime(date);
        XMLGregorianCalendar xgc = null;
        try {
            xgc = DatatypeFactory.newInstance().newXMLGregorianCalendar(cal);
        } catch (Exception e) {
            //TODO: handle exception
            e.printStackTrace();
        }
        logger.warning("Covert Date to XMLGregorianCalendar Success!");
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
