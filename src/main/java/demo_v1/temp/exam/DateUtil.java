package demo_v1.temp.exam;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalUnit;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * <p>
   日期工具类
 * </p>
 *
 * @author ruixin
 * @date 2020-05-06
 */
public class DateUtil {


    /**
     * 测试验证 Main
     * @param args
     */
    public static void main(String[] args) {
        //1、获取指定日期的年份、月份、季度、日期、星期数、是365天中的那一天
        DateVo dateDetail = DateUtil.getDateDetail("2020-04-03");
        System.out.println(dateDetail);

        //增加日期
        String plusDate = plusDate("2020-05-03",1);
        System.out.println(plusDate);//2020-05-04

        //增加日期小时
        String plusDateTime = plusDateTime("2020-05-01 13:11:11",1);
        System.out.println(plusDateTime);//2020-05-01 14:11:11

    }

    /**
     * 获取指定日期的年份、月份、季度、日期、星期数、是365天中的那一天
     * @param date   指定日期   格式:2020-05-19
     * @return  dateDto
     */
    public static DateVo getDateDetail(String date){
        LocalDate localDate = LocalDate.parse(date);
        DateVo dateVo = new DateVo();
        dateVo.setYear(localDate.getYear());
        dateVo.setMonth(localDate.getMonthValue());
        dateVo.setQuarter(getQuarter(localDate.getMonthValue()));
        dateVo.setDay(localDate.getDayOfMonth());
        dateVo.setDayOfWeek(localDate.getDayOfWeek().getValue());
        dateVo.setDayOfYear(localDate.getDayOfYear());
        return dateVo;
    }

    /**
     * 对日期进行增加操作
     * @param date   指定日期   格式:2020-05-19
     * @param num   增加多少天？
     * @return
     */
    public static String plusDate(String date,Integer num){
        LocalDate localDate = LocalDate.parse(date);
        return localDate.plusDays(num).toString();
    }

    /**
     * 对日期小时进行增加操作
     * @param dateTime   指定日期时间   格式:2020-05-19 13:03:12
     * @param num   增加多少小时？
     * @return
     */
    public static String plusDateTime(String dateTime,Integer num){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime localDateTime = LocalDateTime.parse(dateTime,dtf);
        return localDateTime.plusHours(num).format(dtf);
    }

    private static Integer getQuarter(Integer month){
        if (month == 1 || month == 2 || month == 3) {
            return 1;
        } else if (month == 4 || month == 5 || month == 6) {
            return 2;
        } else if (month == 7 || month == 8 || month == 9) {
            return 3;
        } else {
            return 4;
        }
    }
}

class DateVo{

    /**
     * 年份
     */
    private Integer year;

    /**
     * 月份
     */
    private Integer month;

    /**
     * 日期
     */
    private Integer day;

    /**
     * 季度
     */
    private Integer quarter;

    /**
     * 星期数
     */
    private Integer dayOfWeek;

    /**
     * 365天中的哪一天
     */
    private Integer dayOfYear;

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getMonth() {
        return month;
    }

    public void setMonth(Integer month) {
        this.month = month;
    }

    public Integer getDay() {
        return day;
    }

    public void setDay(Integer day) {
        this.day = day;
    }

    public Integer getQuarter() {
        return quarter;
    }

    public void setQuarter(Integer quarter) {
        this.quarter = quarter;
    }

    public Integer getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(Integer dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    public Integer getDayOfYear() {
        return dayOfYear;
    }

    public void setDayOfYear(Integer dayOfYear) {
        this.dayOfYear = dayOfYear;
    }

    @Override
    public String toString() {
        return "DateVo{" +
                "年份=" + year +
                ", 月份=" + month +
                ", 日期=" + day +
                ", 季度=" + quarter +
                ", 星期数=" + dayOfWeek +
                ", 365哪一天=" + dayOfYear +
                '}';
    }
}
