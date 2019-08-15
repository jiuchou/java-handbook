# 时间类型间的转换

```java
import java.util.Date;
import java.util.GregorianCalendar;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

/**
 * DateUtil: class of Coverity Tools for operate time.
 */
public class DateUtil {
    /**
     * Covert Date to XMLGregorianCalendar.
     * 
     * @param date
     *     Date object, default introduced into now time. 
     */
    public static XMLGregorianCalendar covertDateToXMLGregorianCalendar(Date date) {
        GregorianCalendar cal = new GregorianCalendar();
        cal.setTime(date);
        XMLGregorianCalendar xgc = null;
        try {
            xgc = DatatypeFactory.newInstance().newXMLGregorianCalendar(cal);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return xgc;
    }

    /**
     * Covert XMLGregorianCalendar to Date.
     * 
     * @param cal
     *     Date object, default introduced into now time. 
     */
    public static Date covertXMLGregorianCalendarToDate(XMLGregorianCalendar cal) {
        return cal.toGregorianCalendar().getTime();
    }
}
```
