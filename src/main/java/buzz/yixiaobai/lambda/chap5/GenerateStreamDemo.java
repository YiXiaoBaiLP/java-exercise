package buzz.yixiaobai.lambda.chap5;

import org.junit.Test;

import java.util.function.IntSupplier;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * 生成一个无限流
 */
public class GenerateStreamDemo {

    @Test
    public void createGenerateStream01() {
        // 生成一个0-1之间的无限流
        Stream.generate(Math::random)
                // 限制流的大小，否则会无限创建
                .limit(7)
                .forEach(System.out::println);
    }

    /**
     * 生成一个全是1的无限流
     */
    @Test
    public void createGenerateStream02() {
        // 生成一个全是1的无限流
        IntStream one = IntStream.generate(() -> 1);
        System.out.println(one);
        IntStream two = IntStream.generate(new IntSupplier(){
            public int getAsInt(){
                return 2;
            }
        });
        System.out.println(two);
    }

    /**
     * 使用无限流，创建斐波那契数
     */
    @Test
    public void createGenerateStream03() {
        IntSupplier fib = new IntSupplier() {
            private int previous = 0;
            private int current = 1;

            @Override
            public int getAsInt() {
                int oldPrevious = this.previous;
                int nextValue = this.current + this.previous;
                this.previous = this.current;
                this.current = nextValue;
                return oldPrevious;
            }
        };
        IntStream.generate(fib)
                // 限制流的大小
                .limit(10)
                .forEach(System.out::println);
    }
}
