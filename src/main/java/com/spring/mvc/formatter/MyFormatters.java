package com.spring.mvc.formatter;


import lombok.extern.slf4j.Slf4j;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.springframework.format.Formatter;

import java.text.ParseException;
import java.util.Date;
import java.util.Locale;


/**
 * Created by ASUS on 2017/4/20.
 */
@Slf4j
public class MyFormatters implements Formatter<Date> {

    @Override
    public Date parse(String s, Locale locale) throws ParseException {
//        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
//        Date date = format.parse(s);
//        return date;
        log.debug("执行了MyFormatters 中的 转换方法");
        DateTimeFormatter format = DateTimeFormat.forPattern("yyyy-MM-dd");
        //时间解析
        DateTime dateTime = DateTime.parse(s, format);
        return dateTime.toDate();
    }

    @Override
    public String print(Date date, Locale locale) {
        return null;
    }
}
