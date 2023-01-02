package buzz.yixiaobai.lambda.chap5;

import org.junit.Test;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * 由值创建流
 */
public class CreateStreamDemo {

    @Test
    public void createStreamDemo01() {
        // 创建一个字符串流
        Stream<String> stream = Stream.of("Modern ", "Java ", "In ", "Action");
        // 将集合中的所有字符串元素转换成大写，并输出
        stream.map(String::toUpperCase).forEach(System.out::println);
    }

    /**
     * 创建一个空的流
     */
    @Test
    public void createNullStream01() {
        Stream<?> stream = Stream.empty();
    }

    /**
     * 当某个属性值为空时，返回一个空的流
     */
    @Test
    public void createIsNullStream01(){
        String homeValue = System.getProperty("home");
        // Java 8 的写法
        Stream<String> homeValueStream = homeValue == null ? Stream.empty() : Stream.of(homeValue);
       // Java 9 新增的方法
        Stream<String> homeValueStream02 = Stream.ofNullable(homeValue);
        System.out.println(homeValue);
    }

    /**
     * 通过flatMap与ofNullable创建一个Stream流
     * flatMap：扁平化一个Stream流
     * ofNullable（Java9方法）：当参数为null返回一个空流
     */
    @Test
    public void createIsNullStream02() {
        Stream<String> values = Stream.of("config", "home", "user")
                .flatMap(key -> Stream.ofNullable(System.getProperty(key)));
        System.out.println(values);
    }

    /**
     * 通过数组创建一个Stream流
     */
    @Test
    public void createArrayStream03() {
        int[] numbers = {2, 3, 5, 7 ,11, 13};
        int sum = Arrays.stream(numbers).sum();
        System.out.println(sum);
    }

    /**
     * 通过一个文件来创建一个文件流
     */
    @Test
    public void createFileStream01() {
        long uniqueWords;
        // 使用Files.lines()获取一个文件流
        // java.nio.file.Files 中的很多静态方法都会返回一个流
        try(Stream<String> lines = Files.lines(Paths.get("data.txt"), Charset.defaultCharset())) {
            // 生成一个单词流
            uniqueWords = lines.flatMap(line -> Arrays.stream(line.split(" ")))
                    // 删除重复的单词
                    .distinct()
                    // 获取不重复的数量
                    .count();
            System.out.println(uniqueWords);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 创建一个无限流
     * 使用无限流
     */
    @Test
    public void createIterateStream() {
        // 通过Stream.iterate()方法创建一个无限流
        Stream.iterate(0, n -> n + 2)
                .limit(100L)
                .forEach(System.out::println);

        Stream.iterate(new int[]{0, 1}, t -> new int[]{t[1], t[0] + t[1]})
                .limit(20L)
                .forEach(t -> System.out.println("(" + t[0] + ", " + t[1] + ") "));

        Stream.iterate(new int[]{0, 1}, t -> new int[]{t[1], t[0] + t[1]})
                .limit(10L)
                .map(t -> t[0])
                .forEach(System.out::println);
        System.out.println("--------------------------------------------------------");
        // Java 9支持的语法
        // 第一个参数是开始值，第二个是表示什么时候停止，第三个表示每次增加多少
        Stream.iterate(0, x -> x < 100, x -> x + 2)
                .forEach(System.out::println);
    }

    /**
     * 使用无限流
     * 输出偶数列表，输出的结果小于100
     * 此方法会造成死循环
     */
    @Test
    public void createIterateStream02() {
        // 此代码根本无法停止
        // filter()会等待iterate()方法执行完成
        // 所以iterate()是个无穷操作，此方法根本无法停止，filter()不会被执行
        IntStream.iterate(0, n -> n + 4)
                .filter(n -> n < 100)
                .forEach(System.out::println);
    }

    /**
     * 使用无限流
     * 输出偶数列表，输出的结果小于100
     * 可以正常的输出
     */
    @Test
    public void createIterateStream03() {
        // Java9 支持的语法
        // 第一个参数是开始值，第二个参数表示什么时候停止，第三个参数表示每次增加多少
        Stream.iterate(0, x -> x < 100, x -> x + 2)
                .forEach(System.out::println);
    }

    /**
     * 使用无限流
     * 输出偶数列表，输出的结果小于100
     * 正常输出
     */
    @Test
    public void createIterateStream04() {
        IntStream.iterate(0, x -> x + 2)
                // Java 9 的方法
                .takeWhile(x -> x < 100)
                .forEach(System.out::println);

    }
}
