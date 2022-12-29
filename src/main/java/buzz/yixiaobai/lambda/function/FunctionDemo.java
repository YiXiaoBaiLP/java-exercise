package buzz.yixiaobai.lambda.function;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

/**
 * Function 模版
 * @author yixiaobai
 * @version 1.0.0
 */
public class FunctionDemo {

    @Test
    public void test(){
        List<Integer> strList = new FunctionDemo().map(Arrays.asList("1", "12", "123", "1234"),
                (String str) -> str.length());
        strList.stream()
                .limit(2)
                .forEach(System.out::println);
    }

    /**
     * 获取集合中每个元素的长度
     * @param list 集合
     * @param f 函数方法
     * @param <T> 集合中的类型
     * @param <R> 返回值类型
     * @return
     */
    public <T, R> List<R> map(List<T> list, Function<T, R> f){
        List<R> result = new ArrayList<>();
        for(T t : list){
            result.add(f.apply(t));
        }
        return result;
    }
}
