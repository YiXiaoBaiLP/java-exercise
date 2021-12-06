package buzz.yixiaobai.lambda.predicate;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * Predicate 模版
 * @author yixiaobai
 * @version 1.0.0
 */
public class PredicateDemo {

    public <T> List<T> filter(List<T> list, Predicate<T> p){
        List<T> result = new ArrayList<>();
        for(T t : list){
            if(p.test(t))
                result.add(t);
        }
        return result;
    }

    @Test
    public void test(){
        Predicate<String> nonEmptyStringPredicate = (String s) -> !s.isEmpty();
        List<String> nonEmpty = filter(Arrays.asList("12", "", "123"),
                nonEmptyStringPredicate);
        nonEmpty.forEach(System.out::println);
    }
}
