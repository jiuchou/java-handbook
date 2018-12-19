# 时间类型转换

## 1 时间类型

### 1.1 Date

UTC日期，格式为`"2018-12-20 10:11:22"`

### 1.2 XMLGregorianCalendar

ISO日期(XML格式日期)，格式为`"2018-12-20T10:11:22"`

### 1.3 



## 2 使用说明

在webservice服务接口中，在使用到代码自动生成时xml的时间会转换为java的XMLGregorianCalendar，而程序中使用的却是Date，此时涉及到时间之间的转换。

可根据类型

## 3 XMLGregorianCalendar和Date之间的转换

* Demo展示 [com.jiuchou.demo.date_jiuchou.DateUtil](../AppendixDemo/src/com/jiuchou/demo/date_jiuchou/DateUtil.java)

* 代码实现

  ```bash
  /**
   * Copyright (c) 2018 jiuchou. All rights reserved worldwise.
   */
  package com.jiuchou.demo;
  
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
  ```
