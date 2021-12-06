package buzz.yixiaobai.lambda.comsumer;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

/**
 * Consumer 模版
 * @author yixiaobai
 * @version 1.0.0
 */
public class ConsumerDemo {

    @Test
    public void Test(){
       new ConsumerDemo().forEach(Arrays.asList("1", "12", "123", "1234"),
                (str) -> System.out.println(str));
    }

    public <T> void forEach(List<T> list, Consumer<T> c){
        for(T i : list){
            c.accept(i);
        }
    }
}
