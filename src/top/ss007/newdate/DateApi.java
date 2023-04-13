package top.ss007.newdate;

import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.time.temporal.TemporalUnit;
import java.util.Date;

public class DateApi {

    public void localDateInspect() {
        LocalDate today = LocalDate.now();
        System.out.println(String.format("today is : %s", today));

        LocalDate date = LocalDate.of(2023, 12, 1);
        System.out.println(String.format("specific day is: %s", date));

//        System.out.println(ZoneId.getAvailableZoneIds());

        LocalDate todayParis = LocalDate.now(ZoneId.of("Europe/Paris"));
        System.out.println(String.format("paris today is: %s", todayParis));

        LocalDate tomorrow = today.plusDays(1);
        System.out.println("tomorrow is :" + tomorrow);

        LocalDate yesterday = today.minusDays(1);
        System.out.println("yesterday is: " + yesterday);

        int dayOfWeek = today.getDayOfWeek().getValue();
        int dayOfMonth = today.getDayOfMonth();
        int dayOfYear = today.getDayOfYear();
        System.out.println(String.format("day of week:%d,month:%d,year:%d", dayOfWeek, dayOfMonth, dayOfYear));

        //Getting date from the base date : 01/01/1970
        LocalDate dateFromBase = LocalDate.ofEpochDay(365);
        System.out.println("date from base:" + dateFromBase);
    }

    public void localTimeInspect() {
        System.out.println("-------------------------LocalDate--------------------------------");
        LocalTime current = LocalTime.now();
        System.out.println(String.format("time is : %s", current));

        LocalTime date = LocalTime.of(10, 1, 1);
        System.out.println(String.format("specific time is: %s", date));

        LocalTime timeParis = LocalTime.now(ZoneId.of("Europe/Paris"));
        System.out.println(String.format("paris time is: %s", timeParis));

        LocalTime nextHour = current.plusHours(1);
        System.out.println("next hour is :" + nextHour);

        LocalTime preHour = current.minusHours(1);
        System.out.println("preHour is: " + preHour);

        int hour = current.getHour();
        int minute = current.getMinute();
        int second = current.getSecond();
        System.out.println(String.format("time of hour:%d,min:%d,sec:%d", hour, minute, second));

        //Getting date from the base date : 01/01/1970
        LocalTime specificSecondTime = LocalTime.ofSecondOfDay(60 * 60);
        System.out.println("3600 second time= " + specificSecondTime);
    }

    public void localDateTimeInspect() {
        System.out.println("--------------------------LocalDateTime-------------------------------");
        LocalDateTime now = LocalDateTime.now();
        System.out.println(String.format("now is : %s", now));

        LocalDateTime date = LocalDateTime.of(2023, 1, 1, 1, 1, 1);
        System.out.println(String.format("specific day is: %s", date));

        LocalDateTime todayParis = LocalDateTime.now(ZoneId.of("Europe/Paris"));
        System.out.println(String.format("paris now is: %s", todayParis));

        LocalDateTime tomorrow = now.plusDays(1);
        System.out.println("tomorrow is :" + tomorrow);
        boolean isAfter = tomorrow.isAfter(now);
        System.out.println("is after :" + isAfter);


        LocalDateTime yesterday = now.minusDays(1);
        System.out.println("yesterday is: " + yesterday);
        boolean isBefore = yesterday.isBefore(now);
        System.out.println("is before :" + isBefore);

        int dayOfWeek = now.getDayOfWeek().getValue();
        int dayOfMonth = now.getDayOfMonth();
        int dayOfYear = now.getDayOfYear();
        System.out.println(String.format("day of week:%d,month:%d,year:%d", dayOfWeek, dayOfMonth, dayOfYear));

        //Getting date from the base date : 01/01/1970
        LocalDateTime dateFromBase = LocalDateTime.ofEpochSecond(60 * 60, 0, ZoneOffset.UTC);
        System.out.println("date from base:" + dateFromBase);

        LocalDateTime with = now.with(TemporalAdjusters.firstDayOfMonth());
        System.out.println("with : " + with);

        long nowUntilNextDay = now.until(tomorrow, ChronoUnit.HOURS);
        System.out.println(String.format("now until next day: %d hours ", nowUntilNextDay));


        String formatNow = now.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        System.out.println("format now: " + formatNow);

    }

    public void periodInspect() {
        System.out.println("--------------------------Period-------------------------------");
        Period fiveDays = Period.ofDays(5);
        System.out.println("period:" + fiveDays);

        LocalDate startDate = LocalDate.of(2023, 01, 01);
        LocalDate endDate = LocalDate.of(2024, 02, 10);
        Period between = Period.between(startDate, endDate);
        System.out.println("between1:" + between.getDays());

        long betweenDays = ChronoUnit.DAYS.between(startDate, endDate);
        System.out.println("between2:" + betweenDays);

    }

    public void durationInspect() {
        System.out.println("-------------------------Duration-------------------------------");

        Duration duration = Duration.ofHours(2);

        LocalTime start = LocalTime.of(1, 0, 0);
        LocalTime end = start.plus(duration);

        System.out.println("add: " + start + "---" + end);

        Duration between1 = Duration.between(start, end);
        System.out.println("between1:"+ between1.getSeconds());

        long between2 = ChronoUnit.SECONDS.between(start, end);
        System.out.println("between2:"+ between1.getSeconds());
    }

    public void localDateTime2Date(){
        System.out.println("-------------------------LocalDateTime 2 Date-------------------------------");

        LocalDateTime localDateTime = LocalDateTime.of(2023, 01, 01, 01, 01, 01);
        Instant instant = localDateTime.atZone(ZoneId.systemDefault()).toInstant();
        Date date = Date.from(instant);
        System.out.println("Date:"+ new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date));
    }

    public void date2LocalDateTime(){
        System.out.println("-------------------------Date 2 LocalDateTime-------------------------------");

        Date date = new Date();
        LocalDateTime localDateTime = LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault());
        System.out.println("LocalDateTime:"+ localDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
    }


    public void runTest() {
        localDateInspect();
        localTimeInspect();
        localDateTimeInspect();
        periodInspect();
        durationInspect();
        localDateTime2Date();
        date2LocalDateTime();
    }
}
