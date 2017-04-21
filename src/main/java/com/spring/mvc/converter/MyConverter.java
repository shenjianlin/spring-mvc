package com.spring.mvc.converter;

import lombok.extern.slf4j.Slf4j;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.springframework.core.convert.converter.Converter;

import java.util.Date;

/**
 * Created by ASUS on 2017/4/20.
 */
@Slf4j
public class MyConverter implements Converter<String, Date> {

    @Override
    public Date convert(String s) {
        log.debug("执行了 MyConverter 中的 转换方法");
        DateTimeFormatter format = DateTimeFormat.forPattern("yyyy-MM-dd");
        //时间解析
        DateTime dateTime = DateTime.parse(s, format);
        return dateTime.toDate();
    }
}