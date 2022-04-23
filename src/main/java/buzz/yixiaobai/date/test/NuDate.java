package buzz.yixiaobai.date.test;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.zone.ZoneRulesProvider;

/**
 * Java8 新的日期API
 */
public class NuDate {

    public static void main(String[] args) throws InterruptedException {
        // 获取当前时间
        Instant start = Instant.now();
        Thread.sleep(2000);
        Instant end = Instant.now();
        // getEpochSecond() 获取毫秒
        System.out.println("开始时间：" + start.getEpochSecond());
        System.out.println("结束时间：" + end.getEpochSecond());

        // 将时间转换成代时区的时间
        ZonedDateTime dtUTC = ZonedDateTime.ofInstant(start, ZoneId.of("UTC"));
        System.out.println(dtUTC);

        // 获取当前系统时区时间
        ZonedDateTime dtSH = start.atZone(ZoneId.systemDefault());
        System.out.println(dtSH);

        // 列出所有支持的时区
        System.out.println(ZoneRulesProvider.getAvailableZoneIds());

        // 新的时间formatter
        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        System.out.println("上海本地的时间：" + df.format(dtSH));
    }
}
